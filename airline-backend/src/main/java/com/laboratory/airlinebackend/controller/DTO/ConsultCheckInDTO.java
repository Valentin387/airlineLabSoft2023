package com.laboratory.airlinebackend.controller.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsultCheckInDTO {

    private long flightId;
    private long passengerId;
    private String firstName;
    private String lastName;
    private String DNI;
    private boolean didCheckIn;
    private String origin;
    private String destination;
    private Date flightDate;
    private long SeatId;
    private long SeatNumber;
    private char SeatLetter;

}

