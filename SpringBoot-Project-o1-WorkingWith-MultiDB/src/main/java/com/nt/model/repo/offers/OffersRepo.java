package com.nt.model.repo.offers;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.offers.Offers;

public interface OffersRepo extends JpaRepository<Offers, Serializable> {

}
