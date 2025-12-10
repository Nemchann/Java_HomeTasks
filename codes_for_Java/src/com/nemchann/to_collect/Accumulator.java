package com.nemchann.to_collect;

import java.util.Collection;
// Для добавления элементов в коллекцию
@FunctionalInterface
public interface Accumulator<P, T> {
    void accept(P collection, T item);
}