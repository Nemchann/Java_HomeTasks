package com.nemchann.training.smart_house.command;

import com.nemchann.training.smart_house.SmartHomeController;

public class LightsOnSmartCommand implements SmartCommand{
    private SmartHomeController controller;

    public LightsOnSmartCommand(SmartHomeController controller){
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.turnOn();
    }
}
