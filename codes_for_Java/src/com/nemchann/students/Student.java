package com.nemchann.students;

import com.nemchann.animals.Meowable;
import com.nemchann.mathematic.Fraction;

import java.util.Arrays;
import java.util.Objects;

public class Student implements Meowable {
    String name;
    int[] grades;
    GradeValidator validator;

    public Student(String name, GradeValidator validator, int... params) {
        this.name = name;
        this.validator = (validator != null) ? validator : GradeValidator.any();

        if (params.length > 0) {
            this.grades = new int[params.length];
            for (int i = 0; i < params.length; i++) {
                if (!this.validator.isValid(params[i])) {
                    throw new IncorrectGradeException(
                            "Студенту " + name + " нельзя присвоить оценку: " + params[i]
                    );
                }
                this.grades[i] = params[i];
            }
        }
    }
    // Конструктор без валидатора (все оценки допустимы)
    public Student(String name, int... grades) {
        this(name, GradeValidator.any(), grades);
    }

    public void addGrade(int grade){
        if (!validator.isValid(grade)){
            throw new IncorrectGradeException("Студенту " + name + " нельзя присвоить оценку: " + grade);
        }
        if (grades == null) {
            grades = new int[]{grade};
        } else {
            int[] newGrades = Arrays.copyOf(grades, grades.length + 1);
            newGrades[newGrades.length - 1] = grade;
            grades = newGrades;
        }
    }


    public int[] getGrades() {
        return Arrays.copyOf(this.grades, this.grades.length);
    }

    public double getAverage(){
        if (grades == null || grades.length == 0) {
            return 0;
        }
        double average = 0;
        for (int i = 0; i < grades.length; i++){
            average += grades[i];
        }
        average /= grades.length;
        return average;
    }

    public boolean isExcellentPupil(){
        boolean check = true;
        for (int i = 0; i < grades.length; i++){
            if (grades[i] < 5) {
                check = false;
                break;
            }
        }
        return check;
    }

    public void getInfo(){
        String result = name + "\nОценки: ";
        if (grades != null){
            result += Arrays.toString(grades) + "\n";
        }
        if (!isExcellentPupil()){
            result += "Не";
        }
        result += "отличник\nСреднее арифм. оценок: ";
        result += getAverage();
        System.out.println(result);

    }

    @Override
    public void meow() {
        System.out.println(name + ": Мяу! Мои оценки: " + Arrays.toString(getGrades()));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        if (!Objects.equals(this.name, student.name) || this.getAverage() != student.getAverage()) return false;
        return true;
    }

    public String toString(){
        String result = name;
        if (grades != null){
            result += ": " + Arrays.toString(grades);
        }
        return result;
    }
}
