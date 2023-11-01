package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
