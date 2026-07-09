package com.ghalib.hospitalManagement.service;

import com.ghalib.hospitalManagement.dto.PatientResponse;
import com.ghalib.hospitalManagement.entity.Patient;
import com.ghalib.hospitalManagement.repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepo  patientRepo;
    private final ModelMapper modelMapper;

    public List<PatientResponse> getAllPatients(){
        List<Patient> patients=patientRepo.findALL();
        return patients.stream()
                .map(patient->modelMapper.map(patient,PatientResponse.class))
                .toList();
    }
}
