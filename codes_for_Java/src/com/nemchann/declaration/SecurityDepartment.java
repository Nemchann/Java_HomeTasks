package com.nemchann.declaration;

public class SecurityDepartment extends Department{
    @Override
    public void sign(Declaration declaration) {
        if (declaration.getAuthor().contains("Запрещенное имя") || declaration.getAuthor().contains("Плохое имя")){
            declaration.reject();
            System.out.println("Запрещенное имя автора");
            return;
        }
        System.out.println("Заявление прошло проверку отдела безопасности");
        declaration.addSign("Безопасность");
        passToNext(declaration);
    }
}
