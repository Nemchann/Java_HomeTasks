import java.util.ArrayList;
import java.util.List;

public class Department {
    private String department;
    private Employee boss;
    private List<Employee> employees = new ArrayList<>();

    public Department(String department){
        this.department = department;
    }

    public Employee addBoss(String bossName) {
        Employee newBoss = new Employee(bossName, this);
        this.employees.add(newBoss);
        this.boss = newBoss;
        return newBoss;
    }

    public void setBoss(Employee employee) {
        if (employee == null) {
            this.boss = null;
            return;
        }

        // Если сотрудник не в этом отделе - добавляем его
        if (!employees.contains(employee)) {
            this.addEmployee(employee);
        }

        this.boss = employee;
    }

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
            employee.work = this;  // Устанавливаем связь "сотрудник → отдел"
        }
    }

    public String getDepartment() {
        return department;
    }

    public Employee getBoss() {
        return boss;
    }

    // Метод для получения всех сотрудников отдела
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

}
