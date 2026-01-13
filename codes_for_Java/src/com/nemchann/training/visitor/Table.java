package com.nemchann.training.visitor;

import java.util.List;

public class Table implements TextElement{
    private List<List<String>> data;

    public Table(List<List<String>> data) {
        this.data = data;
    }

    public List<List<String>> getData() {
        return data;
    }

    @Override
    public void accept(Visitor v) {
        v.visitTable(this);
    }
}
