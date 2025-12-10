package com.nemchann.geometry;

public class LineFactory {

    // Создание обычной линии
    public static <T extends Dot> Line<T> createLine(T start, T end) {
        return new Line<>(start, end);
    }

    // Создание линии с кэшированием
    public static <T extends Dot> CachedLine<T> createCachedLine(T start, T end) {
        Line<T> line = new Line<>(start, end);
        return new CachedLine<>(line);
    }

    // Обертка существующей линии в кэширующую
    public static <T extends Dot> CachedLine<T> wrapWithCache(Line<T> line) {
        return new CachedLine<>(line);
    }
}