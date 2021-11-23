package com.example.student.dao;

import com.example.student.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer>{
    
    // Student findStudentByName(String name);
}
