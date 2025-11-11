package com.nemchann.mathematic;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
public class NewPow {
    public static double powXtoY(String xStr, String yStr){
            // Используем короткие имена благодаря статическому импорту
        if (!isInt(xStr) && !isInt((yStr))){
            throw new IllegalArgumentException("input must be number");
        }

        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);

    }

    public static boolean isInt(String str){
        if (str.toCharArray()[0] != '-' || !Character.isDigit(str.toCharArray()[0])){
            return false;
        }
        for (int i = 1; i < str.length(); i++){
            if(!Character.isDigit(str.toCharArray()[i])) return false;
        }
        return true;
    }
}
