package com.ghalib.hospitalManagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length =100)
    private String name;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false,unique = true)
    private String email;

    @ManyToMany(mappedBy = "doctors")
    private Set<Department> departments=new HashSet<>();
}
