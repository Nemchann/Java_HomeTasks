package com.nemchann.mathematic;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
public class NewPow {
    public static double powXtoY(String xStr, String yStr){
            // Используем короткие имена благодаря статическому импорту
        int x = parseInt(xStr);  // вместо Integer.parseInt
        int y = parseInt(yStr);  // вместо Integer.parseInt
        return pow(x, y);        // вместо Math.pow

    }
}
