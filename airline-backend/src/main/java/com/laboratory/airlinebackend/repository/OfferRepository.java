package com.laboratory.airlinebackend.repository;

import com.laboratory.airlinebackend.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository  extends JpaRepository<Offer, Long> {
}
