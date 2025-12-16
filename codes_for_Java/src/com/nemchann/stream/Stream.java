package com.nemchann.stream;

import com.nemchann.to_apply.*;
import com.nemchann.to_filter.*;
import com.nemchann.to_concise.*;
import com.nemchann.to_collect.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class Stream<T> {
    private final Supplier<Iterator<T>> iteratorSupplier;

    // Приватный конструктор
    private Stream(Supplier<Iterator<T>> iteratorSupplier) {
        this.iteratorSupplier = iteratorSupplier;
    }

    // Создание потока из коллекции
    public static <T> Stream<T> of(Collection<T> collection) {
        return new Stream<>(collection::iterator);
    }

    // Transform операция
    public <R> Stream<R> transform(Appliable<T, R> appliable) {
        return new Stream<>(() -> new Iterator<R>() {
            private final Iterator<T> sourceIterator = iteratorSupplier.get();

            @Override
            public boolean hasNext() {
                return sourceIterator.hasNext();
            }

            @Override
            public R next() {
                return appliable.apply(sourceIterator.next());
            }
        });
    }

    // Filter операция
    public Stream<T> filter(Testable<T> testable) {
        return new Stream<>(() -> new Iterator<T>() {
            private final Iterator<T> sourceIterator = iteratorSupplier.get();
            private T nextElement = null;

            @Override
            public boolean hasNext() {
                while (nextElement == null && sourceIterator.hasNext()) {
                    T candidate = sourceIterator.next();
                    if (testable.test(candidate)) {
                        nextElement = candidate;
                        break;
                    }
                }
                return nextElement != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T result = nextElement;
                nextElement = null;
                return result;
            }
        });
    }

    // Терминальная операция reduce
    public T reduce(T identity, Reducer<T> reducer) {
        Iterator<T> iterator = iteratorSupplier.get();
        T result = identity;
        while (iterator.hasNext()) {
            result = reducer.reduce(result, iterator.next());
        }
        return result;
    }

    // Терминальная операция collect
    public <K, P extends Collection<T>> Collection<P> collect(
            MySupplier<P> collectionSupplier,
            Accumulator<P, T> accumulator,
            Function<T, K> classifier) {

        List<T> list = new ArrayList<>();
        Iterator<T> iterator = iteratorSupplier.get();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }

        return Collector.collect(list, collectionSupplier, accumulator, classifier);
    }

    // Вспомогательный метод для сбора в список
    public List<T> toList() {
        List<T> result = new ArrayList<>();
        Iterator<T> iterator = iteratorSupplier.get();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

//    public int count() {
//        return this.transform(item -> 1)
//                .reduce(0, (acc, num) -> acc + num);
//    }
}