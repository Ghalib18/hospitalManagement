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
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private LocalDateTime appointmentTime;

    @Column(length=500)
    private String reason;

    @ManyToOne             // owning side....
    private Patient patient;

    @OneToOne
    @JoinColumn(nullable = false)  // owning side.....
    private Doctor doctor;
}
