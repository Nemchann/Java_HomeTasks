package com.nemchann.to_collect;
import java.util.Collection;

// Для создания результирующей коллекции
@FunctionalInterface
public interface Supplier<P> {
    P get();
}