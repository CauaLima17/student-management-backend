package com.github.caualima17.students_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table (name = "report_card")
@Entity (name = "report_card")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportCard {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long student_id;
    private String subject;
    private double grade;
    private String semester;
}
