package com.example.student.controller;

import java.util.List;

import com.example.student.entities.Student;
import com.example.student.exception.StudentExistException;
import com.example.student.exception.StudentNotFoundException;
import com.example.student.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable String studentID) throws StudentNotFoundException {
        return this.studentService.getStudent(Integer.parseInt(studentID));
        
    }

    @PostMapping("/students")
    public ResponseEntity<Void> addStudent(@RequestBody Student student, UriComponentsBuilder builder) throws StudentExistException {
        this.studentService.addStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/students/{studentID}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) throws StudentNotFoundException{
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/students/{studentID}")
    public void deleteStudent(@PathVariable String studentID) {
        this.studentService.deleteStudent(Integer.parseInt(studentID));
    }

    @GetMapping("/addStudentForm")
    public ModelAndView addStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        ModelAndView obj = new ModelAndView("newstudent");
        return obj;
    }

    @PostMapping("/saveStudent")
    public ModelAndView saveStudent(@ModelAttribute("student") Student student) throws StudentExistException {
        studentService.addStudent(student);
        ModelAndView obj = new ModelAndView("redirect:/");
        return obj;
    }

    @GetMapping("/showForm/{id}")
    public ModelAndView showForm(@PathVariable (value = "id") int id, Model model) throws StudentNotFoundException {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        ModelAndView obj = new ModelAndView("updatestudent");
        return obj;
    }

    @GetMapping("/deleteStudent/{id}")
    public ModelAndView deleteStudent(@PathVariable (value="id") int id) {
        this.studentService.deleteStudent(id);
        ModelAndView obj = new ModelAndView("redirect:/");
        return obj;
    }

}
