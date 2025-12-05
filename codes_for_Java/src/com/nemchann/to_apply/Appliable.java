package com.nemchann.to_apply;

@FunctionalInterface
public interface Appliable<T, P> {
    P apply(T input);
}