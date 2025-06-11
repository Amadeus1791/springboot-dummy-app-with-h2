package com.codersbay.depoloymentReplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
    
    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String name) {
        return studentRepository.findByNameContaining(name);
    }
    
    @GetMapping("/older-than/{age}")
    public List<Student> getStudentsOlderThan(@PathVariable int age) {
        return studentRepository.findByAgeGreaterThan(age);
    }
}

