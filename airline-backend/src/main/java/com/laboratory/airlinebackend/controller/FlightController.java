package com.laboratory.airlinebackend.controller;
import com.laboratory.airlinebackend.controller.DTO.FlightState;
import com.laboratory.airlinebackend.controller.DTO.RegisterRequestFlight;
import com.laboratory.airlinebackend.model.Flight;
import com.laboratory.airlinebackend.repository.FlightRepository;
import com.laboratory.airlinebackend.repository.SeatsRepository;
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
    private SeatsRepository seatsRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createNewFlight(
            @RequestBody RegisterRequestFlight requestNewFlight
    ){
        var currentDate = new java.util.Date();
        if (requestNewFlight.getFlightDate().before(currentDate)) {
            return ResponseEntity.badRequest().body("Flight date must be after current date");
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
            .build();

        try{
            flightRepository.save(flight);

            return ResponseEntity.ok("Flight created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating flight");
        }

    }

}
