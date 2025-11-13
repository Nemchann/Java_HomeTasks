package com.nemchann.internet_connections;

public class ConnectionManager {

    public static void main(String[] args) {
        ExampleConnector connector = new ExampleConnector();
        Connection connection = new Connection("example.com");

        // Вызываем makeConnect с правильной обработкой исключений
        callMakeConnectSafely(connector, connection);
    }

    public static void callMakeConnectSafely(ExampleConnector connector, Connection connection) {
        try {
            connector.makeConnect(connection);
        } catch (RuntimeException e) {
            handleRuntimeException(e, connector);
        }
    }

    private static void handleRuntimeException(RuntimeException e, ExampleConnector connector) {
        // Проверяем, является ли исключение IsClosedException
        // или обернутым LostCommunicationException
        if (e.getCause() instanceof LostCommunicationException ||
                e instanceof IsClosedException) {
            // Исключение из nextString() - вызываем unregister
            System.out.println("Исключение в nextString(), вызываем unregister...");
            connector.unregister();
        } else {
            // Исключение из register() - игнорируем, ничего не делаем
            System.out.println("Исключение в register(), игнорируем...");
        }
    }
}