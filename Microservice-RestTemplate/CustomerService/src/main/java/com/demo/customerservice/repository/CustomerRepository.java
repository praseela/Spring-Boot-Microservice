package com.demo.customerservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.customerservice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
