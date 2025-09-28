public class Main {
    public static void main(String[] args) {
//        1
        Student student1 = new Student();
        student1.name = "Вася";
        student1.grades = new int[]{3, 4, 5};
        System.out.println(student1);

//        2
        Student student2 = new Student();
        student2.name = "Петя";
        student2.grades = student1.grades;
        System.out.println(student2);
        System.out.println("\n");

//        3
        student2.grades[0] = 5;
        System.out.println(student1);
        System.out.println(student2);
        System.out.println("\n");

//        4
        student1.grades[0] = 3;
        Student student3 = new Student();
        student3.name = "Андрей";

//        Копируем оценки Васи в отдельный массив
        int[] andrewMarks = new int[student1.grades.length];
        for (int i = 0; i < student1.grades.length; i++){
            andrewMarks[i] = student1.grades[i];
        }
        student3.grades = andrewMarks;
        student1.grades[0] = 5;
        System.out.println(student1);
        System.out.println(student3);
    }
}