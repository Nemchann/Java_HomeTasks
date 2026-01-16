package com.nemchann.training.proxy;

public class Video {
    private final int id;

    public Video(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Video {" +
                "id = " + id +
                '}';
    }
}
