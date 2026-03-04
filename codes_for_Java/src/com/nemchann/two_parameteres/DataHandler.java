package com.nemchann.two_parameteres;

@Two(first = "DatabaseMigration", second = 20)
public class DataHandler {
    private final String sourceFile;
    private final String finalFile;

    public DataHandler (String sourceFile, String finalFile){
        this.sourceFile = sourceFile;
        this.finalFile = finalFile;
    }

    public void handle(){
        System.out.println("Из " + sourceFile + " перезаписываем данные в " + finalFile);
    }

}
