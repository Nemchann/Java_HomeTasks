package com.nemchann.training.app;

public class AppConfig {
    private static AppConfig instance;
    private String appName;
    private String version;

    private AppConfig(){
        this.appName = "appName";
        this.version = "version";
    }

    private static class Holder{
        private static final AppConfig INSTANCE = new AppConfig();
    }

    public static AppConfig getInstance(){
        return Holder.INSTANCE;
    }

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }
}
