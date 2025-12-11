package com.nemchann.phones_dictionary;

import java.util.*;

public class PhoneDirectory {
    private final Map<String, String> nameToPhone;
    private final Map<String, String> phoneToName;

    public PhoneDirectory() {
        nameToPhone = new HashMap<>();
        phoneToName = new HashMap<>();
    }

    public String add(String phone, String name) {
        if (phone == null || name == null) {
            throw new IllegalArgumentException("Телефон и имя не могут быть null");
        }

        // Проверяем, существует ли уже такое имя
        String oldPhone = nameToPhone.get(name);

        if (oldPhone != null) {
            // Удаляем старую связь телефон-имя
            phoneToName.remove(oldPhone);
        }

        // Проверяем, существует ли уже такой телефон
        String oldName = phoneToName.get(phone);
        if (oldName != null) {
            // Удаляем старую связь имя-телефон
            nameToPhone.remove(oldName);
        }

        // Добавляем новые связи
        nameToPhone.put(name, phone);
        phoneToName.put(phone, name);

        return oldPhone;
    }
//Удалить по имени
    public String removeByName(String name) {
        if (name == null) return null;

        String phone = nameToPhone.remove(name);
        if (phone != null) {
            phoneToName.remove(phone);
        }
        return phone;
    }
//    Удалить по номеру телефона
    public String removeByPhone(String phone) {
        if (phone == null) return null;

        String name = phoneToName.remove(phone);
        if (name != null) {
            nameToPhone.remove(name);
        }
        return name;
    }

    public String getPhoneByName(String name) {
        return nameToPhone.get(name);
    }

    public String getNameByPhone(String phone) {
        return phoneToName.get(phone);
    }

    public boolean containsName(String name) {
        return nameToPhone.containsKey(name);
    }

    public boolean containsPhone(String phone) {
        return phoneToName.containsKey(phone);
    }

    public int size() {
        return nameToPhone.size();
    }

    public boolean isEmpty() {
        return nameToPhone.isEmpty();
    }

    public void clear() {
        nameToPhone.clear();
        phoneToName.clear();
    }

    public String[] getAllPairs() {
        String[] pairs = new String[nameToPhone.size()];
        int i = 0;

        for (Map.Entry<String, String> entry : nameToPhone.entrySet()) {
            pairs[i++] = entry.getValue() + " - " + entry.getKey();
        }

        return pairs;
    }

    public String[] getAllPhones() {
        return phoneToName.keySet().toArray(new String[0]);
    }

    public String[] getAllNames() {
        return nameToPhone.keySet().toArray(new String[0]);
    }

    public String[] getNamesByPrefix(String prefix) {
        if (prefix == null) return new String[0];

        List<String> result = new ArrayList<>();

        for (String name : nameToPhone.keySet()) {
            if (name.startsWith(prefix)) {
                result.add(name);
            }
        }

        return result.toArray(new String[0]);
    }

    public String[] getPairsByPrefix(String prefix) {
        if (prefix == null) return new String[0];

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, String> entry : nameToPhone.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                result.add(entry.getValue() + " - " + entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }


    public String[] getAllPairsSortedByName() {
        List<String> names = new ArrayList<>(nameToPhone.keySet());
        Collections.sort(names);

        String[] pairs = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            pairs[i] = nameToPhone.get(name) + " - " + name;
        }

        return pairs;
    }

    /**
     * Представление справочника в виде строки
     * @return строковое представление всех пар
     */
    @Override
    public String toString() {
        if (nameToPhone.isEmpty()) {
            return "Телефонный справочник пуст";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Телефонный справочник (").append(size()).append(" контактов):\n");

        String[] pairs = getAllPairsSortedByName();
        for (int i = 0; i < pairs.length; i++) {
            sb.append(i + 1).append(". ").append(pairs[i]).append("\n");
        }

        return sb.toString();
    }

}
