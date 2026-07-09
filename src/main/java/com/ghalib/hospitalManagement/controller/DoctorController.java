package com.ghalib.hospitalManagement.controller;

import com.ghalib.hospitalManagement.dto.DoctorResponse;
import com.ghalib.hospitalManagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/public")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorResponse>> getAllDoctors(){
        return ResponseEntity.ok(doctorService.GetAllDoctor());
    }


}
