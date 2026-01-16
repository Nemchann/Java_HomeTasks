package com.nemchann.training.chain_of_responsibility;

public class CreditNotifier extends Handler{

    @Override
    public void handle(LoanRequest request) {
        request.approve();
        if (!processAndContinue(request)) {
            System.out.println("📩 Клиенту отправлен отказ: " + request.getRejectionReason());
            return;
        }
        System.out.println("Запрос на кредит одобрен");
    }
}
