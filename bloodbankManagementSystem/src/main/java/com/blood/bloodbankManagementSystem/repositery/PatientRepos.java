package com.blood.bloodbankManagementSystem.repositery;

import com.blood.bloodbankManagementSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepos extends JpaRepository<Patient,Integer> {
}
