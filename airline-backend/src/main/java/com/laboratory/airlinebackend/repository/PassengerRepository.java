package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.controller.DTO.ConsultCheckInDTO;
import com.laboratory.airlinebackend.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    @Query("SELECT p FROM tblPassenger p WHERE p.ID = :passengerId")
    Passenger getPassengerById(long passengerId);

    @Query("SELECT p FROM tblPassenger p WHERE p.DNI = :passengerDNI")
    Optional<Passenger> findByDNI(String passengerDNI);

    @Query("SELECT f.id, p.ID, p.firstName, p.lastName, p.DNI, p.didCheckIn, f.origin, f.destination, f.flightDate, s.ID, s.number, s.letter " +
            "FROM tblOrder o " +
            "JOIN tblShoppingCartSeats scs ON o.shoppingCartID = scs.shoppingCartID " +
            "JOIN tblSeat s ON scs.seatID = s.ID " +
            "JOIN tblFlight f ON s.flightId = f.id " +
            "JOIN tblPassenger p ON p.ID = s.passengerId " +
            "WHERE scs.shoppingCartID = :ShoppingCartId ")
    List<ConsultCheckInDTO> getPassengerBookedDetailsByShoppingCartId(@Param("ShoppingCartId") long ShoppingCartId);

    @Query("SELECT f.id, p.ID, p.firstName, p.lastName, p.DNI, p.didCheckIn, f.origin, f.destination, f.flightDate, f.state, s.ID, s.number, s.letter " +
            "FROM tblOrder o " +
            "JOIN tblShoppingCartSeats scs ON o.shoppingCartID = scs.shoppingCartID " +
            "JOIN tblSeat s ON scs.seatID = s.ID " +
            "JOIN tblFlight f ON s.flightId = f.id " +
            "JOIN tblPassenger p ON p.ID = s.passengerId " +
            "WHERE scs.shoppingCartID = :ShoppingCartId AND p.DNI = :passengerDNI")
    List<ConsultCheckInDTO> getPassengerBookedDetailsByShoppingCartIdandOwnDNI(@Param("ShoppingCartId") long ShoppingCartId, @Param("passengerDNI") String passengerDNI);


}
