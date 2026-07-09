package com.ghalib.hospitalManagement.service;

import com.ghalib.hospitalManagement.dto.DoctorResponse;
import com.ghalib.hospitalManagement.entity.Doctor;
import com.ghalib.hospitalManagement.repo.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public List<DoctorResponse> GetAllDoctor(){
        List<Doctor> doctorList=doctorRepository.findAll();

        return doctorList.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponse.class))
                .toList();

    }

}
