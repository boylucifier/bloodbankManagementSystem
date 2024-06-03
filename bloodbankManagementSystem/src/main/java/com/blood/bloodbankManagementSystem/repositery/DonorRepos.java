package com.blood.bloodbankManagementSystem.repositery;

import com.blood.bloodbankManagementSystem.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepos extends JpaRepository<Donor,Integer> {
}
