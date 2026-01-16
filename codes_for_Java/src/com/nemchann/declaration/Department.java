package com.nemchann.declaration;

public abstract class Department {
    private Department next;
    private Department previous;

    public void setNext(Department next) {
        this.next = next;
        next.previous = this;
    }

    public abstract void sign(Declaration declaration);

    protected void passToNext(Declaration declaration){
        if(next != null){
            next.sign(declaration);
        }
        else{
            System.out.println("Цепочка завершена");
        }
    }
    protected void passToPrevious(Declaration declaration){
        if(previous != null){
            previous.sign(declaration);
        }
        else{
            System.out.println("Цепочка завершена");
        }
    }

}
