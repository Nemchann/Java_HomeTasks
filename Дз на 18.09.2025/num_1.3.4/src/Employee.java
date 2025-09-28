import java.util.ArrayList;
import java.util.List;

public class Employee {
    String name;
    Department work;

    public String toString(){
        if (work == null) {
            return name + " не работает в отделе";
        }

        boolean check = name.equals(work.boss.name);
        if (check) return name + " начальник отдела " + work.department;
        else return name + " работает в отделе " + work.department + ", начальник которого " + work.boss.name;

    }

    // Метод для получения всех коллег из того же отдела
    public List<Employee> getColleagues() {
        if (work != null) {
            return work.getEmployees();
        }
        return new ArrayList<>();  // Пустой список, если нет отдела
    }
}
