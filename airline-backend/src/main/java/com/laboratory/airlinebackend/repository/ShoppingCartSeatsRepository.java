package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.controller.DTO.ShoppingCartSeatsDetailsDTO;
import com.laboratory.airlinebackend.model.ShoppingCartSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingCartSeatsRepository extends JpaRepository<ShoppingCartSeats, Long> {

    @Query("SELECT ShoppingCartSeatsDetailsDTO(" +
            "scs.ID, s.letter, s.number, s.hasExtraSpace, s.seatClass, f.origin, f.destination, f.flightDate) " +
            "FROM tblShoppingCartSeats scs " +
            "JOIN tblSeat s ON scs.seatID = s.ID " +
            "JOIN tblFlight f ON s.flightId = f.id " +
            "WHERE scs.shoppingCartID = :shoppingCartID")
    List<ShoppingCartSeatsDetailsDTO> getShoppingCartSeatsDetailsByShoppingCartID(Long shoppingCartID);
}
