package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    ShoppingCart getShoppingCartById(long shoppingCartId);
}
