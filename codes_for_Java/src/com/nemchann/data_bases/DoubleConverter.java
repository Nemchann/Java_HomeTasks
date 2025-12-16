package com.nemchann.data_bases;

public class DoubleConverter implements TypeConverter<Double>{
    @Override
    public Double convert(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cannot convert '" + value + "' to Double");
        }
    }

    @Override
    public Class<Double> getTargetClass() {
        return Double.class;
    }
}
