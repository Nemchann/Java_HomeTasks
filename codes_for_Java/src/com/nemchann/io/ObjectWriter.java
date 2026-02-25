package com.nemchann.io;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class ObjectWriter {
    private String fileName;

    public ObjectWriter(String fileName){
        this.fileName = fileName;
    }

    public void write(List<?> objects) throws IOException {
        try(FileWriter fileWriter = new FileWriter(fileName)){
            for (Object obj : objects){
                Class<?> clz = obj.getClass();

                fileWriter.write(clz.getName());

                Field[] fields = clz.getDeclaredFields();
                for (Field field : fields){
                    field.setAccessible(true);
                    try{
                        Object value = field.get(obj);
                        fileWriter.write(" " + value.toString());

                    }catch (IllegalAccessException e){
                        throw new IOException("Не удалось прочитать поле объекта");
                    }
                }
                fileWriter.write("\n");
            }
        }


    }
}
