package com.github.caualima17.students_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table (name = "student")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "student")
    private List<ReportCard> reportCard;
    private String name;
    private String registration_id;
    private String course;


    public Student(StudentRequestDTO data) {
        this.name = data.name();
        this.registration_id = data.registration_id();
        this.course = data.course();
    }
}
