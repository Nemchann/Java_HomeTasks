import java.util.ArrayList;
import java.util.List;

public class Department {
    String department;
    Employee boss;
    List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.work = this;
    }

    // Метод для получения всех сотрудников отдела
    public List<Employee> getEmployees() {
        return employees;
    }

}
