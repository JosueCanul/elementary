package com.elementary.mx.elementary.model;

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

    public int getGrade() {
        return this.grade;
    }

}
