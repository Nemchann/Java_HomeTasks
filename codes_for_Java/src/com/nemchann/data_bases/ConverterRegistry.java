package com.nemchann.data_bases;


import java.util.HashMap;
import java.util.Map;
public class ConverterRegistry {

    private final Map<Class<?>, TypeConverter<?>> converters = new HashMap<>();

    public ConverterRegistry() {
        // Регистрируем стандартные преобразователи
        register(new StringConverter());
        register(new IntegerConverter());
        register(new DoubleConverter());
        register(new PointConverter());
    }

    public <T> void register(TypeConverter<T> converter) {
        converters.put(converter.getTargetClass(), converter);
    }

    @SuppressWarnings("unchecked")
    public <T> TypeConverter<T> getConverter(Class<T> targetClass) {
        TypeConverter<?> converter = converters.get(targetClass);
        if (converter == null) {
            throw new IllegalArgumentException("No converter registered for class: " + targetClass);
        }
        return (TypeConverter<T>) converter;
    }

    public <T> boolean hasConverter(Class<T> targetClass) {
        return converters.containsKey(targetClass);
    }
}
