package com.riwi.prueba_desempeno.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.prueba_desempeno.domain.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    
}
