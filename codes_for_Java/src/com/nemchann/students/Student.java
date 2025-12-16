package com.nemchann.students;

import com.nemchann.animals.Meowable;
import com.nemchann.mathematic.Fraction;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class Student implements Meowable, Comparable<Student> {
    String name;
    int[] grades;
    GradeValidator validator;

    // Стек для хранения состояний для отмены
    private final Stack<StudentMemento> history = new Stack<>();
    // Стек для повторения действий
    private final Stack<StudentMemento> redoStack = new Stack<>();


    public interface Memento {

    }

    // Внутренний класс Memento для сохранения состояния
    private static class StudentMemento implements Memento{
        private final String name;
        private final int[] grades;

        public StudentMemento(String name, int[] grades) {
            this.name = name;
            this.grades = (grades != null) ? Arrays.copyOf(grades, grades.length) : null;
        }

        public String getName() {
            return name;
        }

        public int[] getGrades() {
            return (grades != null) ? Arrays.copyOf(grades, grades.length) : null;
        }
    }

    // Сохранить текущее состояние
    private void saveState() {
        history.push(new StudentMemento(name, grades));
        redoStack.clear(); // При новом действии очищаем стек redo
    }

    // Восстановить состояние из memento
    private void restoreState(StudentMemento memento) {
        this.name = memento.getName();
        this.grades = memento.getGrades();
    }

    public Memento save() {
        return new StudentMemento(name, grades);
    }

    public void restore(Memento memento) {
        if (memento == null) {
            throw new IllegalArgumentException("Memento не может быть null");
        }

        if (!(memento instanceof StudentMemento)) {
            throw new IllegalArgumentException("Некорректный тип Memento");
        }

        // Сохраняем текущее состояние в историю перед восстановлением
        saveState();

        // Восстанавливаем состояние
        StudentMemento studentMemento = (StudentMemento) memento;
        restoreState(studentMemento);
    }

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
        saveState();
    }
    // Конструктор без валидатора (все оценки допустимы)
    public Student(String name, int... grades) {
        this(name, GradeValidator.any(), grades);
    }

    // Изменение имени с сохранением состояния
    public void setName(String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        saveState();
        this.name = newName;
    }

    public void addGrade(int grade){
        if (!validator.isValid(grade)){
            throw new IncorrectGradeException("Студенту " + name + " нельзя присвоить оценку: " + grade);
        }

        saveState();

        if (grades == null) {
            grades = new int[]{grade};
        } else {
            int[] newGrades = Arrays.copyOf(grades, grades.length + 1);
            newGrades[newGrades.length - 1] = grade;
            grades = newGrades;
        }
    }

    public void removeLastGrade() {
        if (grades == null || grades.length == 0) {
            throw new IllegalStateException("Нет оценок для удаления");
        }
        saveState();

        if (grades.length == 1) {
            grades = null;
        } else {
            grades = Arrays.copyOf(grades, grades.length - 1);
        }
    }

    public boolean undo() {
        if (history.size() <= 1) { // Не отменяем начальное состояние
            return false;
        }

        // Сохраняем текущее состояние в redo стек
        redoStack.push(new StudentMemento(name, grades));

        // Удаляем текущее состояние из истории
        history.pop();

        // Восстанавливаем предыдущее состояние
        StudentMemento previous = history.peek();
        restoreState(previous);

        return true;
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
    public int compareTo(Student other) {
        double thisAvg = this.getAverage();
        double otherAvg = other.getAverage();
        if (thisAvg > otherAvg) return 1;
        else if (thisAvg < otherAvg) return -1;
        else return 0;
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

    @Override
    public int hashCode() {
        return Objects.hash(name, this.getAverage());
    }

    public String toString(){
        String result = name;
        if (grades != null){
            result += ": " + Arrays.toString(grades);
        }
        return result;
    }
}
