package com.ghalib.hospitalManagement.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private LocalDateTime appointmentTime;

    @Column(length=500)
    private String reason;

    @ManyToOne
    private Patient patient;
}
