package com.nemchann.training.command;

public class StereoOffCommand implements Command{
    private Light light;

    public StereoOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.stereoOn();
    }
}
