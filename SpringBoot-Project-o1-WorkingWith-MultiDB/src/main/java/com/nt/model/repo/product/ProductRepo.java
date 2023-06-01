package com.nt.model.repo.product;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.product.Product;

public interface ProductRepo extends JpaRepository<Product, Serializable> {

}
