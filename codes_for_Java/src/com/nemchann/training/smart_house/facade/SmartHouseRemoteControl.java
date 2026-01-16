package com.nemchann.training.smart_house.facade;

import com.nemchann.training.smart_house.SmartHomeController;
import com.nemchann.training.smart_house.command.*;
import com.nemchann.training.smart_house.strategy.Mode;

public class SmartHouseRemoteControl {
    SmartHomeController controller;
    SmartCommand[] commands;

    public SmartHouseRemoteControl(SmartHomeController controller){
        this.controller = controller;
        this.commands = new SmartCommand[8];

        // Инициализируем пустыми командами
        SmartCommand noCommand = new NoSmartCommand();
        for (int i = 0; i < 8; i++) {
            commands[i] = noCommand;
        }
    }

    public void setCommand(int slot, SmartCommand command) {
        commands[slot] = command;
    }

    public void pressOnButton(int slot) {
        commands[slot].execute();
    }

    public void setMode(Mode mode){
        this.controller.setMode(mode);
        this.controller.executeMode();
    }
}
