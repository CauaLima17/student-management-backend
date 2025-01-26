package com.github.caualima17.students_management.repositories;

import com.github.caualima17.students_management.entity.ReportCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportCardRepository extends JpaRepository<ReportCard, Long> {
    @Query("SELECT r FROM ReportCard r WHERE r.student.id = :student_id")
    List<ReportCard> findByStudentId(@Param("student_id") Long id);
}
