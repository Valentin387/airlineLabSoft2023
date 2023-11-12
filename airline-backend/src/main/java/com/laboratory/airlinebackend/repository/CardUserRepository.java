package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.model.Card;
import com.laboratory.airlinebackend.model.CardUser;
import com.laboratory.airlinebackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardUserRepository extends JpaRepository<CardUser, Long> {
    List<CardUser> findByUser(User existingUser);
}

