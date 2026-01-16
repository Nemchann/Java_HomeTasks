package com.nemchann.declaration;

import static java.lang.Character.isUpperCase;

public class AccountantDepartment extends Department{

    @Override
    public void sign(Declaration declaration) {
        if(!isUpperCase(declaration.getText().toCharArray()[0])){
            declaration.reject();
            System.out.println("Заявление не прошло проверку бухгалтерии");
            return;
        }
        if(!containsSignature("отдел кадров", declaration)){
            passToPrevious(declaration);
            System.out.println("передано в отдел кадров");

            if (!declaration.isAccepted()) {
                System.out.println("Отдел кадров отклонил заявление");
                return;
            }

            if (!Character.isUpperCase(declaration.getText().charAt(0))) {
                declaration.reject();
                System.out.println("После отдела кадров текст испорчен");
                return;
            }
        }
        declaration.addSign("Бухгалтерия");
        declaration.accept();
        System.out.println("Заявление прошло все этапы проверок");

    }

    private boolean containsSignature(String signature, Declaration declaration){
        for (String string : declaration.getSignatures()){
            if(string.contains(signature)){
                return true;
            }
        }
        return false;
    }
}
