package com.example.restful_api.controller;

import com.example.restful_api.entity.Student;
import com.example.restful_api.repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRespository studentRespository;

    @GetMapping(value = "/")
    public List<Student> viewStudentList() {
        return studentRespository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Student viewStudentById(
            @PathVariable (value = "id") Long id) {
        return studentRespository.findById(id).get();
    }

    @PostMapping(value = "/")
    public Student addStudent(
            @RequestBody Student student) {
        return studentRespository.save(student);
    }

    @PutMapping(value = "/{id}")
    public void updateStudent(
            @PathVariable(value = "id") Long id,
            @RequestBody Student student) {
        if (studentRespository.existsById(id)) {
            student.setId(id);
            studentRespository.save(student);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent(
            @PathVariable(value = "id") Long id) {
        if (studentRespository.existsById(id)) {
            Student student = studentRespository.getById(id);
            studentRespository.delete(student);
        }
    }
}
