package com.nemchann.converter;

public class TextConverter extends Converter{
    @Override
    protected String openDocument(String fileName) {
        validateFileName(fileName);
        System.out.println("Открываю текстовый файл: " + fileName);
        // Здесь реальное чтение файла
        return "Содержимое текстового файла " + fileName;
    }

    @Override
    protected String transform(String content) {
        System.out.println("Преобразую текст в верхний регистр");
        return content.toUpperCase();
    }

    @Override
    protected void writeDocument(String content, String fileName) {
        System.out.println("Записываю результат в файл: " + fileName);
        // Здесь реальная запись файла
    }
}
