package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>{

}
