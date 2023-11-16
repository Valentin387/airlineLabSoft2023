package com.laboratory.airlinebackend.controller;
import com.laboratory.airlinebackend.controller.DTO.ReserveFlightDTO;
import com.laboratory.airlinebackend.controller.DTO.SeatState;
import com.laboratory.airlinebackend.model.Reservation;
import com.laboratory.airlinebackend.model.Seat;
import com.laboratory.airlinebackend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/reservation")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class ReservationController {


    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ReservationRepository reservationRepository;



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

}
