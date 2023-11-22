package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    @Query("SELECT p FROM tblPassenger p WHERE p.ID = :passengerId")
    Passenger getPassengerById(long passengerId);

    @Query("SELECT p FROM tblPassenger p WHERE p.DNI = :passengerDNI")
    Optional<Passenger> findByDNI(String passengerDNI);
}
