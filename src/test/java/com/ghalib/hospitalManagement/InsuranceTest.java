package com.ghalib.hospitalManagement;

import com.ghalib.hospitalManagement.entity.Insurance;
import com.ghalib.hospitalManagement.entity.Patient;
import com.ghalib.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void Insurance_Test(){
        Insurance insurance=Insurance.builder()
                .provider("Ghalib")
                .policyNumber("HDFC-12234")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);
    }
}
