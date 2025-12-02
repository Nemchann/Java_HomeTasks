package com.nemchann.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stack<T> {
    private final static int MAX_SIZE_DEFAULT = 100;
    private List<T> stack = new ArrayList<>();
    private int size;

    public Stack(){
        this.size = 0;
    }

    public void push(T value){
        if(size >= MAX_SIZE_DEFAULT){
            throw new StackOverflowError("Stack is overflow");
        }
        stack.add(value);
        size++;
    }

    public T pop(){
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }

        T lastValue = stack.get(size - 1); // Получаем последний элемент
        stack.remove(size - 1); // Удаляем его из списка
        size--;

        return lastValue;
    }

    public T peak(){
        T lastValue = stack.getLast();
        return lastValue;
    }
}
