package com.nemchann.data_bases;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Db {
    private Map<Integer, String> data = new HashMap<>();
    private Map<Class<?>, Function<String, ?>> converters = new HashMap<>();

    // Хранилище данных
    public Db() {
        // Инициализация тестовыми данными
        data.put(0, "Hello");
        data.put(1, "100,200"); // Представление точки
        data.put(2, "42"); // Число
    }

    // Основной метод
    public <T> T get(int index, Class<T> type) {
        String rawData = data.get(index);
        if (rawData == null) {
            throw new IllegalArgumentException("No data at index: " + index);
        }

        // Получаем конвертер для типа
        Function<String, T> converter = (Function<String, T>) converters.get(type);
        if (converter == null) {
            throw new IllegalArgumentException("No converter for type: " + type);
        }

        return converter.apply(rawData);
    }

    // Регистрация конвертеров
    public <T> void registerConverter(Class<T> type, Function<String, T> converter) {
        converters.put(type, converter);
    }

    // Метод для добавления данных
    public void put(int index, String value) {
        data.put(index, value);
    }
}