package com.nemchann.student;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


public class Student implements Comparable<Student> {
    private final String name;
    private List<Integer> grades;
    private final Predicate<Integer> gradeValidator;

    public Student(String name, Predicate<Integer> gradeValidator, Integer...grades){
        this.name = name;
        this.gradeValidator = gradeValidator;
        for (Integer grade : grades){
            if (!gradeValidator.test(grade)){
                throw new IllegalArgumentException("Недопустимая оценка");
            }
        }
        this.grades = Arrays.asList(grades);

    }

    public Student(String name, Predicate<Integer> gradeValidator){
        this(name, gradeValidator, new Integer[0]);
    }

    public Double avg(){
        Double summ = 0.0;
        for(Integer grade : grades){
            summ += grade;
        }
        return summ / grades.size();
    }

    public void addGrade(Integer grade){
        if (!gradeValidator.test(grade)) throw new IllegalArgumentException("Недопустимая оценка");
        grades.add(grade);
    }


    @Override
    public int compareTo(Student student) {
        return Double.compare(this.avg(), student.avg());
    }

    @Override
    public String toString() {
        return name + ": " + grades.toString();
    }
}
