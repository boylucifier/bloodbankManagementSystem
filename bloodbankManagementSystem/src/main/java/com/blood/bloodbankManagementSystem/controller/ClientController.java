package com.blood.bloodbankManagementSystem.controller;

import com.blood.bloodbankManagementSystem.createRequest.ClientCreateRequest;
import com.blood.bloodbankManagementSystem.model.Client;
import com.blood.bloodbankManagementSystem.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/getClientById/{id}")
    public Client getClientById(@PathVariable("id") int id){
        return clientService.getClientById(id);
    }
    @GetMapping(value="/getAllClient")
    public List<Client> getAllClient(){
        return clientService.getAllClient();
    }

    @PostMapping(value="/addClient")
    public Client adClient(@Valid @RequestBody ClientCreateRequest clientCreateRequest){
        return clientService.saveClient(clientCreateRequest);
    }
    @GetMapping(value="/getClientsByBloodBank/{id}")
    public List<Client> getAllClientByBloodBank(@PathVariable("id") int id){
        return clientService.getAllClientAssociatedToABloodBank(id);
    }

    @DeleteMapping(value="/deleteClientById/{id}")
    public String deleteClientByID(@PathVariable("id") int id){
        return clientService.deleteClient(id);
    }

}
