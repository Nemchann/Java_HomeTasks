package com.nemchann.training.chain_of_responsibility;

public class CreditChecker extends Handler{
    @Override
    public void handle(LoanRequest request) {
        System.out.println("Проверка кредитной истории...");
        if (!processAndContinue(request)) {
            return;
        }
        if(request.getCreditStore() < 3){
            System.out.println("Слишком плохая кредитная история!");
            request.reject("Плохая кредитная история");
            return;
        }

        System.out.println("Проверка кредитной истории завершена");
        passToNext(request);
    }
}
