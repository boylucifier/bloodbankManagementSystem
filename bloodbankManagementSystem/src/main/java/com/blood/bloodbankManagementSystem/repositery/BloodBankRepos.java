package com.blood.bloodbankManagementSystem.repositery;

import com.blood.bloodbankManagementSystem.model.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodBankRepos extends JpaRepository<BloodBank,Integer> {
}
