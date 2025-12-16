package com.nemchann.data_bases;

public class PointConverter implements TypeConverter<Point>{
    @Override
    public Point convert(String value) {
        return Point.fromString(value);
    }

    @Override
    public Class<Point> getTargetClass() {
        return Point.class;
    }
}
