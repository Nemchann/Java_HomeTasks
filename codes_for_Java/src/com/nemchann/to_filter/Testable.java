package com.nemchann.to_filter;

@FunctionalInterface
public interface Testable<T> {
    boolean test(T input);
}
