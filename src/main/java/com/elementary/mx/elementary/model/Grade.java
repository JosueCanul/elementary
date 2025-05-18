package com.elementary.mx.elementary.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Grade {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    SIXTH(6);

    private final int grade;

    Grade(int grade) {
        this.grade = grade;
    }

    @JsonValue
    public String toJson() {
        return this.name(); // Devuelve "SECOND", "THIRD", etc.
    }

    @JsonCreator
    public static Grade fromJson(String value) {
        return Grade.valueOf(value); // Convierte "SECOND" en Grade.SECOND
    }

    public int getGrade() {
        return this.grade;
    }
}
