package com.laboratory.airlinebackend.controller;
import com.laboratory.airlinebackend.controller.DTO.CardCountDTO;
import com.laboratory.airlinebackend.controller.DTO.ChangeIdRootRequest;
import com.laboratory.airlinebackend.controller.DTO.NewCard;
import com.laboratory.airlinebackend.controller.DTO.UpdateProfileRequest;
import com.laboratory.airlinebackend.controller.DTO.NewCard;
import com.laboratory.airlinebackend.controller.exceptions.RootIdChangeException;
import com.laboratory.airlinebackend.model.Card;
import com.laboratory.airlinebackend.model.CardUser;
import com.laboratory.airlinebackend.model.User;
import com.laboratory.airlinebackend.repository.CardRepository;
import com.laboratory.airlinebackend.repository.CardUserRepository;
import com.laboratory.airlinebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.valves.rewrite.InternalRewriteMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/financial-module")
@CrossOrigin("http://localhost:5173")
@RequiredArgsConstructor
public class FinancialModuleController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardUserRepository cardUserRepository;

    @Autowired
    private CardRepository cardRepository;

    @PostMapping("/add/{id}")
    @Transactional
    public ResponseEntity<?> addCards(@PathVariable Long id, @RequestBody NewCard newCard) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();

            // Check if the user already has the card
            Optional<Card> existingCard = cardRepository.findByNumber(newCard.getNumber());

            if (existingCard.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("La tarjeta ya está registrada.");
            }
            CardUser newCardUser;
            int quantityDebitCards = 0;
            int quantityCreditCards = 0;

            // Verificar el tipo de tarjeta y construir CardUser en consecuencia
            Card newCardRegistered;
            List<CardUser> cardUserList = cardUserRepository.findByUser(existingUser);

            //loop on the list of CardUser relationships to get the cards

            for (CardUser cardUser : cardUserList) {
                if ("debito".equalsIgnoreCase(cardUser.getCard().getType())) {
                    quantityDebitCards++;
                } else if ("credito".equalsIgnoreCase(cardUser.getCard().getType())) {
                    quantityCreditCards++;
                }
            }

            if ("debito".equalsIgnoreCase(newCard.getType())) {
                newCardRegistered = Card.builder()
                        //.id(id)
                        .balance(Double.parseDouble(newCard.getBalance()))
                        .type(newCard.getType())
                        .number(newCard.getNumber())
                        .name(newCard.getName())
                        .expirationDate(newCard.getExpirationDate())
                        .cvc(newCard.getCvc())
                        .build();
                newCardUser = CardUser.builder()
                        .user(existingUser)
                        .card(newCardRegistered)
                        .quantityCreditCards(quantityCreditCards)
                        .quantityDebitCards(quantityDebitCards + 1)
                        .build();
            } else if ("credito".equalsIgnoreCase(newCard.getType())) {
                newCardRegistered = Card.builder()
                        //.id(id)
                        .balance(Double.parseDouble(newCard.getBalance()))
                        .type(newCard.getType())
                        .number(newCard.getNumber())
                        .name(newCard.getName())
                        .expirationDate(newCard.getExpirationDate())
                        .cvc(newCard.getCvc())
                        .build();
                newCardUser = CardUser.builder()
                        .user(existingUser)
                        .card(newCardRegistered)
                        .quantityCreditCards(quantityCreditCards + 1)
                        .quantityDebitCards(quantityDebitCards)
                        .build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de tarjeta no válido");
            }

            // Guardar la instancia actualizada en la base de datos
            cardRepository.save(newCardRegistered);
            cardUserRepository.save(newCardUser);

            return ResponseEntity.ok(newCardUser);

        } else {
            // Si no se encuentra el usuario, devuelve un error 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/list/{id}")
    @Transactional
    public ResponseEntity<?> cards(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        try{

            if (userOptional.isPresent()) {
                User existingUser = userOptional.get();
                List<Card> userCards = cardUserRepository.findCardsByUser(existingUser.getID());

                return ResponseEntity.ok(userCards);
            } else {
                // Si no se encuentra el usuario, devuelve un error 404 (Not Found)
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al obtener las tarjetas");
        }

        //return ResponseEntity.ok("Tarjetas obtenidas correctamente");


    }
}



