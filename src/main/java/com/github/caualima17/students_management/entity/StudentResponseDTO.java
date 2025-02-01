package com.github.caualima17.students_management.entity;

import java.util.List;

public record StudentResponseDTO(Long id, List<ReportCard> reportCard, String name, String registration_id, String course) {
}
