package com.nemchann.training.command;

public class Stereo {
    private boolean isOn;
    private int volume;
    private String cd;

    public Stereo() {
        this.isOn = false;
        this.volume = 50;
    }

    public void turnOn() {
        isOn = true;
        System.out.println("🔊 Стерео включено");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("🔊 Стерео выключено");
    }

    public void setCD(String cd) {
        this.cd = cd;
        System.out.println("💿 Установлен CD: " + cd);
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("📶 Громкость установлена на: " + volume + "%");
    }

    public boolean isOn() {
        return isOn;
    }

    public int getVolume() {
        return volume;
    }
}
