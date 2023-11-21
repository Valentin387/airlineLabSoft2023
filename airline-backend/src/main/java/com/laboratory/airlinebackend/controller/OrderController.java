package com.laboratory.airlinebackend.controller;
import com.laboratory.airlinebackend.controller.DTO.*;
import com.laboratory.airlinebackend.controller.service.EmailSenderService;
import com.laboratory.airlinebackend.model.*;
import com.laboratory.airlinebackend.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/order")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class OrderController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/findPassenger")
    public ResponseEntity<?> findPassenger(
            @RequestParam String DNI
    ){
        try{
            //get the user by DNI
            Optional<User> OptionalUser = userRepository.findByDNI(DNI);
            if (OptionalUser.isEmpty()) {
                return ResponseEntity.badRequest().body("User not found");
            }
            User user = OptionalUser.get();

            //create a UserDniMatchDTO object
            UserDniMatchDTO userDniMatchDTO = UserDniMatchDTO.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .birthday(user.getBirthday())
                    .gender(user.getGender())
                    .email(user.getEmail())
                    .build();

            return ResponseEntity.ok(userDniMatchDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("That passenger is not a registered user " + e.getMessage());
        }
    }


    @Transactional
    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(
            @RequestBody RegisterRequestOrder requestNewOrder
    ){
        try{

            //do the payment
            //get the card
            Card card = cardRepository.getCardById(requestNewOrder.getCardID());
            if (card == null) {
                return ResponseEntity.badRequest().body("Card not found");
            }
            //check if the card's balance is enough
            if (card.getBalance() < requestNewOrder.getTotalAmount()){
                return ResponseEntity.badRequest().body("Insufficient funds");
            }else{
                //update the card's balance
                card.setBalance(card.getBalance() - requestNewOrder.getTotalAmount());
                cardRepository.save(card);
            }

            // Generate a random UUID and remove hyphens to get a continuous string
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");

            // Take a substring of the UUID to get a shorter reference, e.g., 6 characters
            String bookingReference = uuid.substring(0, 6);

            //get user by ID
            Optional<User> OptionalUser = userRepository.findById(requestNewOrder.getUserID());
            if (OptionalUser.isEmpty()) {
                return ResponseEntity.badRequest().body("User not found");
            }
            User user = OptionalUser.get();

            //get shoppingCart by looking into the user's shoppingCartID
            long shoppingCartID = user.getShoppingCartID();
            ShoppingCart shoppingCart = shoppingCartRepository.getShoppingCartByID(shoppingCartID);

            //create a new order
            Order order = Order.builder()
                    //.COD(bookingReference)
                    .userID(user.getID())
                    .shoppingCartID(shoppingCartID)
                    .cardID(card.getId())
                    .totalAmount(requestNewOrder.getTotalAmount())
                    .date(new Date())
                    .paymentDetails(requestNewOrder.getPaymentDetails())
                    .build();
            //save the order
            orderRepository.save(order);
            long orderID = order.getID();

            //concatenate the orderID with the bookingReference
            String COD = bookingReference + '#' +orderID;
            System.out.println("COD: " + COD);
            order.setCOD(COD);
            orderRepository.save(order);

            //5. crear nuevo shopping cart y asignarlo al usuario
            ShoppingCart newShoppingCart = ShoppingCart.builder()
                    .quantity(0)
                    .totalAmount(0.0)
                    .build();
            shoppingCartRepository.save(newShoppingCart);
            user.setShoppingCartID(newShoppingCart.getID());



            //book the seats
            List<OrderFlightInfo> orderFlightInfoList = requestNewOrder.getOrderFlightInfoList();
            //for each orderFlightInfo in orderFlightInfoList, get the flight and the passengerList
            //for every flight purchased
            for (OrderFlightInfo ofi :  orderFlightInfoList ){
                //OrderFlightInfo orderFlightInfo = ofi;
                //get the flight by ID
                Flight flight = flightRepository.getFlightById(ofi.getFlightID());
                if (flight == null) {
                    return ResponseEntity.badRequest().body("Flight not found");
                }
                //get the passengerList
                List<PassengerPlusSeat> passengerList = ofi.getPassengerList();
                //for each passenger in passengerList, get the seat by seatID

                for (PassengerPlusSeat passengerPlusSeat : passengerList) {

                    Passenger passenger = Passenger.builder()
                            .DNI(passengerPlusSeat.getDNI())
                            .firstName(passengerPlusSeat.getFirstName())
                            .lastName(passengerPlusSeat.getLastName())
                            .birthday(passengerPlusSeat.getBirthday())
                            .gender(passengerPlusSeat.getGender())
                            .cellphoneNo(passengerPlusSeat.getCellphoneNo())
                            .email(passengerPlusSeat.getEmail())
                            .contactName(passengerPlusSeat.getContactName())
                            .contactNo(passengerPlusSeat.getContactNo())
                            .didCheckIn(Boolean.FALSE)
                            .build();
                    //save the passenger
                    passengerRepository.save(passenger);
                    //set the passengerID in their respective seat
                    Seat seat = seatRepository.getSeatById(passengerPlusSeat.getSeatID());
                    seat.setState(SeatState.BOOKED.toString());
                    seat.setPassengerId(passenger.getID());
                    seatRepository.save(seat);
                    //update the flight's available seats
                    flight.setAvailableSeats(flight.getAvailableSeats() - 1);

                    //send e-mail to the passenger with the flight info

                    try {
                        String body = "Estimado/a usuario/a,\n" +
                                "\n" +
                                "El equipo de AirTravelLabSoft le comunica que ha sido asignado como pasajero en un vuelo.\n" +
                                "\n" +
                                "Podrá hacer check-in ingresando a nuestra página, módulo de check-in e ingresando su DNI y el siguiente código:\n" +
                                "\n" +
                                COD + "\n" +
                                "\n" +
                                "Le agradecemos por confiar en nuestros servicios y estamos aquí para ayudarle en caso de cualquier duda o inquietud.\n" +
                                "\n" +
                                "Atentamente.";
                        emailSenderService.sendEmail(passenger.getEmail(),
                                "Código de confirmación de asiento", body);
                    } catch (Exception e) {
                        return ResponseEntity.badRequest().body("Error sending the e-mail " + e.getMessage());

                    }


                }



            }


            return ResponseEntity.ok("Purchase carried out successfully");
        }catch (Exception e){
            e.printStackTrace(); // Add this line to print the exception details
            return ResponseEntity.badRequest().body("Error during the purchase process " + e.getMessage());
        }
    }


    @GetMapping("/list")
    public ResponseEntity<?> list(
            @RequestParam long userID
    ){
        try{
            List<Order> orderList = orderRepository.findByUserID(userID);
            return ResponseEntity.ok(orderList);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error listing the orders " + e.getMessage());
        }
    }


    @Transactional
    @GetMapping("/testEmail")
    public ResponseEntity<?> testEmail(
            @RequestParam String email
    ){
        try{
            String body = "Estimado/a usuario/a,\n" +
                    "\n" +
                    "El equipo de AirTravelLabSoft le comunica que ha sido asignado como pasajero en un vuelo.\n" +
                    "\n" +
                    "Podrá hacer check-in ingresando a nuestra página, módulo de check-in e ingresando su DNI y el siguiente código:\n" +
                    "\n" +
                    "COD" + "\n" +
                    "\n" +
                    "Le agradecemos por confiar en nuestros servicios y estamos aquí para ayudarle en caso de cualquier duda o inquietud.\n" +
                    "\n" +
                    "Atentamente.";
            emailSenderService.sendEmail(email,
                    "Código de confirmación de asiento", body);
            return ResponseEntity.ok("Email sent successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error sending the e-mail " + e.getMessage());
        }
    }


}
