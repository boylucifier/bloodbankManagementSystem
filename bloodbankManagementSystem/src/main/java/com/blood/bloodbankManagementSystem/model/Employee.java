package com.blood.bloodbankManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String contactNumber;
    private sex sex;
    @Embedded
    private Address address;
    @Embedded
    private Blood bloodGroup;
    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value="employees")
    private BloodBank bloodBank;
}
