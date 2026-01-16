package com.nemchann.training.smart_house.command;

import com.nemchann.training.smart_house.SmartHomeController;

public class LightsOffSmartCommand implements SmartCommand{
    private SmartHomeController controller;

    public LightsOffSmartCommand(SmartHomeController controller){
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.turnOff();
    }
}
