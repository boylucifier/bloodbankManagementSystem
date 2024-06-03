package com.blood.bloodbankManagementSystem.controller;

import com.blood.bloodbankManagementSystem.createRequest.DonorCreateRequest;
import com.blood.bloodbankManagementSystem.model.Donor;
import com.blood.bloodbankManagementSystem.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donor")
public class DonorController {

    @Autowired
    DonorService donorService;

    @PostMapping("/addDonor")
    public Donor addDonor(@RequestBody DonorCreateRequest donorCreateRequest){
        return donorService.saveDonor(donorCreateRequest);
    }
    @GetMapping("/getDonorById/{id}")
    public Donor getDonorById(@PathVariable("id") int id){
        return donorService.getDonorById(id);
    }
    @GetMapping("/getAllDonors")
    public List<Donor> getAllDonors(){
        return donorService.getAllDonors();
    }
    @DeleteMapping("/deleteDonor")
    public String deleteDonorById(@RequestParam("id") int id){
        return donorService.deleteDonor(id);
    }
}
