package com.blood.bloodbankManagementSystem.createRequest;

import com.blood.bloodbankManagementSystem.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import com.blood.bloodbankManagementSystem.model.sex;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DonorCreateRequest {

    @NotBlank(message="Name of donor can not be empty")
    @Size(min = 3, max = 32)
    private String name;
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
    @Size(min = 10,max = 10,message = "contact number size should be 10")
    @NotBlank(message = "contact number can't be empty")
    private String contactNumber;
    @Positive
    @NotNull
    @Range(min = 18,max = 50)
    private int age;
    @NotNull
    private sex sex;
    @NotNull
    private BloodGroups bloodGroups;
    private long rbc;
    private long wbc;

    public Donor to(){
        Address address = Address.builder().addressLine1(addressLineOne).addressLine2(addressLineTwo)
                .city(city).state(state).zipCode(zipCode).Country(country).build();
        Blood blood = Blood.builder().bloodGroup(bloodGroups).rbc(rbc).wbc(wbc).build();
        return Donor.builder().name(name).age(age).address(address).contactNumber(contactNumber)
                .bloodGroup(blood).sex(sex).build();
    }
}
