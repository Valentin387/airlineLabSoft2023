package com.laboratory.airlinebackend.controller;
import com.laboratory.airlinebackend.controller.DTO.FlightState;
import com.laboratory.airlinebackend.controller.DTO.RegisterRequestFlight;
import com.laboratory.airlinebackend.controller.DTO.SeatState;
import com.laboratory.airlinebackend.controller.service.SeatCreatorService;
import com.laboratory.airlinebackend.model.Flight;
import com.laboratory.airlinebackend.model.Seat;
import com.laboratory.airlinebackend.repository.FlightRepository;
import com.laboratory.airlinebackend.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/flight")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private SeatCreatorService seatCreatorService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewFlight(
            @RequestBody RegisterRequestFlight requestNewFlight
    ){
        var currentDate = new java.util.Date();
        if (requestNewFlight.getFlightDate().before(currentDate)) {
            return ResponseEntity.badRequest().body("Flight date must be after current date");
        }
        try{
            int assignedSeats;
            int firstClassSeatsQuantity;
            int economicClassSeatsQuantity;
            int firstClassSeatRows;
            int economicClassSeatRows;
            //System.out.println(requestNewFlight);

            if (requestNewFlight.isInternational()) {
                //International
                assignedSeats = 250;
                firstClassSeatsQuantity = 50;
                firstClassSeatRows = 9; //round up firstClassSeatsQuantity/6
                economicClassSeatsQuantity = 200;
                economicClassSeatRows = 34; //round up economicClassSeatsQuantity/6
            } else {
                //National
                assignedSeats = 150;
                firstClassSeatsQuantity = 25;
                firstClassSeatRows = 5; //round up firstClassSeatsQuantity/6
                economicClassSeatsQuantity = 125;
                economicClassSeatRows = 21; //round up economicClassSeatsQuantity/6
            }
            var flight = Flight.builder()
                .flightDate(requestNewFlight.getFlightDate())
                .origin(requestNewFlight.getOrigin())
                .destination(requestNewFlight.getDestination())
                .flightDuration(requestNewFlight.getFlightDuration())
                .arrivalDate(requestNewFlight.getArrivalDate())
                .costByPerson(requestNewFlight.getCostByPerson())
                .isInternational(requestNewFlight.isInternational())
                .state(FlightState.ON_TIME.toString())
                .availableSeats(assignedSeats)
                .build();
            flightRepository.save(flight);

            //now let's create the seats for this flight
            seatCreatorService.create_seats(
                    //assignedSeats,
                    firstClassSeatsQuantity,
                    firstClassSeatRows,
                    economicClassSeatsQuantity,
                    economicClassSeatRows,
                    flight);

            return ResponseEntity.ok("Flight created succesfully \n" +
                    "added economic class seats: " + economicClassSeatsQuantity + "\n" +
                    "added first class seats: " + firstClassSeatsQuantity);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating flight");
        }

    }

}
