package com.ghalib.hospitalManagement.service;

import com.ghalib.hospitalManagement.entity.Insurance;
import com.ghalib.hospitalManagement.entity.Patient;
import com.ghalib.hospitalManagement.repo.InsuranceRepository;
import com.ghalib.hospitalManagement.repo.PatientRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepo;
    private final PatientRepo patientRepo;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance,Long patientId){
        Patient patient=patientRepo.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found"));

        patient.setInsurance(insurance);

        insurance.setPatient(patient);

        return patient;
    }
}
