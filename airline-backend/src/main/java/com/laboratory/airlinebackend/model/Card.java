package com.laboratory.airlinebackend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tblCard")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /*
    @Column
    private double balance;

    @Column(length = 15)
    private String type;

    @Column(length = 16)
    private String number;

    @Column(length = 25)
    private String name;

    @Column(length = 4)
    private String expirationDate;

    @Column(length = 3)
    private String cvc;
    */
}
