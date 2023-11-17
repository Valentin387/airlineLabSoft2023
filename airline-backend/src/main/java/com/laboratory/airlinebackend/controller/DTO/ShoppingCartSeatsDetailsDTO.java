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
public class ShoppingCartSeatsDetailsDTO {
    private long ID;
    private char letter;
    private int number;
    private boolean hasExtraSpace;
    private String seatClass;
    private String origin;
    private String destination;
    private Date flightDate;
}