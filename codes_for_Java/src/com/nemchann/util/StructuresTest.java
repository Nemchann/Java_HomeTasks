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
}
