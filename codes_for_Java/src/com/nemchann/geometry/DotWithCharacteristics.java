package com.nemchann.geometry;

public class DotWithCharacteristics extends AbstractDot {
    private AbstractDot dot;
    private String color;
    private int size;

    private DotWithCharacteristics(AbstractDot dot){
        this.dot = dot;
    }

    public static DotWithCharacteristics wrap(AbstractDot dot) {
        return new DotWithCharacteristics(dot);
    }

    public DotWithCharacteristics withColor(String color) {
        this.color = color;
        return this;
    }

    public DotWithCharacteristics withSize(int size) {
        this.size = size;
        return this;
    }

    @Override
    public String getCoordinates() {
        return dot.getCoordinates();
    }

    @Override
    public void shift(Coordinate coordinate, int value) {
        System.out.println("Тут просто точечка с характеристиками");
    }

    @Override
    public String getDescription() {
        String result = dot.getDescription();

        if (color != null || !color.isEmpty()){
            result += ", " + color + " цвет";
        }
        if (size != 0){
            result += ", " + size + " размер";
        }
        return result;
    }
}
