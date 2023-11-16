package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
