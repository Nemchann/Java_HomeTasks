package com.nemchann.training.proxy;

public class VideoManager {
    VideoService videoService;

    public VideoManager(VideoService videoService){
        this.videoService = videoService;
    }

    public Video getVideo(int id){
        return videoService.getVideo(id);
    }


}
