package com.nemchann.declaration;

import java.util.Arrays;

public class Declaration {
    private String author;
    private String text;
    private String[] signatures = new String[0];
    private boolean isAccepted;

    public Declaration(String author, String text){
        this.author = author;
        this.text = text;
    }

    public String getAuthor(){
        return author;
    }

    public String getText() {
        return text;
    }

    public String[] getSignatures() {
        return signatures;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void reject(){
        this.isAccepted = false;
    }

    public void accept(){
        this.isAccepted = true;
    }

    public void addSign(String signature){
        for (String sig : signatures) {
            if (sig.equals(signature)) {
                return; // Не добавляем дубликаты
            }
        }
        signatures = Arrays.copyOf(signatures, signatures.length + 1);
        signatures[signatures.length - 1] = signature;
    }
}
