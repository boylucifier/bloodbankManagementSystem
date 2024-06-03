package com.blood.bloodbankManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BloodBank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Embedded
    private Address address;
    private String contactNumber;
    @OneToMany(mappedBy = "bloodBank")
    @JsonIgnoreProperties(value="bloodBank")
    private List<Employee> employees;
    @ManyToMany
    @JoinTable()
    @JsonIgnoreProperties(value="associatedBloodBanks")
    private List<Client> clients;
    private int A_POSITIVE;
    private int A_NEGATIVE;
    private int B_POSITIVE;
    private int B_NEGATIVE;
    private int O_POSITIVE;
    private int O_NEGATIVE;
    private int AB_POSITIVE;
    private int AB_NEGATIVE;
    @OneToMany(mappedBy="bloodBank")
    @JsonIgnoreProperties(value="bloodBank")
    private List<Donor> donors;


}
