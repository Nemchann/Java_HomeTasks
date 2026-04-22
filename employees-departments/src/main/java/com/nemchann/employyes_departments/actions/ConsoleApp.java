package com.nemchann.employyes_departments.actions;

import com.nemchann.employyes_departments.entity.Department;
import com.nemchann.employyes_departments.entity.Employee;
import com.nemchann.employyes_departments.repository.DepartmentRepository;
import com.nemchann.employyes_departments.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleApp implements CommandLineRunner {
    private final Scanner scanner;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    private ConsoleApp(Scanner scanner, EmployeeRepository employeeRepository,
                       DepartmentRepository departmentRepository){
        this.scanner = scanner;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args){
        System.out.println("1. Вставить сотрудника");
        System.out.println("2. Вставить отдел");
        System.out.println("3. Все сотрудники");
        System.out.println("4. Все отделы");
        System.out.println("5. Удалить сотрудника");
        System.out.println("6. Удалить отдел");
        System.out.println("7. Обновить сотрудника");
        System.out.println("8. Обновить отдел");
        System.out.println("0. Выйти");
        String str = scanner.nextLine();
        while (!"0".equals(str)){
            if ("1".equals(str)){
                createEmployee();
            }
            if ("2".equals(str)){
                createDepartment();
            }
            if ("3".equals(str)){
                findAllEmployees();
            }
            if ("4".equals(str)){
                findAllDepartments();
            }
            if ("5".equals(str)){
                deleteEmployeeById();
            }
            if ("6".equals(str)){
                deleteDepartmentByName();
            }
            if ("7".equals(str)){
                updateEmployee();
            }
            if ("8".equals(str)){
                updateDepartment();
            }
            System.out.println("1. Вставить пользователя");
            System.out.println("2. Вставить отдел");
            System.out.println("3. Все сотрудники");
            System.out.println("4. Все отделы");
            System.out.println("5. Удалить сотрудника");
            System.out.println("6. Удалить отдел");
            System.out.println("7. Обновить сотрудника");
            System.out.println("8. Обновить отдел");
            System.out.println("0. Выйти");
            str = scanner.nextLine();
        }
    }

    private void createEmployee(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();

        System.out.println("Введите id отдела");
        Integer departmentId = scanner.nextInt();
        scanner.nextLine();

        Employee employee = new Employee(name, departmentId);
        employeeRepository.save(employee);

        System.out.println("Создан новый работник");
        System.out.println();
    }

    private void createDepartment(){
        System.out.println("Введите название отдела");
        String name = scanner.nextLine();

        Optional<Department> departmentOpt = departmentRepository.findByName(name);

        if (departmentOpt.isEmpty()){

            Department department = new Department(name);
            departmentRepository.save(department);

            System.out.println("Создан новый отдел");
        }
        else{
            System.out.println("Отдел с таким названием существует, нельзя создать такой же новый");
        }

        System.out.println();
    }

    private void findAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();

        for (Employee employee : employees){
            Integer id = employee.getId();
            String name = employee.getName();
            Integer departmentId = employee.getDepartmentId();

            System.out.println(id + ". " + name + ", отдел " + departmentId);
        }
        System.out.println();
    }

    private void findAllDepartments(){
        List<Department> departments = departmentRepository.findAll();

        for (Department department : departments) {
            Integer id = department.getId();
            String name = department.getName();

            System.out.println(id + ". " + name);
        }
        System.out.println();
    }

    private void deleteEmployeeById(){
        findAllEmployees();
        System.out.println("Введите id");
        Integer id = scanner.nextInt();
        scanner.nextLine();

        try{
            employeeRepository.deleteById(id);
            System.out.println("Сотрудник удален");
        }catch (Exception e){
            System.out.println("Такой сотрудник не найден");
        }
    }

    private void deleteDepartmentByName(){
        findAllDepartments();
        System.out.println("Введите название отдела");
        String name = scanner.nextLine();

        try{
            departmentRepository.deleteByName(name);
            System.out.println("Отдел удален");
        }catch (Exception e){
            System.out.println("Такой отдел не найден или его нельзя удалить из-за того, " +
                    "что там еще работают сотрудники");
        }
    }

    private void updateEmployee(){
        System.out.println("Имя сотрудника нельзя изменить, потому что он пришел работать " +
                "с таким именем, так что обращайтесь к админу, если вы собирались изменить имя сотрудника."
                + "\nВведите имя сотрудника");
        String name = scanner.nextLine();
        Optional<Employee> employeeOpt = employeeRepository.findByName(name);

        System.out.println("Введите название отдела, куда его переводят");
        String departmentName = scanner.nextLine();
        Optional<Department> departmentOpt = departmentRepository.findByName(departmentName);

        if (employeeOpt.isPresent() && departmentOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            Department department = departmentOpt.get();
            Integer departmentId = department.getId();

            System.out.println(departmentId);
            employee.setDepartmentId(departmentId);

            employeeRepository.save(employee);

            System.out.println("Сотрудник успешно переведен");
        } else if (departmentOpt.isEmpty()){
            System.out.println("Такой отдел: " + departmentName + "не найден");
        } else{
            System.out.println("Сотрудник с именем " + name + " не найден");
        }

    }

    private void updateDepartment(){
        System.out.println("Введите название отдела");
        String name = scanner.nextLine();
        Optional<Department> departmentOpt = departmentRepository.findByName(name);

        if (departmentOpt.isPresent()){
            Department department = departmentOpt.get();

            System.out.println("Введите новое название отдела");
            String newName = scanner.nextLine();
            department.setName(newName);

            departmentRepository.save(department);
            System.out.println("Отдел успешно обновлен");
        }else{
            System.out.println("Отдел с названием:" + name + " не найден");
        }
    }
}
