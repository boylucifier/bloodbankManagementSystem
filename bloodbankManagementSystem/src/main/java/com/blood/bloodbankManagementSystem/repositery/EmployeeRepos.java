package com.blood.bloodbankManagementSystem.repositery;

import com.blood.bloodbankManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepos extends JpaRepository<Employee,Integer> {
}
