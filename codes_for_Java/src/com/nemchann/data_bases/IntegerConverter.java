package com.nemchann.data_bases;

public class IntegerConverter implements TypeConverter<Integer>{
    @Override
    public Integer convert(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cannot convert '" + value + "' to Integer");
        }
    }

    @Override
    public Class<Integer> getTargetClass() {
        return Integer.class;
    }
}
