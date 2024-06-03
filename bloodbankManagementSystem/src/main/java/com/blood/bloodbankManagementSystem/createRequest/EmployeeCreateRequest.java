package com.blood.bloodbankManagementSystem.createRequest;

import com.blood.bloodbankManagementSystem.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class EmployeeCreateRequest {

    @NotBlank(message = "name of employee should not be blank")
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

    public Employee to(){
        Address address = Address.builder().addressLine1(addressLineOne).addressLine2(addressLineTwo)
                .city(city).state(state).zipCode(zipCode).Country(country).build();
        Blood blood = Blood.builder().bloodGroup(bloodGroups).rbc(rbc).wbc(wbc).build();
        return Employee.builder().name(name).contactNumber(contactNumber).sex(sex).address(address)
                .bloodGroup(blood).build();
    }


}
