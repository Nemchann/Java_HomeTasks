package com.nemchann.declaration;


import java.util.Random;

public class PersonnelDepartment extends Department{
    Random vacations = new Random();
    @Override
    public void sign(Declaration declaration) {
        if(!calculateVacations()){
            declaration.reject();
            System.out.println("Недостаточно кадров");
            return;
        }
        System.out.println("Заявление прошло проверку отдела кадров");
        declaration.addSign("отдел кадров");
        passToNext(declaration);

    }
    private boolean calculateVacations(){
        return vacations.nextBoolean();
    }
}
