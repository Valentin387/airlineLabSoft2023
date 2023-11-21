package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM tblOrder o WHERE o.userID = :userId")
    List<Order> findByUserID(long userId);
}
