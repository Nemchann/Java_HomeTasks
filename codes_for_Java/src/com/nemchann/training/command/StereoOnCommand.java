package com.nemchann.training.command;

public class StereoOnCommand implements Command{
    private Light light;

    public StereoOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.stereoOn();
    }
}
