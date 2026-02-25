package com.nemchann.geometry;

import java.lang.reflect.Field;
import java.util.Arrays;

public class LinesConnector {
    public static <T extends Dot> void lineConnector(Line<Dot> line1, Line<Dot> line2) throws NoSuchFieldException, IllegalAccessException {
        Class<?> clz = line1.getClass();
        Field lineEnd = clz.getDeclaredField("end");
        Field lineStart = clz.getDeclaredField("start");
        lineEnd.setAccessible(true);
        lineStart.setAccessible(true);

        T endObject = (T) lineEnd.get(line1);

        lineStart.set(line2, endObject);

        System.out.println(line2.getStart());

    }
}
