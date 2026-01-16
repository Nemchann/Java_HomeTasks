package com.nemchann.training.chain_of_responsibility;

public class Validator extends Handler{
    @Override
    public void handle(LoanRequest request) {
        System.out.println("Валидатор проверяет данные...");
        if (!processAndContinue(request)) {
            return;
        }
        if (request.getAmount() <= 0){
            System.out.println("Сумма не может быть меньше нуля");
            request.reject("Некорректная сумма");
            return;
        }
        else if (request.getPurpose() == null && request.getPurpose().isEmpty()){
            System.out.println("Просьба не может быть пустой");
            request.reject("Некорректная просьба");
            return;
        }
        else if(request.getCreditStore() > 5 || request.getCreditStore() < 1){
            System.out.println("Некорректный рейтинг кредитной истории");
        }
        System.out.println("Данные корректны!");
        passToNext(request);
    }
}
