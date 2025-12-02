package com.nemchann.structures;

import java.util.ArrayList;
import java.util.Arrays;

import static com.sun.tools.javac.util.ArrayUtils.ensureCapacity;

public class ChangeableArray extends FixedSizeArray{
//    int[] array;
    private int size;
    private int capacity;      // фактическая емкость массива
    private int lastNonO1Addition = 0; // счетчик для контроля O(1) добавлений

//    Конструктор без параметров
    public ChangeableArray(){
        this.size = 0;
        this.capacity = 8; // Начальная емкость для первых 8 O(1) добавлений
        this.array = new int[capacity];
    }
//    Конструктор с массивом
    public ChangeableArray(int[] values){
        this.array = Arrays.copyOf(values, values.length);
        this.size = values.length;
        this.capacity = Math.max(values.length, 8);
        this.lastNonO1Addition = 0;
    }
//  Конструктор с числами через запятую
    public ChangeableArray(Integer...values){
        this.capacity = Math.max(values.length, 8);
        this.array = new int[capacity];
        this.size = 0;

        for (Integer value : values) {
            if (value != null) {
                if (size >= capacity) {
                    ensureCapacity(capacity * 2);
                }
                array[size++] = value;
            }
        }
    }

    private void ensureCapacity(int newCapacity) {
        // Проверяем условие "не чаще чем в каждом N+N/2 случае"
        if (lastNonO1Addition > 0 && size < lastNonO1Addition + lastNonO1Addition / 2) {
            // Пытаемся удвоить емкость, но проверяем ограничение
            if (newCapacity > capacity + capacity / 2) {
                newCapacity = capacity + capacity / 2;
            }
        }

        capacity = newCapacity;
        array = Arrays.copyOf(array, capacity);
        lastNonO1Addition = size; // Запоминаем, когда было последнее не-O(1) добавление
    }

    //    Конструктор со списком
    public ChangeableArray(ArrayList<Integer> arrayList){
        this.capacity = Math.max(arrayList.size(), 8);
        this.array = new int[capacity];
        this.size = 0;

        for (Integer value : arrayList) {
            if (value != null) {
                if (size >= capacity) {
                    ensureCapacity(capacity * 2);
                }
                array[size++] = value;
            }
        }

    }
//    Добавить значение в конец
    @Override
    public void addValue(int value) {
        // Если массив заполнен, увеличиваем емкость
        if (size >= capacity) {
            ensureCapacity(capacity * 2);
        }

        // Добавляем элемент (O(1))
        array[size] = value;
        size++;
    }

//    Добавить значение в позицию n
    @Override
    public void addValue(int value, int n){
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public int getPosition(int n){
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
    @Override
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

    //    Получить размер
    @Override
    public int getSize(){
        return size;
    }
    // Получить фактическую емкость (для тестирования)
    public int getCapacity() {
        return capacity;
    }

    //    Получить массив
    @Override
    public int[] getArray(){
        return Arrays.copyOf(array, size);
    }
}
