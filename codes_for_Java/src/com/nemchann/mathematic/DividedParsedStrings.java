package com.nemchann.mathematic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DividedParsedStrings {

    public static double dividedStrings(String... strings) {
        List<Integer> numbers = parseNumbersFromStrings(strings);

        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Не найдено ни одного числа в строках");
        }

        double result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int divisor = numbers.get(i);
            if (divisor == 0) {
                throw new ArithmeticException("Деление на ноль! Делитель: " + divisor);
            }
            result /= divisor;
        }
        return result;
    }

    private static List<Integer> parseNumbersFromStrings(String... strings) {
        List<Integer> numbers = new ArrayList<>();

        for (String string : strings) {
            try {
                // Пробуем распарсить всю строку как число
                int number = Integer.parseInt(string);
                numbers.add(number);
            } catch (NumberFormatException e) {
                // Если вся строка не число, ищем числа внутри строки
                extractNumbersFromString(string, numbers);
            }
        }

        return numbers;
    }

    private static void extractNumbersFromString(String string, List<Integer> numbers) {
        StringBuilder currentNumber = new StringBuilder();

        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else {
                // Когда встречаем не-цифру, сохраняем накопленное число
                if (currentNumber.length() > 0) {
                    numbers.add(Integer.parseInt(currentNumber.toString()));
                    currentNumber.setLength(0); // очищаем StringBuilder
                }
            }
        }

        // Добавляем последнее число, если оно есть
        if (currentNumber.length() > 0) {
            numbers.add(Integer.parseInt(currentNumber.toString()));
        }
    }
//    static ArrayList<Integer> numbers = new ArrayList<>();
//    public static double dividedStrings(String...strings){
//        numbersToArray(strings);
//        int firstNum = numbers.getFirst();
//        double result = (double) firstNum;
//        for (int i = 1; i < numbers.size(); i++){
//            result /= numbers.get(i);
//        }
//        return result;
//    }
//    public int findFirstNumber(String...strings){
//        StringBuilder firstNumStr = new StringBuilder();
//        for (String string : strings){
//            char[] charString = string.toCharArray();
//            int i = 0;
//            while(i < charString.length){
//                if(Character.isDigit(charString[i])){
//                    i++;
//                    firstNumStr.append(charString[i]);
//                }
//                else{
//                    break;
//                }
//            }
//            if (!firstNumStr.isEmpty()){
//                break;
//            }
//        }
//        return parseInt(firstNumStr.toString());
//    }

//    private static void numbersToArray(String...strings){
//        int[] array = new int[]{};
//        for (String string : strings){
//            char[] charString = string.toCharArray();
//            int i = 0;
//            int numberChar = 0;
//            while(i < charString.length){
//                if(Character.isDigit(charString[i])){
//                    i++;
//                    numberChar += charString[i];
//                }
//                else{
//                    break;
//                }
//            }
//            if(numberChar != 0){
//                numbers.add(numberChar);
//            }
//        }
    }


