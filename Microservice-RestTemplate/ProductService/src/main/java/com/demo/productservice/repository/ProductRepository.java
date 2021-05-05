package com.demo.productservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Optional<Product> findByName(String name);

}
