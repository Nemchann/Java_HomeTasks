public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        Department dep = new Department();
        dep.department = "IT";
        employee1.name = "Петров";
        employee1.work = dep;
        employee2.name = "Козлов";
        employee2.work = dep;
        employee3.name = "Сидоров";
        employee3.work = dep;

        dep.boss = employee2;

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);


    }
}