package com.fresh.coding.accountservice;

import com.fresh.coding.accountservice.entities.BankAccount;
import com.fresh.coding.accountservice.enums.AccountType;
import com.fresh.coding.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository){
        return _ -> {
            var bankAccounts = new ArrayList<BankAccount>();

            bankAccounts.add(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(1000.0)
                    .createdAt(LocalDate.of(2023, 1, 1))
                    .currency("USD")
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(1L)
                    .build());

            bankAccounts.add(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(2000.0)
                    .createdAt(LocalDate.of(2023, 2, 1))
                    .currency("USD")
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(2L)
                    .build());

            bankAccounts.add(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(4000.0)
                    .createdAt(LocalDate.of(2023, 4, 1))
                    .currency("EUR")
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(2L)
                    .build());

            bankAccounts.add(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(5000.0)
                    .createdAt(LocalDate.of(2023, 5, 1))
                    .currency("GBP")
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(1L)
                    .build());

            bankAccounts.add(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(6000.0)
                    .createdAt(LocalDate.of(2023, 6, 1))
                    .currency("GBP")
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(2L)
                    .build());

            bankAccounts.add(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(7000.0)
                    .createdAt(LocalDate.of(2023, 7, 1))
                    .currency("USD")
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(1L)
                    .build());

            bankAccounts.add(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(8000.0)
                    .createdAt(LocalDate.of(2023, 8, 1))
                    .currency("USD")
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(2L)
                    .build());

            bankAccounts.add(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(9000.0)
                    .createdAt(LocalDate.of(2023, 9, 1))
                    .currency("EUR")
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(1L)
                    .build());

            bankAccounts.add(BankAccount.builder()
                    .id(UUID.randomUUID().toString())
                    .balance(10000.0)
                    .createdAt(LocalDate.of(2023, 10, 1))
                    .currency("EUR")
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(2L)
                    .build());
            accountRepository.saveAll(bankAccounts);
        };
    }

}
