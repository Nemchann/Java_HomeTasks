package com.nemchann.training.adapter;

public class PrinterAdapter implements ModernPrinter{
    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter){
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String content) {
        oldPrinter.printDocument(content);
    }
}
