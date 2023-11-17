package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> getSeatsByFlightId(Long id);
}
