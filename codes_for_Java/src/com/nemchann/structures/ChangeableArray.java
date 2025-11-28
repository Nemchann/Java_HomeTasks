package com.nemchann.structures;

import java.util.ArrayList;
import java.util.Arrays;

public class ChangeableArray {
    int[] array;
    private int size;

//    Конструктор без параметров
    public ChangeableArray(){
        this.size = 0;
        this.array = new int[size];
    }
//    Конструктор с массивом
    public ChangeableArray(int[] values){
        this.array = values;
        this.size = values.length;
    }
//  Конструктор с числами через запятую
    public ChangeableArray(Integer...values){
        this.array = new int[values.length];

        for (int i = 0; i < values.length; i++){
            if (values[i] != null){
                array[i] = values[i];
            }
        }
        this.size = values.length;
    }
//    Конструктор со списком
    public ChangeableArray(ArrayList<Integer> arrayList){
        this.array = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i) != null){
                array[i] = arrayList.get(i);
            }
        }

        this.size = arrayList.size();
    }
//    Добавить значение в конец
    public void addValueEnd(int value){
        array = Arrays.copyOf(array, array.length + 1);
        array[size] = value;
        size++;
    }

//    Добавить значение в позицию n
    public void addToPosition(int value, int n){
        if (n < 0 || n >= array.length){
            throw new OutOfArrayScopeException("N must be in scopes of array size!");
        }
        int[] tempArray = new int[size + 1];
        System.arraycopy(array, 0, tempArray, 0, n);
        tempArray[n] = value;
        for (int i = n; i < size; i++){
            tempArray[i + 1] = array[i];
        }

        array = Arrays.copyOf(tempArray, tempArray.length);
        size++;
    }
//    Добавить значения (отдельные числа) в позицию n
    public void addValues(int n, int...values){
        if (n < 0 || n >= array.length){
            throw new OutOfArrayScopeException("N must be in scopes of array size!");
        }
        int[] tempArray = new int[size + values.length];
        System.arraycopy(array, 0, tempArray, 0, n);

        for (int i = n; i < n + values.length; i++){
            tempArray[i] = values[i - n];
        }

        for (int i = n + values.length; i < size; i++){
            tempArray[i] = array[i - values.length];
        }

        for (int i = size; i < size + values.length; i++){
            tempArray[i] = array[i - values.length];
        }

        size += values.length;
        array = Arrays.copyOf(tempArray, tempArray.length);

    }

    //    Добавление списка значений в массив по позиции n
    public void addValues(int n, ArrayList<Integer> values){
        if (n < 0 || n >= array.length){
            throw new OutOfArrayScopeException("N must be in scopes of array size!");
        }
        int[] tempArray = new int[size + values.size()];
        System.arraycopy(array, 0, tempArray, 0, n);

        for (int i = n; i < n + values.size(); i++){
            tempArray[i] = values.get(i - n);
        }

        for (int i = n + values.size(); i < size; i++){
            tempArray[i] = array[i - values.size()];
        }

        for (int i = size; i < size + values.size(); i++){
            tempArray[i] = array[i - values.size()];
        }

        size += values.size();
        array = Arrays.copyOf(tempArray, tempArray.length);

    }
    //    Удалить по индексу
    public void deleteByPosition(int n){
        if (n < 0 || n >= array.length){
            throw new OutOfArrayScopeException("N must be in scopes of array size!");
        }

        for (int i = n; i < size - 1; i++){
            array[i] = array[i + 1];
        }
        array = Arrays.copyOf(array, array.length - 1);
        size--;
    }

    //Получить по индексу
    public int getByPosition(int n){
        if (n < 0 || n >= array.length){
            throw new OutOfArrayScopeException("N must be in scopes of array size!");
        }
        return array[n];
    }
    //    Поменять значение по индексу
    public void changeValue(int value, int n){
        if (n < 0 || n >= array.length){
            throw new OutOfArrayScopeException("N must be in scopes of array size!");
        }
        array[n] = value;
    }

    //    Строковое представление
    public String becomeString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++){
            stringBuilder.append(array[i]);
            stringBuilder.append(", ");
        }
        stringBuilder.append(array[size - 1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    //    Проверка на пустоту
    public boolean checkIsEmpty(){
        return array.length == 0;
    }

    //    Получить размер
    public int getSize(){
        return size;
    }

    //    Получить массив
    public int[] getArray(){
        return Arrays.copyOf(array, size);
    }
}
