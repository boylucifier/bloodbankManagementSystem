package com.blood.bloodbankManagementSystem.service;

import com.blood.bloodbankManagementSystem.createRequest.PatientCreateRequest;
import com.blood.bloodbankManagementSystem.model.Patient;
import com.blood.bloodbankManagementSystem.repositery.PatientRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepos patientRepos;

    public Patient savePatient(PatientCreateRequest patientCreateRequest){
        return patientRepos.save(patientCreateRequest.to());
    }
    public Patient getPatientById(int id){
        return patientRepos.findById(id).orElseThrow(()-> new RuntimeException("patient not present"));
    }
    public List<Patient> getAllPatients(){
        return patientRepos.findAll();
    }
    public String deletePatient(int id){
        patientRepos.deleteById(id);
        return "Patient deleted successfully";
    }
}
