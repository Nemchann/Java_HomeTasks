package com.nemchann.storages;

import java.util.function.Supplier;

public class Storage<T> {
    private final T obj;
    private final Supplier<T> alternativeSupplier;

    public Storage(T obj, T alternative){
        this.obj = obj;
        this.alternativeSupplier = () -> alternative;
    }

    public T getObj() {
        return obj != null ? obj : alternativeSupplier.get();
    }
}
