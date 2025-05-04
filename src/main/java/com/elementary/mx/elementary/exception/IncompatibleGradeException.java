package com.elementary.mx.elementary.exception;

public class IncompatibleGradeException extends RuntimeException{
    public IncompatibleGradeException (){
        super("Student grade must match course grade");
    }
}
