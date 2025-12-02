package com.nemchann.storages;

import com.nemchann.geometry.ThreeCoordinatesDot;

public class Dot3DPutter {
    private ThreeCoordinatesDot dot;

    public void setDot(ThreeCoordinatesDot dot){
        this.dot = dot;
    }
    public void put3DDot(Box<? super ThreeCoordinatesDot> box){
        if (dot == null) {
            throw new IllegalStateException("Dot is not set");
        }

        if (!box.isEmpty()) {
            throw new IllegalArgumentException("Box is not empty");
        }

        box.putObj(dot);
    }
}
