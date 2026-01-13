package com.nemchann.training.visitor;

public class Paragraph implements TextElement{
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    @Override
    public void accept(Visitor v) {
        v.visitParagraph(this);
    }
}
