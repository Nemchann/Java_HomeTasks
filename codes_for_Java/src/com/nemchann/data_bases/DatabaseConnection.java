package com.nemchann.data_bases;

public class DatabaseConnection implements AutoCloseable{
    private final DataBase database;
    private final ConverterRegistry converterRegistry;
    boolean isClosed;

    DatabaseConnection(DataBase database) {
        this(database, database.getConverterRegistry());
    }

    DatabaseConnection(DataBase database, ConverterRegistry converterRegistry) {
        this.database = database;
        this.converterRegistry = converterRegistry;
        this.isClosed = false;
    }

    // Получить значение по индексу
    public String getRecord(int index) {
        checkIfClosed();
        return database.getRecord(index);
    }

    public <T> T get(int index, Class<T> type) {
        checkIfClosed();
        String rawValue = database.getRecord(index);
        if (rawValue == null) {
            return null;
        }

        TypeConverter<T> converter = converterRegistry.getConverter(type);
        return converter.convert(rawValue);
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
