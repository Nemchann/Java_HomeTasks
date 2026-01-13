package com.nemchann.training.visitor;

public class Image implements TextElement{
    private String src;
    private String alt;

    public Image(String src, String alt) {
        this.src = src;
        this.alt = alt;
    }

    public String getSrc() {
        return src;
    }

    public String getAlt() {
        return alt;
    }
    @Override
    public void accept(Visitor v) {
        v.visitImage(this);
    }
}
