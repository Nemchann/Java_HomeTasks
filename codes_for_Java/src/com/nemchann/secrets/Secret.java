package com.nemchann.secrets;

import java.util.Random;
public class Secret {
    private static final Random RANDOM = new Random(); //Чтобы можно было в случайное место добавлять символы
    private static final double NOISE_PERCENTAGE = 0.10; // 10%

    private final String holderName;
    private final String secretText;
    private final int order; // порядковый номер хранителя
    private Secret nextHolder; // следующий хранитель (единственный "близкий друг")
    private Secret previousHolder; // предыдущий хранитель (от кого узнал секрет)

    public Secret(String holderName, String secretText) {
        if (holderName == null || holderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя хранителя не может быть пустым");
        }
        if (secretText == null || secretText.trim().isEmpty()) {
            throw new IllegalArgumentException("Текст секрета не может быть пустым");
        }

        this.holderName = holderName.trim();
        this.secretText = secretText.trim();
        this.order = 1; // первый хранитель
        this.nextHolder = null;
        this.previousHolder = null;
    }

    //Передача секрета другому человеку

    public Secret(Secret originalSecret, String newHolderName) {
        if (originalSecret == null) {
            throw new IllegalArgumentException("Исходный секрет не может быть null");
        }
        if (newHolderName == null || newHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя нового хранителя не может быть пустым");
        }
        if (originalSecret.nextHolder != null) {
            throw new IllegalStateException("Секрет уже был передан другому человеку!");
        }

        this.holderName = newHolderName.trim();
        this.order = originalSecret.order + 1;
        this.previousHolder = originalSecret;

        // Выводим сообщение о передаче
        System.out.println(originalSecret.holderName + " сказал что " + originalSecret.secretText);

        //Изменяем текст секрета
        this.secretText = distortSecret(originalSecret.secretText);

        originalSecret.nextHolder = this;
    }

//    Искажение секрета
    private String distortSecret(String originalText) {
        if (originalText == null || originalText.isEmpty()) {
            return originalText;
        }

        int maxChanges = (int) Math.ceil(originalText.length() * NOISE_PERCENTAGE);
        int numChanges = RANDOM.nextInt(maxChanges + 1); // от 0 до maxChanges

        StringBuilder distortedText = new StringBuilder(originalText);

        for (int i = 0; i < numChanges; i++) {
            // Выбираем случайную позицию для вставки
            int position = RANDOM.nextInt(distortedText.length() + 1);

            char randomChar;
            int charType = RANDOM.nextInt(3);
            switch (charType) {
                case 0: // строчная буква
                    randomChar = (char) ('a' + RANDOM.nextInt(26));
                    break;
                case 1: // заглавная буква
                    randomChar = (char) ('A' + RANDOM.nextInt(26));
                    break;
                case 2: // цифра
                    randomChar = (char) ('0' + RANDOM.nextInt(10));
                    break;
                default: // пробел
                    randomChar = ' ';
                    break;
            }

            // Вставляем случайный символ в случайное место
            distortedText.insert(position, randomChar);
        }

        return distortedText.toString();
    }

// Порядковый номер
    public int getOrderNumber() {
        return this.order;
    }

    //  Сколько человек узнали секрет после текущего
    public int getCountAfterMe() {
        int count = 0;
        Secret current = this.nextHolder;
        while (current != null) {
            count++;
            current = current.nextHolder;
        }
        return count;
    }

    //Получение имени N-го человека (положительное N - следующий, отрицательное - предыдущий)
    public String getNHolderName(int n) {
        if (n == 0) {
            return this.holderName;
        }

        Secret target = this;

        if (n > 0) {
            // Ищем следующего N раз
            for (int i = 0; i < n; i++) {
                if (target.nextHolder == null) {
                    throw new IndexOutOfBoundsException("Нет " + n + " следующего хранителя");
                }
                target = target.nextHolder;
            }
        } else {
            // Ищем предыдущего |n| раз
            for (int i = 0; i < -n; i++) {
                if (target.previousHolder == null) {
                    throw new IndexOutOfBoundsException("Нет " + (-n) + " предыдущего хранителя");
                }
                target = target.previousHolder;
            }
        }

        return target.holderName;
    }

    // Разница в количестве символов с N-ым человеком
    public int getTextLengthDifference(int n) {
        Secret target = this;

        if (n == 0) {
            return 0;
        }

        if (n > 0) {
            // Ищем следующего N раз
            for (int i = 0; i < n; i++) {
                if (target.nextHolder == null) {
                    throw new IndexOutOfBoundsException("Нет " + n + " следующего хранителя");
                }
                target = target.nextHolder;
            }
        } else {
            // Ищем предыдущего |n| раз
            for (int i = 0; i < -n; i++) {
                if (target.previousHolder == null) {
                    throw new IndexOutOfBoundsException("Нет " + (-n) + " предыдущего хранителя");
                }
                target = target.previousHolder;
            }
        }

        return this.secretText.length() - target.secretText.length();
    }

    // Получение имени текущего хранителя
    public String getHolderName() {
        return this.holderName;
    }

    // Получение следующего хранителя
    Secret getNextHolder() {
        return this.nextHolder;
    }

    // Получение предыдущего хранителя
    Secret getPreviousHolder() {
        return this.previousHolder;
    }

    // Преобразование к строке
    @Override
    public String toString() {
        return holderName + ": это секрет!";
    }

    // Получение цепочки хранителей (для отладки)
    public String getChain() {
        StringBuilder chain = new StringBuilder();
        Secret current = getFirstHolder();

        while (current != null) {
            chain.append(current.holderName)
                    .append("(").append(current.order).append(")")
                    .append(": [").append(current.secretText.length()).append(" chars]");
            if (current.nextHolder != null) {
                chain.append(" -> ");
            }
            current = current.nextHolder;
        }

        return chain.toString();
    }

    // Найти первого хранителя в цепочке
    private Secret getFirstHolder() {
        Secret current = this;
        while (current.previousHolder != null) {
            current = current.previousHolder;
        }
        return current;
    }

    // Получить полную цепочку имен хранителей
    public String getHolderChain() {
        StringBuilder chain = new StringBuilder();
        Secret current = getFirstHolder();

        while (current != null) {
            chain.append(current.holderName);
            if (current.nextHolder != null) {
                chain.append(" -> ");
            }
            current = current.nextHolder;
        }

        return chain.toString();
    }

    // Проверка, был ли секрет уже передан
    public boolean wasSecretShared() {
        return this.nextHolder != null;
    }
}
