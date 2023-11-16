package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.controller.DTO.ReservationDetailsDTO;
import com.laboratory.airlinebackend.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT ReservationDetailsDTO(" +
            "r.ID, r.expirationDate, s.letter, s.number, s.hasExtraSpace, s.seatClass, f.origin, f.destination, f.flightDate) " +
            "FROM tblReservation r " +
            "JOIN tblSeat s ON r.IDSeat = s.ID " +
            "JOIN tblFlight f ON s.flightId = f.id " +
            "WHERE r.IDUser = :userID")
    List<ReservationDetailsDTO> getReservationDetailsByUserID(long userID);

}
