package com.nemchann.feedbacks;

public class Feedback {
    private int grade;
    private String text;

    public Feedback(int grade, String text){
        this.grade = grade;
        this.text = text;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString(){
        return "Оценка: " + grade + ", текст: " + text;
    }
}
