package com.blood.bloodbankManagementSystem.repositery;

import com.blood.bloodbankManagementSystem.model.BloodBank;
import com.blood.bloodbankManagementSystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepos extends JpaRepository<Client,Integer> {
    List<Client> findByAssociatedBloodBanks(BloodBank bloodBank);
}
