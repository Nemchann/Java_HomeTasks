package com.nemchann.structures;

import java.util.ArrayList;
import java.util.Arrays;

public class FixedSizeArray {
    int[] array;
    private int size ;
    final int maxSize;
    private final static int DEFAULT_SIZE = 100;

//    Конструктор без значений
    public FixedSizeArray(){
        this.maxSize = DEFAULT_SIZE;
        this.array = new int[maxSize];
        this.size = 0;
    }

//    С указанием максимальной границы массива
    public FixedSizeArray(int maxSize){
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.size = 0;
    }
//    С указанием списка
    public FixedSizeArray(ArrayList<Integer> arrayList){
        this.array = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i) != null){
                array[i] = arrayList.get(i);
            }
        }
        this.maxSize = arrayList.size();
        this.size = arrayList.size();
    }

//    Добавить значений в конец
    public void addValue(int value){
        if (this.size == this.maxSize){
            throw new OutOfArrayScopeException("Count of values equals max size. You can't add sth to array");
        }
        size++;
        array[size - 1] = value;
    }
//      Добавить значение в позицию n
    public void addValue(int value, int n){
        if (this.size == this.maxSize){
            throw new OutOfArrayScopeException("Count of values equals max size. You can't add sth to array");
        }
        if (n == size - 1){
            addValue(value);
        }
        else{
            int[] tempArray = new int[size + 1];
            System.arraycopy(array, 0, tempArray, 0, n);
            tempArray[n] = value;
            for (int i = n; i < size; i++){
                tempArray[i + 1] = array[i];
            }
            //System.arraycopy(array, n, tempArray, n + 1, array.length - n); - выводит ошибку если что, поэтому написала цикл
            size++;
            array = Arrays.copyOf(tempArray, tempArray.length);
        }
    }

//    Добавить несколько значений с позиции n
    public void addValues(int n, int...values){
        if (this.size == this.maxSize){
            throw new OutOfArrayScopeException("Count of values equals max size. You can't add sth to array");
        }
        if (this.size + values.length > this.maxSize){
            throw new OutOfArrayScopeException("Too many values to add to array");
        }
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
        if (this.size == this.maxSize){
            throw new OutOfArrayScopeException("Count of values equals max size. You can't add sth to array");
        }
        if (this.size + values.size() > this.maxSize){
            throw new OutOfArrayScopeException("Too many values to add to array");
        }
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
        size--;
    }
//Получить по индексу
    public int getByPosition(int n){
        return array[n];
    }
//    Поменять значение по индексу
    public void changeValue(int value, int n){
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
//    Проверка на возможность вставки
    public boolean isAvailableToAdd(){
        return size != maxSize;
    }

//    Получить размер
    public int getSize(){
        return size;
    }

//    Получить массив
    public int[] getArray(){
        return Arrays.copyOf(array, size);
    }

    @Override
    public String toString() {
        return "FixedSizeArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", maxSize=" + maxSize +
                '}';
    }
}
