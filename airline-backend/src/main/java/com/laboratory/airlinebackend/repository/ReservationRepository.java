package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.controller.DTO.ReservationDetailsDTO;
import com.laboratory.airlinebackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r.reservationDate, r.expirationDate, " +
            "f.origin, f.destination, f.flightDate, f.state, f.costByPerson, f.costByPersonOffer " +
            "FROM tblReservation r " +
            "JOIN tblSeat s ON r.IDSeat = s.ID " +
            "JOIN tblFlight f ON s.flightId = f.id " +
            "WHERE r.IDUser = :userId " +
            "ORDER BY f.id")
    List<Object[]> getReservationsByUserId(@Param("userId") long userId);

}
