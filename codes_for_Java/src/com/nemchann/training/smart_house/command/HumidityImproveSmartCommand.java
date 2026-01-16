package com.nemchann.training.smart_house.command;

import com.nemchann.training.smart_house.SmartHomeController;

public class HumidityImproveSmartCommand implements SmartCommand{
    private SmartHomeController controller;

    public HumidityImproveSmartCommand(SmartHomeController controller){
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.improveHumidity();
    }
}
