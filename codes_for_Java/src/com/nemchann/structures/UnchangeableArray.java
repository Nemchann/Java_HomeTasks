package com.nemchann.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class UnchangeableArray {
    int[] array;

    //Конструктор через массив
    public UnchangeableArray(int[] array){
        this.array = array;
    }

//    Через запятую
    public UnchangeableArray(Integer...values){
        this.array = new int[values.length];

        for (int i = 0; i < values.length; i++){
            if (values[i] != null){
                array[i] = values[i];
            }
        }
    }

//    Через список
    public UnchangeableArray(ArrayList<Integer> arrayList){
        this.array = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i) != null){
                array[i] = arrayList.get(i);
            }
        }
    }

//    Получить значение по индексу
    public int getPosition(int n){
        if (n < 0 || n >= array.length){
            throw new OutOfArrayScopeException("N must be in scopes of array size!");
        }
        return array[n];
    }

//    Поменять значение по индексу
    public void changeOneValue(int newValue, int n){
        if (n < 0 || n >= array.length){
            throw new OutOfArrayScopeException("N must be in scopes of array size!");
        }
        array[n] = newValue;
    }
//    Строковое представление
    public String becomeString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < array.length - 1; i++){
            stringBuilder.append(array[i]);
            stringBuilder.append(", ");
        }
        stringBuilder.append(array[array.length - 1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

//    Проверка на пустоту
    public boolean checkIsEmpty(){
        return array.length == 0;
    }
//      Получить размер
    public int getSize(){
        return array.length;
    }

//    Получить массив
    public int[] getArray(){
        return Arrays.copyOf(array, array.length);
    }
}
