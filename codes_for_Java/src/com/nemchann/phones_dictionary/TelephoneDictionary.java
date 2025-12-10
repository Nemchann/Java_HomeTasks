package com.nemchann.phones_dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.hash;

public class TelephoneDictionary {
    Map<String,String> dictionary = new HashMap<>();
    //Node<String,String>[] dictionary;


    public TelephoneDictionary(String key, String value){
        this.dictionary.put(key, value);
    }

//    public String addContact(String key, String value){
//
//        Node<String, String> node = new Node<>(hash(key), key, value, null);
//    }



//    static class Node<K,V> {
//        final int hash;     // Хэш ключа
//        final K key;        // Ключ
//        V value;           // Значение
//        Node<K,V> next;    // Ссылка на следующий узел (для коллизий)
//
//        Node(int hash, K key, V value, TelephoneDictionary.Node<K,V> next) {
//            this.hash = hash;
//            this.key = key;
//            this.value = value;
//            this.next = next;
//        }
//
//        public K getKey(){
//            return key;
//        }
//
//        public V getValue(){
//            return value;
//        }
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//
//        public final V setValue(V newValue) {
//            V oldValue = value;
//            value = newValue;
//            return oldValue;
//        }
//
//        public final boolean equals(Object o) {
//            if (o == this)
//                return true;
//
//            return o instanceof Map.Entry<?, ?> e
//                    && Objects.equals(key, e.getKey())
//                    && Objects.equals(value, e.getValue());
//        }
//    }
}
