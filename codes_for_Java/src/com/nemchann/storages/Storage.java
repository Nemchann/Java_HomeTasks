package com.nemchann.storages;

import java.util.function.Supplier;

public class Storage<T> {
    private final T obj;
    private final Supplier<T> alternativeSupplier;
    private final boolean allowNull;

    private Storage(T obj, Supplier<T> alternativeSupplier, boolean allowNull) {
        this.obj = obj;
        this.alternativeSupplier = alternativeSupplier;
        this.allowNull = allowNull;

        // Проверяем, не пытаемся ли создать null-хранилище
        if (obj == null && !allowNull) {
            throw new IllegalArgumentException("Null values are not allowed for this storage type");
        }
    }
    // Factory Method 1: Разрешает null
    public static <T> Storage<T> createNullable(T value, Supplier<T> alternativeSupplier) {
        return new Storage<>(value, alternativeSupplier, true);
    }
    public static <T> Storage<T> createNullable(T value, T alternative) {
        return createNullable(value, () -> alternative);
    }

    // Factory Method 2: Запрещает null (бросает исключение)
    public static <T> Storage<T> createNonNull(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        return new Storage<>(value, () -> {
            throw new IllegalStateException("Cannot get value from empty storage");
        }, false);
    }

    // Singleton для null-хранилища (внутренний класс)
    private static class NullStorageHolder {
        private static final Storage<?> NULL_STORAGE =
                new Storage<>(null, () -> null, true);
    }

    // Метод для получения единственного null-хранилища
    @SuppressWarnings("unchecked")
    public static <T> Storage<T> getNullStorage() {
        return (Storage<T>) NullStorageHolder.NULL_STORAGE;
    }

    // Метод для проверки, является ли это null-хранилищем
    public boolean isNullStorage() {
        return this == NullStorageHolder.NULL_STORAGE;
    }

    public boolean hasValue() {
        return obj != null;
    }

    public T getObj() {
        if (obj != null) {
            return obj; // Основное значение есть - возвращаем его
        }

        // Только если obj == null, вычисляем альтернативу
        return alternativeSupplier.get(); // Вычисление происходит ЗДЕСЬ
    }

    @Override
    public String toString() {
        if (isNullStorage()) {
            return "NullStorage[]";
        }
        if (obj != null) {
            return "Storage[" + obj + "]";
        } else {
            // Внимание: toString вызывает getObj(), который вычисляет альтернативу!
            return "Storage[null -> " + getObj() + "]";
        }
    }
}
