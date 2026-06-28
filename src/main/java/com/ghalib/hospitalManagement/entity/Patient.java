package com.ghalib.hospitalManagement.entity;

import com.ghalib.hospitalManagement.entity.type.BloodGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Setter
@Getter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true,nullable = false)
    private String email;

    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToOne
    private Insurance insurance;   // owning side

    @OneToMany(mappedBy ="patient" )
    private Appointment appointment;
}
