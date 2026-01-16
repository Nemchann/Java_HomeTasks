package com.nemchann.training.chain_of_responsibility;

public class LoanManager extends Handler{
    @Override
    public void handle(LoanRequest request) {
        System.out.println("Проверяет менеджер");
        String purpose = request.getPurpose();
        if (!processAndContinue(request)) {
            return;
        }
        if (!purpose.contains("образование") && !purpose.contains("помощь")
                && !purpose.contains("лечение") && !purpose.contains("лечить")){
            System.out.println("Не выдаем кредит по таким просьбам!");
            request.reject("Плохой запрос на кредит");
            return;
        }
        System.out.println("Менеджер учел просьбу");
        passToNext(request);

    }
}
