package com.elementary.mx.elementary.model;

public class IrregularStudent {

    private String enrollment;
    private String name;
    private int numberOfFailedSubjects;

    // constructor
    public IrregularStudent(String enrollment, String name, int numberOfFailedSubjects) {
        this.enrollment = enrollment;
        this.name = name;
        this.numberOfFailedSubjects = numberOfFailedSubjects;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfFailedSubjects() {
        return numberOfFailedSubjects;
    }

    public void setNumberOfFailedSubjects(int numberOfFailedSubjects) {
        this.numberOfFailedSubjects = numberOfFailedSubjects;
    }

}

