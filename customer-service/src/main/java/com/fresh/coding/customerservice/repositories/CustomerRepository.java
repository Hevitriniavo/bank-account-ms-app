package com.fresh.coding.customerservice.repositories;

import com.fresh.coding.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
