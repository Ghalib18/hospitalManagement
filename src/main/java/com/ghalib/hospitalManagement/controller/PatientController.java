package com.ghalib.hospitalManagement.controller;


import com.ghalib.hospitalManagement.dto.PatientResponse;
import com.ghalib.hospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/public")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponse>> getAllPatients(){
        return ResponseEntity.ok(patientService.getAllPatients());
    }
}
