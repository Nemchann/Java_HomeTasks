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

    public String toString(){
        String result = name;
        if (grades != null){
            result += ": " + Arrays.toString(grades);
        }
        return result;
    }
}
