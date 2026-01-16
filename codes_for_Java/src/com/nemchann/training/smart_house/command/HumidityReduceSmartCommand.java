package com.nemchann.training.smart_house.command;

import com.nemchann.training.smart_house.SmartHomeController;

public class HumidityReduceSmartCommand implements SmartCommand{
    private SmartHomeController controller;

    public HumidityReduceSmartCommand(SmartHomeController controller){
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.reduceHumidity();
    }
}
