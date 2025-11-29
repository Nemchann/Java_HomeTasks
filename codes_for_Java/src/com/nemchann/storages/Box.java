package com.nemchann.storages;

public class Box <T>{
    T obj;

    public T getObj(){
        T tmp = obj;
        return tmp;
    }

    public void putObj(T obj){
        if (this.obj != null){
            throw new BoxOverflowException("You can't put sth in box");
        }
        this.obj = obj;
    }

    public T takeObj(){
        T tmp = obj;
        obj = null;
        return tmp;
    }

    public boolean isEmpty(){
        return obj == null;
    }

    @Override
    public String toString() {
        return "Box{" +
                "obj=" + obj +
                '}';
    }
}
