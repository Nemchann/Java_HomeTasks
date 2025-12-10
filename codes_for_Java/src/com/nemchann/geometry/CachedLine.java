package com.nemchann.geometry;

import java.util.Objects;

public class CachedLine<T extends Dot> implements Sizeable {
    private final Line<T> line;
    private Double cachedSize = null;
    private int lineHashCode = 0;

    public CachedLine(Line<T> line) {
        this.line = line;
        updateHashCode();
    }

    // Метод для получения исходной линии
    public Line<T> getLine() {
        return line;
    }

    // Метод для получения размера с кэшированием
    @Override
    public double getSize() {
        // Проверяем, изменилась ли линия
        int currentHashCode = calculateLineHashCode();

        if (cachedSize == null || currentHashCode != lineHashCode) {
            // Вычисляем и кэшируем
            cachedSize = line.getSize();
            lineHashCode = currentHashCode;
            System.out.println("Вычисление длины (кэш обновлен)");
        } else {
            System.out.println("Использование кэшированного значения");
        }

        return cachedSize;
    }

    // Метод для расчета хэш-кода текущего состояния линии
    private int calculateLineHashCode() {
        return Objects.hash(
                line.getStart().x, line.getStart().y,
                line.getEnd().x, line.getEnd().y
        );
    }

    // Метод для обновления сохраненного хэш-кода
    private void updateHashCode() {
        lineHashCode = calculateLineHashCode();
    }

    // Метод для принудительного сброса кэша
    public void clearCache() {
        cachedSize = null;
        updateHashCode();
    }

    // Делегирование некоторых методов исходной линии
    public Dot getStart() {
        return line.getStart();
    }

    public Dot getEnd() {
        return line.getEnd();
    }

    @Override
    public String toString() {
        return "CachedLine[" + line.toString() + "]";
    }
}