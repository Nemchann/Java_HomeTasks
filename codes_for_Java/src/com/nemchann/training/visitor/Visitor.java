package com.nemchann.training.visitor;

public interface Visitor {
    void visitParagraph(Paragraph paragraph);
    void visitImage(Image image);
    void visitTable(Table table);
}
