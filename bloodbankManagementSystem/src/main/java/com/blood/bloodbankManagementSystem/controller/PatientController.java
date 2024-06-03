package com.blood.bloodbankManagementSystem.controller;

import com.blood.bloodbankManagementSystem.createRequest.PatientCreateRequest;
import com.blood.bloodbankManagementSystem.model.Patient;
import com.blood.bloodbankManagementSystem.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/addPatient")
    private Patient savePatient(@Valid @RequestBody PatientCreateRequest patientCreateRequest){
        return patientService.savePatient(patientCreateRequest);
    }
    @GetMapping("/getPatientById/{id}")
    private Patient getPatient(@PathVariable("id") int id){
        return patientService.getPatientById(id);
    }
    @GetMapping("/getAllPatients")
    private List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }
    @DeleteMapping("/deletePatient")
    private String delelePatient(@RequestParam("id") int id){
        return patientService.deletePatient(id);
    }
}
