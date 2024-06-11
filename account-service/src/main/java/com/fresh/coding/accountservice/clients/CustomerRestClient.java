package com.fresh.coding.accountservice.clients;

import com.fresh.coding.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "findDefaultCustomerById")
    Customer findCustomerById( @PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomers")
    List<Customer> findAllCustomers();

    default Customer findDefaultCustomerById(Long id, Exception e){
        return Customer.builder()
                .id(id)
                .firstName("Not Available")
                .lastName("Not Available")
                .email("Not Available")
                .build();

    }

    default List<Customer> getDefaultCustomers(Exception e){
        return List.of();
    }
}
