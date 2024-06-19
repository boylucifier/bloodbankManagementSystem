package com.blood.bloodbankManagementSystem.controller;

import com.blood.bloodbankManagementSystem.createRequest.BloodBankCreateRequest;
import com.blood.bloodbankManagementSystem.model.BloodBank;
import com.blood.bloodbankManagementSystem.model.Client;
import com.blood.bloodbankManagementSystem.service.BloodBankService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodBank")
public class BloodBankController {

    @Autowired
    BloodBankService bloodBankService;

    @PostMapping("/addBloodBank")
    public BloodBank addBloodBank(@Valid @RequestBody BloodBankCreateRequest bloodBankCreateRequest){
        return bloodBankService.save(bloodBankCreateRequest);
    }
    @DeleteMapping("/deleteBloodBank/{id}")
    public String deleteBloodBankById(@PathVariable("id") int id){
        return bloodBankService.delete(id);
    }
    @GetMapping("/getBloodBankById/{id}")
    public BloodBank getBloodBankById(@PathVariable("id") int id){
        return bloodBankService.getBloodBank(id);
    }
    @GetMapping("/getAllBloodBank")
    public List<BloodBank> getAllBloodBanks(){
        return bloodBankService.getAllBloodBanks();
    }

    @GetMapping("/getAllClientsForBloodBank/{id}")
    public List<Client> getAllClientsForBank(@PathVariable("id") int id){
        return bloodBankService.getAllClientsForABloodBank(id);
    }
}
