import java.util.Arrays;

public class Student implements Meowable{
    String name;
    int[] grades;

    public Student(String name, int... params) {
        this.name = name;

        // Если передан один параметр и это массив оценок
//        if (params.length == 1) {
//            if (params[0] > 5 || params[0] < 2){
//                throw new IllegalArgumentException("Grades must be between 2 and 5");
//            }
//            this.grades = params;
//        }
        // Если переданы отдельные оценки как числа
        if (params.length > 0) {
            this.grades = new int[params.length];
            for (int i = 0; i < params.length; i++) {
                if (params[i]> 5 || params[i] < 2){
                    throw new IllegalArgumentException("Grades must be between 2 and 5");
                }
                this.grades[i] = params[i];
            }
        }
        // Если параметров нет - grades останется null
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

    public String toString(){
        String result = name;
        if (grades != null){
            result += ": " + Arrays.toString(grades);
        }
        return result;
    }
}
