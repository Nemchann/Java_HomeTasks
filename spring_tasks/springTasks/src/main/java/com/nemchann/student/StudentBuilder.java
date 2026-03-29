package com.nemchann.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class StudentBuilder {
    private final Predicate<Integer> gradeValidator;

    @Autowired
    public StudentBuilder(@Qualifier("predicateBean") Predicate<Integer> gradeValidator){
        this.gradeValidator = gradeValidator;
    }

    public Student build(String name){
        return new Student(name, gradeValidator);
    }

    public Student build(String name, Integer...grades){
        return new Student(name, gradeValidator, grades);
    }

    public Student build(String name, List<Integer> grades){
        return new Student(name, gradeValidator, grades.toArray(new Integer[0]));
    }
}
