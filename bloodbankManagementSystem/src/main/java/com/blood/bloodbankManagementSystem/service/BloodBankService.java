package com.blood.bloodbankManagementSystem.service;

import com.blood.bloodbankManagementSystem.createRequest.BloodBankCreateRequest;
import com.blood.bloodbankManagementSystem.model.BloodBank;
import com.blood.bloodbankManagementSystem.model.Client;
import com.blood.bloodbankManagementSystem.model.Donor;
import com.blood.bloodbankManagementSystem.repositery.BloodBankRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodBankService {
    
    @Autowired
    private BloodBankRepos bloodBankRepos;
    @Autowired
    private ClientService clientService;

    public BloodBank save(BloodBankCreateRequest bloodBankCreateRequest) {
        BloodBank bank = bloodBankCreateRequest.to();
        return bloodBankRepos.save(bank);
    }

    public String delete(int id) {
        bloodBankRepos.deleteById(id);
        return "Blood bank having id "+ id +" is deleted successfully";
    }

    public BloodBank getBloodBank(int id) {
        return bloodBankRepos.findById(id).orElseThrow(() -> new RuntimeException("blood bank not present with this id"));
    }

    public List<BloodBank> getAllBloodBanks() {
        return bloodBankRepos.findAll();
    }

    public List<Client> getAllClientsForABloodBank(int id){
        BloodBank bank = bloodBankRepos.findById(id).orElseThrow(()-> new RuntimeException("blood bank not present"));
        return clientService.getAllClientAssociatedToABloodBank(bank);
    }

}
