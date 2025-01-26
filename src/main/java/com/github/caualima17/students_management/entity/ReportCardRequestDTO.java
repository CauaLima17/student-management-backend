package com.github.caualima17.students_management.entity;

public record ReportCardRequestDTO(Long student_id, String subject, double grade, int semester) {
}
