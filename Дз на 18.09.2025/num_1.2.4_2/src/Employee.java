public class Employee {
    String name;
    Department work;

    public String toString(){
        boolean check = name.equals(work.boss.name);
        if (check) return name + " начальник отдела " + work.department;
        else return name + " работает в отделе " + work.department + ", начальник которого " + work.boss.name;
    }
}
