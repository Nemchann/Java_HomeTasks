package com.nemchann.training.proxy;

import java.util.HashMap;
import java.util.Map;

public class CachingProxy implements VideoService {
    VideoDownloadService realSubject;
    Map<Integer, Video> cashedVideos = new HashMap<>();

    public CachingProxy(VideoDownloadService videoDownloadService){
        this.realSubject = videoDownloadService;
    }

    @Override
    public Video getVideo(int id) {
        if (!cashedVideos.containsKey(id)){
            cashedVideos.put(id, realSubject.getVideo(id));
        }
        else{
            System.out.println("Видео " + id + " уже загружено");
        }
        return cashedVideos.get(id);
    }

}
