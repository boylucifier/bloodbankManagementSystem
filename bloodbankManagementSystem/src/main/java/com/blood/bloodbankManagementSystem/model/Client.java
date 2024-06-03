package com.blood.bloodbankManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Client {

    //id , name , address , contact , poc , bloodBanks
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Embedded
    private Address address;
    private String contactDetails;
    private String poc;
    @ManyToMany(mappedBy = "clients")
    @JsonIgnoreProperties(value="clients")
    private List<BloodBank> associatedBloodBanks;

}
