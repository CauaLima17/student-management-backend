package com.github.caualima17.students_management.services;

import com.github.caualima17.students_management.entity.Student;
import com.github.caualima17.students_management.entity.StudentRequestDTO;
import com.github.caualima17.students_management.entity.StudentResponseDTO;
import com.github.caualima17.students_management.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentResponseDTO> getAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> new StudentResponseDTO(
                student.getId(),
                student.getReportCard(),
                student.getName(),
                student.getRegistration_id(),
                student.getCourse()
        )).toList();
    }

    public StudentResponseDTO getById(Long id) {
        return studentRepository.findById(id)
                .map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getReportCard(),
                        student.getName(),
                        student.getRegistration_id(),
                        student.getCourse()
                )).orElseThrow(() -> new EntityNotFoundException("Nenhum estudante encontrado com o ID: " + id));
    }

    public void saveStudent(StudentRequestDTO data) {
        Student student = new Student(data);
        studentRepository.save(student);
        return;
    }

    public void updateStudent(Long id, StudentRequestDTO data) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum " +
                "estudante encontrado com o ID: " + id));

        student.setName(data.name() == null ? student.getName() : data.name());
        student.setRegistration_id(data.registration_id() == null ? student.getRegistration_id() : data.registration_id());
        student.setCourse(data.course() == null ? student.getCourse() : data.course());
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException("Nenhum estudante encontrado com o ID: " + id);
        }

        studentRepository.deleteById(id);
    }
}
