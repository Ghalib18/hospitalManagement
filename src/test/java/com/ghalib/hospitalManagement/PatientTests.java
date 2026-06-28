package com.ghalib.hospitalManagement;

import com.ghalib.hospitalManagement.entity.Patient;
import com.ghalib.hospitalManagement.repo.PatientRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepo patientRepo;

    @Test
    public void printByName(){

        Patient patient=patientRepo.findByName("Rahul Sharma");
        System.out.println(patient);

        List<Patient> patients=patientRepo.findByNameContainingOrderByIdDesc("Neha Gupta");
        System.out.println(patients);

        List<Object[]> listOfBloodGroup=patientRepo.countOfBloodGroup();

        for(Object[] obj:listOfBloodGroup){
            System.out.println(obj[0]+" "+obj[1]);
        }
    }


}
