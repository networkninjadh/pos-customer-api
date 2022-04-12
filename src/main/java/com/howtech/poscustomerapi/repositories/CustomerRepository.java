package com.howtech.poscustomerapi.repositories;

import java.util.Optional;

import com.howtech.poscustomerapi.models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Damond Howard
 * @apiNote this repository is an interface that controlls access to our
 *          database implementation
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByUsername(String username);
}