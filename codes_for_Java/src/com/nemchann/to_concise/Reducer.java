package com.nemchann.to_concise;

@FunctionalInterface
public interface Reducer<T> {
    T reduce(T accumulator, T current);
}
