package com.ghalib.hospitalManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {
    private Long id;
    private String name;
    private String gender;
    private String email;
    private LocalDate birthDate;
}
