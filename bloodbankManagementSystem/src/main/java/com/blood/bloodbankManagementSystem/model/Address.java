package com.blood.bloodbankManagementSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@Embeddable
public class Address {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String state;
    private String Country;

}
