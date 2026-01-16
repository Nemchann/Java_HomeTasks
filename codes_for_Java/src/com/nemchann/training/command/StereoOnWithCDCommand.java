package com.nemchann.training.command;

public class StereoOnWithCDCommand implements Command{
    private Stereo stereo;
    private int previousVolume;
    private boolean wasOn;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        wasOn = stereo.isOn();
        previousVolume = stereo.getVolume();
        stereo.turnOn();
        stereo.setCD("Queen - Greatest Hits");
        stereo.setVolume(70);
    }

    @Override
    public void undo() {
        if (!wasOn) {
            stereo.turnOff();
        }
        stereo.setVolume(previousVolume);
    }

}
