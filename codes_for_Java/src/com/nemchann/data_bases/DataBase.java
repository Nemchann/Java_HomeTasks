package com.nemchann.data_bases;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private final List<String> data;
    private final ConnectionPool connectionPool;

    public DataBase(int maxConnections){
        this.data = new ArrayList<>();

        // Инициализируем 10 произвольными значениями
        for (int i = 1; i <= 10; i++) {
            data.add("Record_" + i);
        }

        this.connectionPool = new ConnectionPool(this, maxConnections);

    }

    String getRecord(int index) {
        if (index < 0 || index >= data.size()) {
            return null;
        }
        return data.get(index);
    }

    void addRecord(String record) {
        data.add(record);
    }

    // Метод для получения подключения
    public DatabaseConnection getConnection() {
        return connectionPool.getConnection();
    }

    // Метод для освобождения подключения (вызывается Connection при закрытии)
    void releaseConnection(DatabaseConnection connection) {
        connectionPool.releaseConnection(connection);
    }

    // Для отладки
    public int getRecordCount() {
        return data.size();
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "strings=" + data +
                '}';
    }
}
