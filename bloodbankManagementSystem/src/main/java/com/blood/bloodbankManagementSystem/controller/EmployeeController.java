package com.blood.bloodbankManagementSystem.controller;

import com.blood.bloodbankManagementSystem.createRequest.EmployeeCreateRequest;
import com.blood.bloodbankManagementSystem.model.Employee;
import com.blood.bloodbankManagementSystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@Valid @RequestBody EmployeeCreateRequest employeeCreateRequest){
        return employeeService.saveEmployee(employeeCreateRequest);
    }
    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }
    @DeleteMapping("/deleteEmployee")
    public String deleteEmployeeById(@RequestParam("id") int id){
        return employeeService.deleteEmployee(id);
    }
}
