import java.util.Arrays;

public class Student {
    String name;
    int[] grades;

    public String toString(){
        return name + ": " + Arrays.toString(grades);
    }
}
