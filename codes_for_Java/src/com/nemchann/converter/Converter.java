package com.nemchann.converter;

public abstract class Converter {
    // ШАБЛОННЫЙ МЕТОД - фиксированная последовательность шагов
    public final void convert(String inputFileName, String outputFileName) {
        // Шаг 1: Открытие документа
        String content = openDocument(inputFileName);

        // Шаг 2: Преобразование данных
        String transformedContent = transform(content);

        // Шаг 3: Запись документа
        writeDocument(transformedContent, outputFileName);

        // Дополнительный шаг (если нужно)
        onConversionComplete(inputFileName, outputFileName);
    }

    // Абстрактные методы, которые должны реализовать подклассы
    protected abstract String openDocument(String fileName);
    protected abstract String transform(String content);
    protected abstract void writeDocument(String content, String fileName);

    // Метод-хук (необязательный для переопределения)
    protected void onConversionComplete(String inputFile, String outputFile) {
        // Пустая реализация по умолчанию
        System.out.println("Конвертация завершена: " + inputFile + " -> " + outputFile);
    }

    // Можно добавить финальные методы с общей логикой
    protected final void validateFileName(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя файла не может быть пустым");
        }
    }
}
