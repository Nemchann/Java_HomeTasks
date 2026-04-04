package com.nemchann.training.caching;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CacheService {
    private final Map<String, Map<String, Object>> caches = new ConcurrentHashMap<>();

    private CacheService(){

    }

    private static class Holder{
        private static final CacheService INSTANCE = new CacheService();
    }

    public Object get(String cacheName, String key){
        Map<String, Object> cache = caches.get(cacheName);

        if(cache == null) return null;

        return cache.get(key);
    }

    public void put(String cacheName, String key, Object value){
        Map<String, Object> cache = caches.computeIfAbsent(cacheName, k -> new ConcurrentHashMap<>());

        cache.put(key, value);

        System.out.println("Сохранено: " + cacheName + "[" + key + "] = " + value);
    }

    public void clear(String cacheName){
        caches.remove(cacheName);
    }

    public void clearAll(){
        caches.clear();
    }

    public void printStats(){
        System.out.println("\n=== Статистика кэша ===");
        caches.forEach((name, cache) -> {
            System.out.println("Кэш '" + name + "': " + cache.size() + " записей");
            cache.forEach((key, value) -> System.out.println("  " + key + " -> " + value));
        });
    }

    public static CacheService instance(){
        return Holder.INSTANCE;
    }
}
