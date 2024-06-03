package com.blood.bloodbankManagementSystem.createRequest;

import com.blood.bloodbankManagementSystem.model.Address;
import com.blood.bloodbankManagementSystem.model.BloodBank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class BloodBankCreateRequest {

    @NotBlank(message="Name of bloodBank can not be empty")
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
    private String contactDetails;

    public BloodBank to(){
        Address address = Address.builder().addressLine1(addressLineOne).addressLine2(addressLineTwo)
                .city(city).state(state).zipCode(zipCode).Country(country).build();
        return BloodBank.builder().name(name).address(address).contactNumber(contactDetails).build();
    }
}
