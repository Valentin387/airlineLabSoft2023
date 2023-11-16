package com.laboratory.airlinebackend.controller;
import com.laboratory.airlinebackend.controller.DTO.ReserveFlightDTO;
import com.laboratory.airlinebackend.controller.DTO.ShoppingCartSeatsDetailsDTO;
import com.laboratory.airlinebackend.model.*;
import com.laboratory.airlinebackend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/shopping-cart")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class ShoppingCartController {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ShoppingCartSeatsRepository shoppingCartSeatsRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add-to-cart")
    public ResponseEntity<?> addFlightToCart(
            @RequestBody ReserveFlightDTO bookFlightDTO
    ){
        try {
            List<Seat> seats0 = new ArrayList<>();
            seats0 = seatRepository.getSeatsByFlightId(bookFlightDTO.getFlightID());

            //I need only the setas with seatClass = reserveFlightDTO.getSeatClass()
            List<Seat> seats = new ArrayList<>();
            //filter seats0
            for (Seat seat : seats0) {
                if (seat.getSeatClass().equals(bookFlightDTO.getSeatClass())) {
                    seats.add(seat);
                }
            }

            Optional<User> userOptional = userRepository.findById(bookFlightDTO.getUserID());
            if (userOptional.isEmpty()) {
                return ResponseEntity.badRequest().body("User not found");
            }
            User existingUser = userOptional.get();
            ShoppingCart existingShoppingCart = shoppingCartRepository.findById(existingUser.getShoppingCartID()).get();

            Optional <Flight> flightOptinal = flightRepository.findById(bookFlightDTO.getFlightID());
            if (flightOptinal.isEmpty()) {
                return ResponseEntity.badRequest().body("Flight not found");
            }
            Flight existingFlight = flightOptinal.get();
            double UnitPrice;
            if (existingFlight.getCostByPersonOffer() != 0) {
                UnitPrice = existingFlight.getCostByPersonOffer();
            } else {
                UnitPrice = existingFlight.getCostByPerson();
            }

            for (int i = 0; i < bookFlightDTO.getSeatQuantity(); i++) {
                int randomIndex = (int) (Math.random() * seats.size());
                Seat seat = seats.get(randomIndex);

                ShoppingCartSeats shoppingCartSeats = ShoppingCartSeats.builder()
                        .seatID(seat.getID())
                        .shoppingCartID(existingUser.getShoppingCartID())
                        .unitPrice(UnitPrice)
                        .build();

                shoppingCartSeatsRepository.save(shoppingCartSeats);
                existingShoppingCart.setQuantity(existingShoppingCart.getQuantity() + 1);
                existingShoppingCart.setTotalAmount(existingShoppingCart.getTotalAmount() + UnitPrice);
                shoppingCartRepository.save(existingShoppingCart);
                seats.remove(randomIndex);
            }

            return ResponseEntity.ok("Flight added to user's cart successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding flight to cart");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listShoppingCartItems(
            @RequestParam  long userID
    ){
        try {
            Optional<User> userOptional = userRepository.findById(userID);
            if (userOptional.isEmpty()) {
                return ResponseEntity.badRequest().body("User not found");
            }
            User existingUser = userOptional.get();
            ShoppingCart existingShoppingCart = shoppingCartRepository.findById(existingUser.getShoppingCartID()).get();

            List<ShoppingCartSeatsDetailsDTO> shoppingCartSeatsList = shoppingCartSeatsRepository.getShoppingCartSeatsDetailsByShoppingCartID(existingShoppingCart.getID());

            return ResponseEntity.ok(shoppingCartSeatsList);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error listing shopping cart items");
        }
    }

    @DeleteMapping("/drop")
    public ResponseEntity<?> dropItemFromShoppingCart(
            @RequestParam  long userID,
            @RequestParam  long scsID
    ){
        try {
            //get the scs
            Optional<ShoppingCartSeats> OptionalShoppingCartSeats = shoppingCartSeatsRepository.findById(scsID);
            if (OptionalShoppingCartSeats.isEmpty()) {
                return ResponseEntity.badRequest().body("Shopping cart seat not found");
            }
            ShoppingCartSeats shoppingCartSeats = OptionalShoppingCartSeats.get();
            //get the shopping cart ID
            Optional<User> OptionalUser = userRepository.findById(userID);
            if (OptionalUser.isEmpty()) {
                return ResponseEntity.badRequest().body("User not found");
            }
            User user = OptionalUser.get();
            //get the shopping cart
            Optional<ShoppingCart> OptionalShoppingCart = shoppingCartRepository.findById(user.getShoppingCartID());
            if (OptionalShoppingCart.isEmpty()) {
                return ResponseEntity.badRequest().body("Shopping cart not found");
            }
            ShoppingCart shoppingCart = OptionalShoppingCart.get();

            shoppingCartSeatsRepository.delete(shoppingCartSeats);
            shoppingCart.setQuantity(shoppingCart.getQuantity() - 1);
            shoppingCart.setTotalAmount(shoppingCart.getTotalAmount() - shoppingCartSeats.getUnitPrice());
            shoppingCartRepository.save(shoppingCart);

            return ResponseEntity.ok("Shopping cart item dropped successfully");

        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error dropping shopping cart items");
        }
    }


}
