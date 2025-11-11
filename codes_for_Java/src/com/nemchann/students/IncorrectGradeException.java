package com.nemchann.students;

public class IncorrectGradeException extends RuntimeException{
//    private final String studentName;
//    private final int invalidGrade;

    public IncorrectGradeException(){
        super();
//        this.studentName = null;
//        this.invalidGrade = -1;
    }

    public IncorrectGradeException(String message){
        super(message);
//        this.studentName = null;
//        this.invalidGrade = -1;
    }
}
