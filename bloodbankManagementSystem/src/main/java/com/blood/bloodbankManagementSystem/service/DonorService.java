package com.blood.bloodbankManagementSystem.service;

import com.blood.bloodbankManagementSystem.createRequest.DonorCreateRequest;
import com.blood.bloodbankManagementSystem.model.Donor;
import com.blood.bloodbankManagementSystem.repositery.DonorRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService {

    @Autowired
    private DonorRepos donorRepos;

    public Donor saveDonor(DonorCreateRequest donorCreateRequest){
        return donorRepos.save(donorCreateRequest.to());
    }
    public Donor getDonorById(int id){
        return donorRepos.findById(id).orElseThrow(()-> new RuntimeException("Donor not present"));
    }
    public List<Donor> getAllDonors(){
        return donorRepos.findAll();
    }
    public String deleteDonor(int id){
        donorRepos.deleteById(id);
        return "Donor deleted successfully";
    }
}
