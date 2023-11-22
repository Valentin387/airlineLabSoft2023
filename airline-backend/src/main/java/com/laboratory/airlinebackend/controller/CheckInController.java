package com.laboratory.airlinebackend.controller;
import com.laboratory.airlinebackend.controller.service.EmailSenderService;
import com.laboratory.airlinebackend.model.Order;
import com.laboratory.airlinebackend.model.Passenger;
import com.laboratory.airlinebackend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/check-in")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class CheckInController {

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

    @Autowired
    private ShoppingCartSeatsRepository shoppingCartSeatsRepository;

    @GetMapping("/consult")
    public ResponseEntity<?> consult(
            @RequestParam String orderCOD,
            @RequestParam String passengerDNI
    ) {
        try{
            //get the order
            Optional<Order> OptionalOrder = orderRepository.findByCOD(orderCOD);
            if(OptionalOrder.isEmpty()){
                return ResponseEntity.badRequest().body("Order not found");
            }
            Order order = OptionalOrder.get();

            //get the passenger
            Optional<Passenger> OptionalPassenger = passengerRepository.findByDNI(passengerDNI);
            if(OptionalPassenger.isEmpty()){
                return ResponseEntity.badRequest().body("Passenger not found");
            }
            Passenger passenger = OptionalPassenger.get();

            //get the passenger ID
            long passengerId = passenger.getID();

            //get the order userID
            long userId = order.getUserID();



            //check if the passenger is the owner of the order
            if(passengerId != userId){
                return ResponseEntity.badRequest().body("Passenger is not the owner of the order");
            }


            return ResponseEntity.ok("ok");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
