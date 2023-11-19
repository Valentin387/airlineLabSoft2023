package com.laboratory.airlinebackend.controller;
import com.laboratory.airlinebackend.controller.DTO.ReservationDetailsDTO;
import com.laboratory.airlinebackend.controller.DTO.ReserveFlightDTO;
import com.laboratory.airlinebackend.controller.DTO.SeatState;
import com.laboratory.airlinebackend.model.*;
import com.laboratory.airlinebackend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/reservation")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class ReservationController {


    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoppingCartSeatsRepository shoppingCartSeatsRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;



    @PostMapping("/reserve")
    public ResponseEntity<?> reserveFlight (
            @RequestBody ReserveFlightDTO reserveFlightDTO
    ){
        try{
            List<Seat> seats0 = new ArrayList<>();
            seats0 = seatRepository.getSeatsByFlightId(reserveFlightDTO.getFlightID());

            //I need only the setas with seatClass = reserveFlightDTO.getSeatClass()
            List<Seat> seats = new ArrayList<>();
            //filter seats0
            for (Seat seat : seats0) {
                if (seat.getSeatClass().equals(reserveFlightDTO.getSeatClass())) {
                    seats.add(seat);
                }
            }

            //I want to do a for loop on seats, for selecting randomly a quantity of seatQuantity seats
            //and then change the state of those seats to RESERVED
            //and then save the seats in the database

            for (int i = 0; i < reserveFlightDTO.getSeatQuantity(); i++) {
                int randomIndex = (int) (Math.random() * seats.size());
                Seat seat = seats.get(randomIndex);
                seat.setState(SeatState.RESERVED.toString());

                Reservation reservation = Reservation.builder()
                        .IDSeat(seat.getID())
                        //get current Date
                        .reservationDate(new Date())
                        .expirationDate(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                        .IDUser(reserveFlightDTO.getUserID())
                        .build();

                seatRepository.save(seat);
                reservationRepository.save(reservation);
                seats.remove(randomIndex);
            }
            return ResponseEntity.ok("Flight reserved succesfully");

        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error reserving flight");
        }


    }

    @GetMapping("/list/{userID}")
    public ResponseEntity<?> getReservationsByUserID(
            @PathVariable("userID") Long userID
    ){
        try{
            int count = 0;
            List<Object[]> results = reservationRepository.getReservationsByUserId(userID);
            List<ReservationDetailsDTO> reservations = new ArrayList<>();
            for (Object[] result : results) {
                ReservationDetailsDTO reservationDetailsDTO = ReservationDetailsDTO.builder()
                        .reservationDate((Date) result[0])
                        .expirationDate((Date) result[1])
                        .origin((String) result[2])
                        .destination((String) result[3])
                        .flightDate((Date) result[4])
                        .state((String) result[5])
                        .costByPerson((Double) result[6])
                        .costByPersonOffer((Double) result[7])
                        //.seats((List<Seat>) result[8])
                        .build();
                reservations.add(reservationDetailsDTO);
                //print every attribute of the reservationDetailsDTO
                System.out.println(count);
                System.out.println(reservationDetailsDTO.getReservationDate());
                System.out.println(reservationDetailsDTO.getExpirationDate());
                System.out.println(reservationDetailsDTO.getOrigin());
                System.out.println(reservationDetailsDTO.getDestination());
                System.out.println(reservationDetailsDTO.getFlightDate());
                System.out.println(reservationDetailsDTO.getState());
                System.out.println(reservationDetailsDTO.getCostByPerson());
                System.out.println(reservationDetailsDTO.getCostByPersonOffer());
                //System.out.println(reservationDetailsDTO.getSeats());
                System.out.println(" ");
                count++;

            }
            return ResponseEntity.ok(reservations);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error getting reservations");
        }
    }

    @PostMapping("/cancel")
    public ResponseEntity<?> cancelReservation(
            @RequestParam  long reservationID
    ){
        try{
            //get the reservation
            Optional<Reservation> OptionalReservation = reservationRepository.findById(reservationID);
            if (OptionalReservation.isEmpty()) {
                return ResponseEntity.badRequest().body("Reservation not found");
            }
            Reservation reservation = OptionalReservation.get();

            //get the seat
            Optional <Seat> OptionalSeat = seatRepository.findById(reservation.getIDSeat());
            if (OptionalSeat.isEmpty()) {
                return ResponseEntity.badRequest().body("Seat not found");
            }
            Seat seat = OptionalSeat.get();
            //change the state of the seat to AVAILABLE
            seat.setState(SeatState.AVAILABLE.toString());
            //delete the reservation
            reservationRepository.delete(reservation);
            //save the seat
            seatRepository.save(seat);
            return ResponseEntity.ok("Reservation cancelled succesfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error cancelling reservation");
        }
    }

    @PostMapping("/move-to-cart")
    public ResponseEntity<?> move_to_cart(
            @RequestParam  long reservationID,
            @RequestParam  long userID
    ) {
        try{
            //get the reservation
            Optional<Reservation> OptionalReservation = reservationRepository.findById(reservationID);
            if (OptionalReservation.isEmpty()) {
                return ResponseEntity.badRequest().body("Reservation not found");
            }
            Reservation reservation = OptionalReservation.get();

            //get the seat
            Optional <Seat> OptionalSeat = seatRepository.findById(reservation.getIDSeat());
            if (OptionalSeat.isEmpty()) {
                return ResponseEntity.badRequest().body("Seat not found");
            }
            Seat seat = OptionalSeat.get();
            //change the state of the seat to AVAILABLE
            seat.setState(SeatState.AVAILABLE.toString());

            //delete the reservation
            reservationRepository.delete(reservation);
            //save the seat
            seatRepository.save(seat);

            //get the user
            Optional <User> OptionalUser = userRepository.findById(userID);
            if (OptionalUser.isEmpty()) {
                return ResponseEntity.badRequest().body("User not found");
            }
            User user = OptionalUser.get();

            //get the shopping cart
            Optional <ShoppingCart> OptionalShoppingCart = shoppingCartRepository.findById(user.getShoppingCartID());
            if (OptionalShoppingCart.isEmpty()) {
                return ResponseEntity.badRequest().body("Shopping cart not found");
            }
            ShoppingCart shoppingCart = OptionalShoppingCart.get();

            //get the flight
            Optional <Flight> OptionalFlight = flightRepository.findById(seat.getFlightId());
            if (OptionalFlight.isEmpty()) {
                return ResponseEntity.badRequest().body("Flight not found");
            }
            Flight flight = OptionalFlight.get();

            double UnitPrice;
            if (flight.getCostByPersonOffer() != 0) {
                UnitPrice = flight.getCostByPersonOffer();
            } else {
                UnitPrice = flight.getCostByPerson();
            }

            ShoppingCartSeats shoppingCartSeats = ShoppingCartSeats.builder()
                    .seatID(seat.getID())
                    .shoppingCartID(shoppingCart.getID())
                    .unitPrice(UnitPrice)
                    .build();

            shoppingCartSeatsRepository.save(shoppingCartSeats);
            shoppingCart.setQuantity(shoppingCart.getQuantity() + 1);
            shoppingCart.setTotalAmount(shoppingCart.getTotalAmount() + UnitPrice);
            shoppingCartRepository.save(shoppingCart);

            return ResponseEntity.ok("Reservation moved to shopping cart successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error moving reservation to shopping cart");
        }

    }


}
