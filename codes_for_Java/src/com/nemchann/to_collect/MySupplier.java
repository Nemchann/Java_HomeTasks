package com.nemchann.to_collect;

// Для создания результирующей коллекции
@FunctionalInterface
public interface MySupplier<P> {
    P get();
}