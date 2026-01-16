package com.nemchann.training.chain_of_responsibility;

public abstract class Handler {
    private Handler next;

    public void setNext(Handler handler){
        this.next = handler;
    }
    public abstract void handle(LoanRequest request);

    protected void passToNext(LoanRequest request) {
        if (next != null) {
            next.handle(request);
        } else {
            System.out.println("Цепочка завершена. Запрос не обработан.");
        }
    }

    protected boolean processAndContinue(LoanRequest request) {
        // Если запрос уже отклонён - прерываем цепочку
        if (request.isRejected()) {
            System.out.println("⛔ Запрос отклонён на предыдущем этапе. Цепочка прервана.");
            return false;
        }
        return true;
    }

}
