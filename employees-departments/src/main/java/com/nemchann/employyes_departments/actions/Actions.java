package com.nemchann.employyes_departments.actions;

import com.nemchann.employyes_departments.service.DepartmentService;
import com.nemchann.employyes_departments.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Scanner;

@Component
public class Actions {
    private static final Scanner scanner = new Scanner(System.in);
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;

    @Autowired
    private Actions(EmployeeService employeeService, DepartmentService departmentService){
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @Autowired
    public void mainMethod(){
        System.out.println("1. Вставить пользователя");
        System.out.println("2. Вставить отдел");
        String str = scanner.nextLine();
        while (!"0".equals(str)){
            if ("1".equals(str)){
                createEmployee();
            }
            if ("2".equals(str)){

            }
            System.out.println("1. Вставить пользователя");
            System.out.println("2. Вставить отдел");
        }
    }

    private void createEmployee(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите id отдела");
        Integer departmentId = scanner.nextInt();
        scanner.nextLine();
        employeeService.createEmployee(name, departmentId);
        System.out.println("Создан новый работник");
    }

    private void createDepartment(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        departmentService.createDepartment(name);
        System.out.println("Создан новый отдел");
    }
}
