import java.util.ArrayList;
import java.util.List;

public class Employee {
    String name;
    Department work;

    public Employee(String name){
        this.name = name;
    }

    Employee(String name, Department work){
        this.name = name;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public Department getWork() {
        return work;
    }

    public String toString(){
        if (work == null) {
            return name + " не работает в отделе";
        }

        boolean check = name.equals(work.getBoss().name);
        if (check) return name + " начальник отдела " + work.getDepartment();
        else return name + " работает в отделе " + work.getDepartment() + ", начальник которого " + work.getBoss().name;

    }

    // Метод для получения всех коллег из того же отдела
    public List<Employee> getColleagues() {
        if (work != null) {
            return work.getEmployees();
        }
        return new ArrayList<>();  // Пустой список, если нет отдела
    }
}
