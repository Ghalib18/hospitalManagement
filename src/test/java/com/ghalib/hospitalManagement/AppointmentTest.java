package com.ghalib.hospitalManagement;

import com.ghalib.hospitalManagement.entity.Appointment;
import com.ghalib.hospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
public class AppointmentTest {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInAppointment(){

        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(
                        LocalDate.of(2026, 7, 1),
                        LocalTime.of(10, 30)))
                .reason("headach")
                .build();

        Appointment ap=appointmentService.createAppointment(appointment,1L,2L);
        System.out.println(ap);

        Appointment ap1=appointmentService.updateAppointment(1L,3L);
        System.out.println(ap1);

    }
}
