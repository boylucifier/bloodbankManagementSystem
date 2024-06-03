package com.blood.bloodbankManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Donor {
    // id , name , age , sex , contact num, address ,  blood group
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private sex sex;
    private String contactNumber;
    @Embedded
    private Address address;
    @Embedded
    private Blood bloodGroup;
    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value="donors")
    private BloodBank bloodBank;
}
