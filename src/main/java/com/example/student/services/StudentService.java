package com.example.student.services;

import java.util.List;

import com.example.student.entities.Student;
import com.example.student.exception.StudentExistException;
import com.example.student.exception.StudentNotFoundException;

public interface StudentService {

    public List<Student> getStudents();
    public Student getStudent(int id) throws StudentNotFoundException; 
    public Student addStudent(Student student) throws StudentExistException;
    public Student updateStudent(Student student) throws StudentNotFoundException;
    public void deleteStudent(int id);
}
