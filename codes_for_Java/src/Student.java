import java.util.Arrays;

public class Student {
    String name;
    int[] grades;

    public Student(String name, Object... params) {
        this.name = name;

        // Если передан один параметр и это массив оценок
        if (params.length == 1 && params[0] instanceof int[]) {
            this.grades = (int[]) params[0];
        }
        // Если переданы отдельные оценки как числа
        else if (params.length > 0) {
            this.grades = new int[params.length];
            for (int i = 0; i < params.length; i++) {
                this.grades[i] = (Integer) params[i];
            }
        }
        // Если параметров нет - grades останется null
    }

//    public Student(String name){
//        this.name = name;
//    }
//
//    public Student(String name, int[] grades){
//        this.name = name;
//        this.grades = grades;
//    }

    public double getAverage(){
        if (grades.length == 0){
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
        if (isExcellentPupil() == false){
            result += "Не";
        }
        result += "отличник\nСреднее арифм. оценок: ";
        result += getAverage();
        System.out.println(result);

    }

    public String toString(){
        String result = name;
        if (grades != null){
            result += ": " + Arrays.toString(grades);
        }
        return result;
    }
}
