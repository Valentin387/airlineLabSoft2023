package com.laboratory.airlinebackend.model;

import com.laboratory.airlinebackend.repository.CardRepository;
import com.laboratory.airlinebackend.repository.CardUserRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Optional;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tblCardUser")
public class CardUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cardID")
    private Card card;

    @Column
    private int quantityCreditCards;

    @Column
    private int quantityDebitCards;
}

    /*
    @Transient // Indica que este método no debe ser persistido en la base de datos
    public Card getCard() {
        // Implementación del método para obtener la tarjeta asociada
        Optional<Card> cardOptional = cardRepository.findById(cardId.getId());

        return cardOptional.orElse(null);
    }

     */

