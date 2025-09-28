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

        // Добавляем сотрудников в отдел
        dep.addEmployee(employee1);
        dep.addEmployee(employee2);
        dep.addEmployee(employee3);

        dep.boss = employee2;  // Назначаем начальника

        System.out.println("Информация о сотрудниках:");
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);

//        System.out.println("\nВсе сотрудники отдела " + dep.department + ":");
//        for (Employee emp : dep.getEmployees()) {
//            System.out.println("- " + emp.name);
//        }

        System.out.println("\nКоллеги Петрова:");
        for (Employee colleague : employee1.getColleagues()) {
            System.out.println("- " + colleague.name);
        }


    }
}