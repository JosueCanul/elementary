package com.elementary.mx.elementary.DTO.record;

import java.time.LocalDate;

public record MatchScore(Integer studentId, Integer subjectId, LocalDate startDate, LocalDate endDate) {
}
