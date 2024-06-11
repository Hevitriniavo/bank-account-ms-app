package com.fresh.coding.customerservice.controllers;

import com.fresh.coding.customerservice.entities.Customer;
import com.fresh.coding.customerservice.exceptions.NotFoundException;
import com.fresh.coding.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerRestController {
    private final CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerRepository.findById(id).orElseThrow(()-> new NotFoundException("Customer not found"));
    }
}
