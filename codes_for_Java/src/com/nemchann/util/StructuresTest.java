package com.nemchann.util;
import com.nemchann.structures.*;

import java.util.ArrayList;
import java.util.Arrays;

public class StructuresTest {

    public static void a_1_1(){
        ArrayList<Integer> arrayList= new ArrayList<>();
        for (int i = 1; i < 20; i++){
            arrayList.add(i);
        }
        UnchangeableArray array = new UnchangeableArray(arrayList);
        System.out.println("Представление строкой: " + array.becomeString());
        System.out.println("Получение значения n: " + array.getPosition(5));
        array.changeOneValue(0, 5);
        System.out.println("Поменяли одно значение");
        System.out.println("Представление в виде массива: " + Arrays.toString(array.getArray()));
        System.out.println("Пустой ли массив: " + array.checkIsEmpty());
        System.out.println("Узнать размер: " + array.getSize());
        System.out.println("Представление в виде массива: " + Arrays.toString(array.getArray()));

    }

    public static void a_1_2(){
        FixedSizeArray fixedSizeArray = new FixedSizeArray(30);
        for (int i = 1; i < 20; i++){
            fixedSizeArray.addValue(i);
        }
        System.out.println("Представление строкой: " + fixedSizeArray.becomeString());
        System.out.println("Получение значения по индексу n = 5: " + fixedSizeArray.getByPosition(5));
        fixedSizeArray.changeValue(8, 0);
        System.out.println("Изменение 0-го элемента на 8: " + Arrays.toString(fixedSizeArray.getArray()));
        fixedSizeArray.addValue(100, 7);
        System.out.println("После добавления 100: " + Arrays.toString(fixedSizeArray.getArray()));
        fixedSizeArray.deleteByPosition(13);
        System.out.println("После удаления элемента с индексом 12: " + Arrays.toString(fixedSizeArray.getArray()));
        fixedSizeArray.addValues(3, 22, 33, 44);
        System.out.println("После добавления значений (22, 33, 44), начиная с индекса 3: " + Arrays.toString(fixedSizeArray.getArray()));
        System.out.println("Размер хранимых значений: " + fixedSizeArray.getSize());
        System.out.println("Возможность дальнейшей вставки: " + fixedSizeArray.isAvailableToAdd());
    }

    public static void a_1_3(){
        ChangeableArray array = new ChangeableArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println("Представление строкой: " + array.becomeString());
        array.addValueEnd(100);
        System.out.println("После вставки 100 в конец: " + Arrays.toString(array.getArray()));
        System.out.println("Элемент с индексом 4: " + array.getByPosition(4));
        array.addValues(4, 31, 32, 33, 34);
        System.out.println("После вставки 31,32,33,34 в позицию 4: " + Arrays.toString(array.getArray()));
        System.out.println("Размер массива: " + array.getSize());
        array.addToPosition(-10, 10);
        System.out.println("После вставки -10 на позицию 10: " + Arrays.toString(array.getArray()));
        array.deleteByPosition(13);
        System.out.println("После удаления 13 элемента: " + Arrays.toString(array.getArray()));
    }
}
