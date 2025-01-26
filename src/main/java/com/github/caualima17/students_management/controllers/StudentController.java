package com.github.caualima17.students_management.controllers;

import com.github.caualima17.students_management.entity.StudentRequestDTO;
import com.github.caualima17.students_management.entity.StudentResponseDTO;
import com.github.caualima17.students_management.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAll() {
        List<StudentResponseDTO> students = studentService.getAll();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getById(@PathVariable Long id) {
        StudentResponseDTO student = studentService.getById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public void saveStudent(@RequestBody StudentRequestDTO data) {
        studentService.saveStudent(data);
        return;
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentRequestDTO data) {
        studentService.updateStudent(id, data);
        return;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return;
    }
}
