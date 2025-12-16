package com.nemchann.phones_dictionary;

import java.util.ArrayList;
import java.util.List;

public class PhoneDirectoryCustom {
    // Внутренний класс для хранения пары ключ-значение
    private static class Entry {
        String name;
        String phone;
        Entry next; // для разрешения коллизий

        Entry(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry[] table;
    private int size;

    public PhoneDirectoryCustom() {
        table = new Entry[INITIAL_CAPACITY];
        size = 0;
    }

    // Хэш-функция
    private int hash(String key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % table.length;
    }

    public String add(String phone, String name) {
        if (phone == null || name == null) {
            throw new IllegalArgumentException("Телефон и имя не могут быть null");
        }

        // Проверяем, не нужно ли увеличить таблицу
        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }

        // Удаляем старую запись с таким именем, если она есть
        String oldPhone = removeByName(name);

        // Создаем новую запись
        int index = hash(name);
        Entry newEntry = new Entry(name, phone);

        // Добавляем в начало цепочки (простой способ)
        newEntry.next = table[index];
        table[index] = newEntry;
        size++;

        return oldPhone;
    }

    private void resize() {
        Entry[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry entry : oldTable) {
            while (entry != null) {
                add(entry.phone, entry.name);
                entry = entry.next;
            }
        }
    }

    public String removeByName(String name) {
        if (name == null) return null;

        int index = hash(name);
        Entry prev = null;
        Entry current = table[index];

        while (current != null) {
            if (name.equals(current.name)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.phone;
            }
            prev = current;
            current = current.next;
        }

        return null;
    }

    public String getPhoneByName(String name) {
        if (name == null) return null;

        int index = hash(name);
        Entry current = table[index];

        while (current != null) {
            if (name.equals(current.name)) {
                return current.phone;
            }
            current = current.next;
        }

        return null;
    }

    public boolean containsName(String name) {
        return getPhoneByName(name) != null;
    }

    public int size() {
        return size;
    }

    public String[] getAllPairs() {
        String[] pairs = new String[size];
        int index = 0;

        for (Entry entry : table) {
            while (entry != null) {
                pairs[index++] = entry.phone + " - " + entry.name;
                entry = entry.next;
            }
        }

        return pairs;
    }

    public String[] getAllNames() {
        String[] names = new String[size];
        int index = 0;

        for (Entry entry : table) {
            while (entry != null) {
                names[index++] = entry.name;
                entry = entry.next;
            }
        }

        return names;
    }

    public String[] getNamesByPrefix(String prefix) {
        if (prefix == null) return new String[0];

        List<String> result = new ArrayList<>();

        for (Entry entry : table) {
            while (entry != null) {
                if (entry.name.startsWith(prefix)) {
                    result.add(entry.name);
                }
                entry = entry.next;
            }
        }

        return result.toArray(new String[0]);
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "Телефонный справочник пуст";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Телефонный справочник (").append(size).append(" контактов):\n");

        String[] pairs = getAllPairs();
        for (int i = 0; i < pairs.length; i++) {
            sb.append(i + 1).append(". ").append(pairs[i]).append("\n");
        }

        return sb.toString();
    }
}
