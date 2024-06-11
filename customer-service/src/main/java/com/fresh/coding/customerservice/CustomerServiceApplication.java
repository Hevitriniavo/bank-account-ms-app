package com.fresh.coding.customerservice;

import com.fresh.coding.customerservice.entities.Customer;
import com.fresh.coding.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> customers = List.of(
                    Customer.builder().email("hassan@gmail.com").firstName("Hassan").lastName("Elhoumi").build(),
                    Customer.builder().email("mohamed@gmail.com").firstName("Mohamed").lastName("Elhanmoui").build()
            );
            customerRepository.saveAll(customers);
        };
    }
}
