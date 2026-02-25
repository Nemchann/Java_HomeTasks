package com.nemchann.io;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectReader<T> {
    private String fileName;
    private Class<T> type;

    public ObjectReader(String fileName, Class<T> type) {
        this.fileName = fileName;
        this.type = type;
    }

    public List<T> read() throws IOException, ReflectiveOperationException {
        List<T> result = new ArrayList<>();
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split(" ");

                String className = parts[0];

                Class<?> objectClass = Class.forName(className);

                String[] fieldValues = new String[parts.length - 1];
                System.arraycopy(parts, 1, fieldValues, 0, parts.length - 1);

                T obj = createObject(objectClass, fieldValues);
                result.add(obj);
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    private T createObject(Class<?> clz, String[] fieldValues) throws ReflectiveOperationException {
        Constructor<?>[] constructors = clz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            Parameter[] params = constructor.getParameters();

            if (params.length == fieldValues.length) {
                constructor.setAccessible(true);

                Object[] args = new Object[fieldValues.length];
                for (int i = 0; i < params.length; i++) {
                    Class<?> paramType = params[i].getType();
                    args[i] = convertStringToType(fieldValues[i], paramType);
                }
                return (T) constructor.newInstance(args);
            }
        }
        throw new ReflectiveOperationException(
                "Не найден конструктор с " + fieldValues.length + " параметрами для класса " +
                        clz.getName());

    }


    private Object convertStringToType(String value, Class<?> targetType) {
        if (targetType == String.class) {
            return value;
        } else if (targetType == int.class || targetType == Integer.class) {
            return Integer.parseInt(value);
        } else if (targetType == long.class || targetType == Long.class) {
            return Long.parseLong(value);
        } else if (targetType == double.class || targetType == Double.class) {
            return Double.parseDouble(value);
        } else if (targetType == boolean.class || targetType == Boolean.class) {
            return Boolean.parseBoolean(value);
        } else if (targetType == float.class || targetType == Float.class) {
            return Float.parseFloat(value);
        } else {

            return value;
        }
    }
}