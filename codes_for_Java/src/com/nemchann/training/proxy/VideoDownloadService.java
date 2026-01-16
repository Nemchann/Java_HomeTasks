package com.nemchann.training.proxy;

public class VideoDownloadService implements VideoService {

    @Override
    public Video getVideo(int id) {
        try{
            Thread.sleep(5000);
            System.out.println("Видео " + id + " загружено");
            return new Video(id);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
