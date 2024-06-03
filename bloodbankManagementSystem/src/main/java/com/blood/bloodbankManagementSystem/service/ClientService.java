package com.blood.bloodbankManagementSystem.service;

import com.blood.bloodbankManagementSystem.createRequest.ClientCreateRequest;
import com.blood.bloodbankManagementSystem.model.BloodBank;
import com.blood.bloodbankManagementSystem.model.Client;
import com.blood.bloodbankManagementSystem.repositery.ClientRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepos clientRepos;
    @Autowired
    private BloodBankService bloodBankService;

    public Client getClientById(int id){
        return clientRepos.findById(id).orElseThrow(()-> new RuntimeException("client not present"));
    }
    public List<Client> getAllClient(){
        return clientRepos.findAll();
    }
    public List<Client> getAllClientAssociatedToABloodBank(int id){
        BloodBank bank = bloodBankService.getBloodBank(id);
        return clientRepos.findByAssociatedBloodBanks(bank);
    }
    public Client saveClient(ClientCreateRequest clientCreateRequest){
        Client client = clientCreateRequest.to();
        return clientRepos.save(client);
    }
    public String deleteClient(int id){
        clientRepos.deleteById(id);
        return "client deleted successfully";
    }
}
