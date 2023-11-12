package com.laboratory.airlinebackend.controller;
import com.laboratory.airlinebackend.controller.DTO.ChangeIdRootRequest;
import com.laboratory.airlinebackend.controller.exceptions.RootIdChangeException;
import com.laboratory.airlinebackend.model.Card;
import com.laboratory.airlinebackend.model.CardUser;
import com.laboratory.airlinebackend.model.User;
import com.laboratory.airlinebackend.repository.CardRepository;
import com.laboratory.airlinebackend.repository.CardUserRepository;
import com.laboratory.airlinebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/list/{id}")
    public ResponseEntity<?> cards(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();

            List<CardUser> cardUserList = cardUserRepository.findByUser(existingUser);

            List<Card> userCards = new ArrayList<>();

            //loop on the list of CardUser relationships to get the cards

            for (CardUser cardUser : cardUserList) {
                userCards.add(cardUser.getCard());
            }

            return ResponseEntity.ok(userCards);
        } else {
            // Si no se encuentra el usuario, devuelve un error 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }

}

