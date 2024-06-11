package com.fresh.coding.accountservice.controllers;

import com.fresh.coding.accountservice.clients.CustomerRestClient;
import com.fresh.coding.accountservice.entities.BankAccount;
import com.fresh.coding.accountservice.exceptions.NotFoundException;
import com.fresh.coding.accountservice.models.Customer;
import com.fresh.coding.accountservice.repositories.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {
    private final BankAccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    @GetMapping
    public List<BankAccount> getAllAccounts(){
        var accounts = accountRepository.findAll();
        accounts.forEach(account -> {
               account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()));
        });
        return accounts;
    }

    @GetMapping("/{id}")
    public BankAccount getAccount(@PathVariable String id){
        BankAccount bankAccount = accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found"));
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
         bankAccount.setCustomer(customer);
         return bankAccount;
    }
}
