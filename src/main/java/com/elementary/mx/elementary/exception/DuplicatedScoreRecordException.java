package com.elementary.mx.elementary.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicatedScoreRecordException extends SQLIntegrityConstraintViolationException{
    public DuplicatedScoreRecordException(){
        super("The student cannot enroll in the same subject twice at the same time");
    }
}
