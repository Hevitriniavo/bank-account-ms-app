package com.fresh.coding.accountservice.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Customer {
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
}
