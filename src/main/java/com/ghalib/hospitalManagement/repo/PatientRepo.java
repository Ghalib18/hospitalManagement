package com.ghalib.hospitalManagement.repo;

import com.ghalib.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient,Long> {


     // these are the query methods , these are  some standard methods , which can be resolve by the hibernate
     Patient findByName(String name);
     List<Patient> findByNameContainingOrderByIdDesc(String name);

     // if we want to write some complex query then , we can use @query

     @Query("select p.bloodGroup, Count(p) from Patient p group by p.bloodGroup")
     List<Object[]>countOfBloodGroup();
}
