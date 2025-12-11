package com.nemchann.util;
import com.nemchann.binary_tree.BinaryTree;
import com.nemchann.binary_tree.Node;
import com.nemchann.cities.City;
import com.nemchann.cities.Route;
import com.nemchann.phones_dictionary.PhoneDirectory;
import com.nemchann.secrets.Secret;
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
        System.out.println("Получение значения по индексу n = 5: " + fixedSizeArray.getPosition(5));
        fixedSizeArray.changeOneValue(8, 0);
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
        array.addValue(100);
        System.out.println("После вставки 100 в конец: " + Arrays.toString(array.getArray()));
        System.out.println("Элемент с индексом 4: " + array.getPosition(4));
        array.addValues(4, 31, 32, 33, 34);
        System.out.println("После вставки 31,32,33,34 в позицию 4: " + Arrays.toString(array.getArray()));
        System.out.println("Размер массива: " + array.getSize());
        array.addValue(-10, 10);
        System.out.println("После вставки -10 на позицию 10: " + Arrays.toString(array.getArray()));
        array.deleteByPosition(13);
        System.out.println("После удаления 13 элемента: " + Arrays.toString(array.getArray()));
    }

    public static void a_1_5(){
        String[] strs = new String[]{"aaa", "bbb", "ccc"};
        UniqueStrings us = new UniqueStrings(strs);
        System.out.println(us);
        System.out.println(us.addString("ddd"));
        System.out.println(us);
        System.out.println(us.deleteString("bbb"));
        System.out.println(us);
        System.out.println(us.getSize());
        System.out.println(us.addStrings("ddd", "fff", "aaa", "ttt"));
        System.out.println(us);
        System.out.println(us.deleteStrings("ddd", "aaa", "hhh"));
        System.out.println(us);
    }

    public static void a_1_6(){
        Secret secret = new Secret("Вася", "Тот чел никогда не катался на велике!");
        Secret secret1 = new Secret(secret, "Петя");
        Secret secret2 = new Secret(secret1, "Саша");
        Secret secret3 = new Secret(secret2, "Антон");
        Secret secret4 = new Secret(secret3, "Катя");
        System.out.println(secret1.getNHolderName(3));
        System.out.println(secret2.getCountAfterMe());
        System.out.println(secret3.getCountAfterMe());
        System.out.println(secret4.getOrderNumber());
        System.out.println(secret.getHolderChain());
    }

    public static void a_1_7(){
        PhoneDirectory directory = new PhoneDirectory();
        System.out.println("=== Добавление контактов ===");
        directory.add("89003337788", "Вася");
        directory.add("89004448899", "Петя");
        directory.add("89005559900", "Маша");
        directory.add("89006660011", "Анна");
        directory.add("89007771122", "Антон");

        System.out.println(directory);

        // Получение телефона по имени
        System.out.println("=== Поиск телефона ===");
        System.out.println("Телефон Васи: " + directory.getPhoneByName("Вася"));
        System.out.println("Телефон Маши: " + directory.getPhoneByName("Маша"));

        // Обновление телефона
        System.out.println("\n=== Обновление телефона ===");
        String oldPhone = directory.add("89001112233", "Вася");
        System.out.println("Старый телефон Васи: " + oldPhone);
        System.out.println("Новый телефон Васи: " + directory.getPhoneByName("Вася"));

        // Проверка существования
        System.out.println("\n=== Проверка существования ===");
        System.out.println("Есть ли Вася? " + directory.containsName("Вася"));
        System.out.println("Есть ли телефон 89004448899? " + directory.containsPhone("89004448899"));
        System.out.println("Есть ли Коля? " + directory.containsName("Коля"));

        // Поиск по префиксу
        System.out.println("\n=== Поиск по префиксу 'Ан' ===");
        String[] namesWithPrefix = directory.getNamesByPrefix("Ан");
        System.out.println("Найдено имен: " + namesWithPrefix.length);
        for (String name : namesWithPrefix) {
            System.out.println("- " + name + ": " + directory.getPhoneByName(name));
        }
    }

    public static void a_1_10(){
        BinaryTree bTree = new BinaryTree();
        bTree.addValue(3);
        bTree.addValue(5);
        bTree.addValue(4);
        bTree.addValue(7);
        bTree.addValue(1);
        bTree.addValue(2);
        System.out.println(bTree);
    }

    public static void a_1_11(){
        BinaryTree bTree = new BinaryTree();
        bTree.addValue(1);
        bTree.addValue(5);
        bTree.addValue(4);
        bTree.addValue(7);
        bTree.addValue(2);
        bTree.addValue(10);
        bTree.addValue(9);
        bTree.addValue(8);
        bTree.addValue(6);
        System.out.println(bTree.inOrder());
        bTree.remove(7);
        System.out.println(bTree.isValidBST());
        System.out.println(bTree.inOrder());
        System.out.println(bTree.contains(5));

    }

    public static void a_1_12(){
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        A.addPath(B, 5);
        B.addPath(A, 5);
        A.addPath(F, 1);
        A.addPath(D, 6);
        B.addPath(C, 3);
        C.addPath(B, 3);
        C.addPath(D, 4);
        D.addPath(E, 2);
        D.addPath(A, 6);
        E.addPath(F, 2);
        F.addPath(E, 2);
        F.addPath(B, 1);

        Route route = new Route(F, D);
        System.out.println(route.getCityCount());


    }
}
