package com.laboratory.airlinebackend.model;

import com.laboratory.airlinebackend.controller.DTO.FlightState;
import com.laboratory.airlinebackend.controller.DTO.SeatState;
import com.laboratory.airlinebackend.repository.SeatRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tblFlight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150)
    private String image;

    @Column
    private Date flightDate;

    @Column(length = 100)
    private String origin;

    @Column(name = "destination", length = 100)
    private String destination;

    @Column(name = "flightDuration", length = 50)
    private String flightDuration;

    @Column
    private Date arrivalDate;

    @Column
    private double costByPerson;

    @Column
    private double costByPersonOffer;

    @Column
    private int availableSeats;

    @Column(length = 50)
    private String state;

    @Column(length = 150)
    private String cancelationMessage;

    @Column
    private boolean isInternational;

    // Constructors, getters, setters, and other methods
    @Autowired
    SeatRepository seatRepository;
    public void create_seats(
            //int assignedSeats,
            int firstClassSeatsQuantity,
            int firstClassSeatRows,
            int economicClassSeatsQuantity,
            int economicClassSeatRows
            ) {

        try {
            //now let's create the seats for this flight
            char letterArray[] = {'A', 'B', 'C', 'D', 'E', 'F'};
            int seatCounter = 0;
            boolean tempExtraSpace;

            //for the first class seats
            for (int l = 1; l <= firstClassSeatRows; l++) {
                System.out.print(l + "\t");
                for (int c = 0; c < 6; c++) {
                    if (seatCounter < firstClassSeatsQuantity) {
                        if (c == 0 || c == 6) {
                            tempExtraSpace = true;
                        } else {
                            tempExtraSpace = false;
                        }
                        var seat = Seat.builder()
                                .flightId((int) this.getId())
                                .number(l)
                                .letter(letterArray[c])
                                .state(SeatState.AVAILABLE.toString())
                                .hasExtraSpace(tempExtraSpace)
                                .seatClass("First Class")
                                .build();
                        seatRepository.save(seat);
                        seatCounter++;
                        System.out.print(letterArray[c] + " ");
                    }
                }
                System.out.println();
            }
            seatCounter = 0;
            System.out.print("------------------------------------\n");
            //for the economic class seats

            for (int l = 1; l <= economicClassSeatRows; l++) {
                System.out.print(l + "\t");
                for (int c = 0; c < 6; c++) {
                    if (seatCounter < economicClassSeatsQuantity) {
                        if (c == 0 || c == 6) {
                            tempExtraSpace = true;
                        } else {
                            tempExtraSpace = false;
                        }
                        /*var seat = Seat.builder()
                                .flightId((int) flight.getId())
                                .number(l)
                                .letter(letterArray[c])
                                .state(SeatState.AVAILABLE.toString())
                                .hasExtraSpace(tempExtraSpace)
                                .seatClass("Economic Class")
                                .build();
                        seatRepository.save(seat);*/
                        seatCounter++;
                        System.out.print(letterArray[c] + " ");
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
