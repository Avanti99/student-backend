package com.example.student.services;

import java.util.List;
import java.util.Optional;

import com.example.student.dao.StudentDao;
import com.example.student.entities.Student;
import com.example.student.exception.StudentExistException;
import com.example.student.exception.StudentNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    public StudentDao studentDao;

    // List<Student> list;

    public StudentServiceImpl() {
        // list= new ArrayList<>();
        // list.add(new Student(1,"Neha","Arts"));

    }

    @Override
    public List<Student> getStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student getStudent(int id) throws StudentNotFoundException{
        // Student s = null;
        // for(Student student: list) {
        //     if(student.getId() == id) {
        //         s = student;
        //         break;
        //     }
        // }
        
        Student student = studentDao.getById(id);

        return student;
    }

    @Override
    public Student addStudent(Student student) throws StudentExistException{
        // list.add(student);

        // Student existingStudent = studentDao.findStudentByName(student.getName());

        // if(existingStudent != null) {
        //     throw new StudentExistException("Student already exists in repository");
        // }

        return studentDao.save(student);
    }

    @Override
    public Student updateStudent(Student student) throws StudentNotFoundException{
        // list.forEach(s -> {
        //     if(s.getId() == student.getId) {
        //         s.setName(student.getName());
        //         s.setStream(student.getStream());
        //     }
        // });
        System.out.println(student);
        return studentDao.saveAndFlush(student);
    }

    @Override
    public void deleteStudent(int id) {
        // list = this.list.stream().filter(s -> s.getId() != parseInt).collect(Collectors.toList());
        Optional<Student> optionalStudent = studentDao.findById(id);

        if(!optionalStudent.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Student not found");
        }

        studentDao.deleteById(id);
    }
    
}
