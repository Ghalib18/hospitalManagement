package com.ghalib.hospitalManagement.entity;

import com.ghalib.hospitalManagement.entity.type.BloodGroup;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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


    // here we learn the concept of orphanRemoval which means that i we set remove child from paernt class then it will be also remove from the child class (using @transcation)
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST},orphanRemoval = true)
    private Insurance insurance;   // owning side


    // In this we resolve the issue of n+1 query problem

    @OneToMany(mappedBy ="patient", cascade = {CascadeType.REMOVE},orphanRemoval = true,fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Appointment> appointment=new ArrayList<>();
}
