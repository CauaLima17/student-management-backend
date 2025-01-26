package com.github.caualima17.students_management.services;

import com.github.caualima17.students_management.entity.ReportCard;
import com.github.caualima17.students_management.entity.ReportCardRequestDTO;
import com.github.caualima17.students_management.entity.ReportCardResponseDTO;
import com.github.caualima17.students_management.repositories.ReportCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportCardService {
    @Autowired
    ReportCardRepository reportCardRepository;

    public List<ReportCardResponseDTO> getAllByStudentId(Long id) {
        List<ReportCard> reportCards = reportCardRepository.findByStudentId(id);
        return reportCards.stream()
                .map(r -> new ReportCardResponseDTO(
                        r.getId(),
                        r.getStudent_id(),
                        r.getSubject(),
                        r.getGrade(),
                        r.getSemester()
                )).toList();
    }

    public void saveReportCard(ReportCardRequestDTO data) {
        ReportCard reportCard = new ReportCard(data);
        reportCardRepository.save(reportCard);
        return;
    }
}
