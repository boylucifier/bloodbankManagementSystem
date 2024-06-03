package com.blood.bloodbankManagementSystem.service;

import com.blood.bloodbankManagementSystem.createRequest.EmployeeCreateRequest;
import com.blood.bloodbankManagementSystem.model.Employee;
import com.blood.bloodbankManagementSystem.repositery.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepos employeeRepos;

    public Employee saveEmployee(EmployeeCreateRequest employeeCreateRequest){
        return employeeRepos.save(employeeCreateRequest.to());
    }
    public Employee getEmployeeById(int id){
        return employeeRepos.findById(id).orElseThrow(()-> new RuntimeException("Employee not present"));
    }
    public List<Employee> getAllEmployee(){
        return employeeRepos.findAll();
    }
    public String deleteEmployee(int id){
        employeeRepos.deleteById(id);
        return "Employee deleted successfully";
    }
}
