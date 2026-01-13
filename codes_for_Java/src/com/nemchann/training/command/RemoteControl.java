package com.nemchann.training.command;

public class RemoteControl {
    private Command[] slots = new Command[7];

    public void setCommand(int slot, Command command) {
        slots[slot] = command;
    }

    public void pressButton(int slot) {
        if (slots[slot] != null) {
            slots[slot].execute();
        }
    }
}
