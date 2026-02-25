package com.nemchann.new_stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void test(){
        int result = Stream.of(1, 8, -4, -2, 0, 5, 2)
                .map(x -> x + 1)
                .filter(x -> x < 0)
                .reduce(0, Integer::sum);

        String stringRes = String.valueOf(Stream.of("aa", "bbb", "cccc", "aaaaaaa", "")
                        .filter(x -> x.length() >= 3 && x.length() <= 5)
                        .reduce("", (x, y) -> x + y));


        String[] strings = new String[]{"aaaa", "13", "-13", "134141", "55", "sfsdfss", "01"};

        int res = Arrays.stream(strings)
                .filter(str ->
                    str.matches("-?\\d{2}") //Это числа
                )
                .mapToInt(Integer::parseInt)
                .filter(x -> Math.abs(x) >= 10 && Math.abs(x) < 100)
                .reduce(0, Integer::sum);

        List<String> strs = Arrays.asList("awdasdad", "OJIOihiohi", "AAAAAAaaaaa");
        int resu = (int)strs.stream()
                .flatMapToInt(String::chars)
                .filter(x -> x == 'a' || x == 'A')
                .count();
        System.out.println(resu);

//        Дз

//        List<Character> chars = strs1.stream()
//                .flatMapToInt(String::chars)
//                .collect(() -> new ArrayList<>(),
//                        (list, i) -> list.add((char) i),
//                        (x, y) -> x.addAll(y));
//
//        System.out.println(chars);

        List<String> strs1 = Arrays.asList("awdasdad", "hiOJIOihio", "rtrtrt");

        //Задача где нужно посчитать каждую букву
        Map<Character, Long> letterCount = strs1.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(
                        c -> Character.toLowerCase(c),
                        Collectors.counting()
                ));

        letterCount.forEach((letter, count) ->
                System.out.println(letter + ": " + count));
    }
    //Задача где нужно найти строку с минимальным кол-вом строчных букв
    public static void test2(){
        List<String> strings = Arrays.asList(
                "wfweWEFWEFWFgdfvd",
                "ff",
                "EGARGEGergegegreg",
                "EGEGEuu",
                "nyanyanya",
                "aBcAAAaa"
        );

        // Находим минимальное количество строчных букв
        long minCount = strings.stream()
                .mapToLong(s -> s.chars().filter(Character::isLowerCase).count())
                .min()
                .orElse(0);

        System.out.println("Минимальное количество строчных букв: " + minCount);

        // Находим все строки с этим количеством строчных букв
        List<String> minStrings = strings.stream()
                .filter(s -> s.chars().filter(Character::isLowerCase).count() == minCount)
                .collect(Collectors.toList());

        minStrings.forEach(s -> System.out.println("  \"" + s + "\""));
    }
}
