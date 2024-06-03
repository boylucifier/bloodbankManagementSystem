package com.blood.bloodbankManagementSystem.createRequest;

import com.blood.bloodbankManagementSystem.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class PatientCreateRequest {

    @NotBlank(message = "name of patient should not be blank")
    @Size(min = 3, max = 32,message = "name size should be between lenght of 3 and 32")
    private String name;
    @NotBlank(message = "contact number should not be empty")
    @Length(min = 10,max = 10)
    private String contactNumber;
    @NotBlank(message = "address line one can not be empty")
    private String addressLineOne;
    private String addressLineTwo;
    @NotBlank(message = "city can not be empty")
    private String city;
    @NotBlank(message = "zipCode can not be empty")
    private String zipCode;
    @NotBlank(message = "country can not be empty")
    private String country;
    @NotBlank(message = "state can not be empty")
    private String state;
    @NotNull
    private BloodGroups bloodGroups;
    private long rbc;
    private long wbc;
    @NotBlank
    private sex sex;
    @NotBlank
    private String disease;
    private int bottlesOfBlood;
    @NotNull
    @Positive
    private int age;

    public Patient to(){
        Address address = Address.builder().addressLine1(addressLineOne).addressLine2(addressLineTwo)
                .city(city).state(state).zipCode(zipCode).Country(country).build();
        Blood blood = Blood.builder().bloodGroup(bloodGroups).rbc(rbc).wbc(wbc).build();
        return Patient.builder().name(name).age(age).contactDetails(contactNumber).sex(sex)
                .address(address).bloodGroup(blood).disease(disease).bottlesOfBlood(bottlesOfBlood)
                .build();
    }
}
