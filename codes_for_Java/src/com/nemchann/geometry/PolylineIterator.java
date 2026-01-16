package com.nemchann.geometry;

public interface PolylineIterator {
    /**
     * Проверяет, есть ли следующая точка для итерации
     */
    boolean hasNext();

    /**
     * Возвращает следующую точку и перемещает курсор
     */
    Dot next();

    /**
     * Возвращает текущую точку без перемещения курсора
     */
    Dot current();

    /**
     * Сбрасывает итератор на начало (на первую точку)
     */
    void reset();

    /**
     * Устанавливает текущую позицию на указанный индекс
     */
    void setPosition(int index);

}
