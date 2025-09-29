import java.util.Arrays;

public class Student {
    String name;
    int[] grades;

    public Student(String name){
        this.name = name;
    }

    public Student(String name, int[] grades){
        this.name = name;
        this.grades = grades;
    }

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

    public String toString(){
        String result = name;
        if (grades != null){
            result += ": " + Arrays.toString(grades);
        }
        return result;
    }
}
