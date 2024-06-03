package com.blood.bloodbankManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Patient {
    //id , name , contact details , disease , address , blood group , bottles of blood
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private sex sex;
    private String contactDetails;
    private String disease;
    @Embedded
    private Address address;
    @Embedded
    private Blood bloodGroup;
    private int bottlesOfBlood;

}
