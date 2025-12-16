package com.nemchann.data_bases;

public interface TypeConverter<T> {
    /**
     * Преобразует строку в указанный тип
     * @param value строка для преобразования
     * @return преобразованный объект
     * @throws IllegalArgumentException если преобразование невозможно
     */
    T convert(String value);

    /**
     * Возвращает класс, в который преобразуется строка
     */
    Class<T> getTargetClass();
}
