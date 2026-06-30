package com.ghalib.hospitalManagement.service;

import com.ghalib.hospitalManagement.entity.Appointment;
import com.ghalib.hospitalManagement.entity.Doctor;
import com.ghalib.hospitalManagement.entity.Patient;
import com.ghalib.hospitalManagement.repo.AppointmentRepository;
import com.ghalib.hospitalManagement.repo.DoctorRepository;
import com.ghalib.hospitalManagement.repo.PatientRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final DoctorRepository doctorRepository;
    private final PatientRepo patientRepo;
    private final AppointmentRepository appointmentRepository;


    @Transactional
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        Patient patient=patientRepo.findById(patientId).orElseThrow();

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointment().add(appointment); // just me make the bi-directional consitency

        return appointmentRepository.save(appointment);

    }
    @Transactional
    public Appointment updateAppointment(Long appointmentId,Long doctorId){
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow();
        appointment.setDoctor(doctor);
        // no needs to save here as jpa will check for the dirtybits , it will found that Doctor filed has been change
        return appointment;
    }
}
