package com.laboratory.airlinebackend.controller;
import com.laboratory.airlinebackend.repository.FlightRepository;
import com.laboratory.airlinebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findPassenger/{DNI}")
    public ResponseEntity<?> findPassenger(@PathVariable String DNI){
        try{
            var passenger = userRepository.findByDNI(DNI);
            return ResponseEntity.ok(passenger);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("That passenger is not a registered user " + e.getMessage());
        }
    }

    /*
    @PostMapping("/purchase")
    public ResponseEntity<?> purchase(
            @RequestBody RegisterRequestFlight requestNewFlight
    ){
        try{
            //System.out.println(requestNewFlight);
            var flight = Flight.builder()
                    .flightDate(requestNewFlight.getFlightDate())
                    .origin(requestNewFlight.getOrigin())
                    .destination(requestNewFlight.getDestination())
                    .costByPerson(requestNewFlight.getCostByPerson())
                    .build();
            flightRepository.save(flight);
            return ResponseEntity.ok("Flight created successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error creating flight " + e.getMessage());
        }
    }
    */

}
