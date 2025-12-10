package com.nemchann.data_bases;

public class DatabaseConnection implements AutoCloseable{
    private final DataBase database;
    boolean isClosed;

    DatabaseConnection(DataBase database){
        this.database = database;
        this.isClosed = false;
    }

    // Получить значение по индексу
    public String getRecord(int index) {
        checkIfClosed();
        return database.getRecord(index);
    }

    // Добавить новое значение
    public void addRecord(String record) {
        checkIfClosed();
        database.addRecord(record);
    }

    // Проверка, закрыто ли подключение
    public boolean isClosed() {
        return isClosed;
    }

    // Закрытие подключения (возврат в пул)
    @Override
    public void close() {
        if (!isClosed) {
            isClosed = true;
            database.releaseConnection(this);
        }
    }

    private void checkIfClosed() {
        if (isClosed) {
            throw new IllegalStateException("Connection is closed");
        }
    }
}
