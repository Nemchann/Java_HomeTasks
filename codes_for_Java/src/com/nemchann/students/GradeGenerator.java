package com.nemchann.students;

import java.util.Random;

public class GradeGenerator {

    public void generateGrades(Student...students){
        int[] generatedGrades = new int[students.length];
        // Сначала генерируем ВСЕ оценки и проверяем их ВАЛИДНОСТЬ
        for (int i = 0; i < students.length; i++) {
            int randomGrade = new Random().nextInt(10) + 1;
            generatedGrades[i] = randomGrade;

            // Проверяем, можно ли студенту присвоить эту оценку
            if (!students[i].validator.isValid(randomGrade)) {
                throw new IncorrectGradeException(
                        "Студенту " + students[i].name + " нельзя присвоить оценку: " + randomGrade +
                                ". Оценки никому не присвоены!"
                );
            }
        }

        // Если все оценки валидны - присваиваем их студентам
        for (int i = 0; i < students.length; i++) {
            students[i].addGrade(generatedGrades[i]);
        }
    }
}
