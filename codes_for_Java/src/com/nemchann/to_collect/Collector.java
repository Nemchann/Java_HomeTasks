package com.nemchann.to_collect;

import java.util.*;
import java.util.function.Function;
public class Collector {

    public static <T, K, P extends Collection<T>>
    Collection<P> collect(
            Collection<T> source,
            Supplier<P> collectionSupplier,
            Accumulator<P, T> accumulator,
            Function<T, K> classifier) {

        // Создаем Map для группировки
        Map<K, P> groups = new HashMap<>();

        for (T item : source) {
            // Получаем ключ для группировки
            K key = classifier.apply(item);

            // Получаем или создаем коллекцию для этого ключа
            P group = groups.get(key);
            if (group == null) {
                group = collectionSupplier.get();
                groups.put(key, group);
            }

            // Добавляем элемент в соответствующую группу
            accumulator.accept(group, item);
        }

        // Возвращаем только значения (коллекции), без ключей
        return groups.values();
    }
}
