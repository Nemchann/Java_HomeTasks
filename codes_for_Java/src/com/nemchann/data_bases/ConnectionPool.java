package com.nemchann.data_bases;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private final DataBase database;
    private final int maxSize;
    private int activeConnections;
    private final BlockingQueue<DatabaseConnection> availableConnections;
    private final ReentrantLock lock = new ReentrantLock();

    public ConnectionPool(DataBase database, int maxSize) {
        this.database = database;
        this.maxSize = maxSize;
        this.activeConnections = 0;
        this.availableConnections = new LinkedBlockingQueue<>(maxSize);
    }

    // Получить подключение (возвращает null если нет свободных)
    public DatabaseConnection getConnection() {
        lock.lock();
        try {
            // Если есть готовое подключение в очереди
            DatabaseConnection connection = availableConnections.poll();
            if (connection != null) {
                connection.isClosed = false; // "Открываем" его
                return connection;
            }

            // Если можно создать новое подключение
            if (activeConnections < maxSize) {
                activeConnections++;
                return new DatabaseConnection(database);
            }

            // Нет свободных подключений
            return null;
        } finally {
            lock.unlock();
        }
    }

    // Получить подключение с ожиданием
    public DatabaseConnection getConnection(long timeout, TimeUnit unit) throws InterruptedException {
        lock.lock();
        try {
            // Пытаемся получить сразу
            DatabaseConnection connection = getConnection();
            if (connection != null) {
                return connection;
            }

            // Ждем освобождения подключения
            long nanos = unit.toNanos(timeout);
            long deadline = System.nanoTime() + nanos;

            while (true) {
                // Проверяем, можно ли создать новое
                if (activeConnections < maxSize) {
                    activeConnections++;
                    return new DatabaseConnection(database);
                }

                // Ждем, пока не освободится место
                if (nanos <= 0) {
                    return null; // Таймаут
                }

                // Кратковременно отпускаем lock для возможности освобождения
                lock.unlock();
                try {
                    Thread.sleep(1); // Короткая пауза
                } finally {
                    lock.lock();
                }

                nanos = deadline - System.nanoTime();
            }
        } finally {
            lock.unlock();
        }
    }

    // Освободить подключение (вернуть в пул)
    public void releaseConnection(DatabaseConnection connection) {
        lock.lock();
        try {
            if (!availableConnections.offer(connection)) {
                // Если очередь полна (не должно происходить)
                activeConnections--;
            }
        } finally {
            lock.unlock();
        }
    }

    // Статистика
    public int getAvailableConnectionsCount() {
        return availableConnections.size();
    }

    public int getActiveConnectionsCount() {
        return activeConnections;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
