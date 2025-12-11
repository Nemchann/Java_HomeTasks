package com.nemchann.fight_club;

public class JumpKickCommand extends KarateCommand {
    public JumpKickCommand(Karateka karateka) {
        super(karateka);
    }

    @Override
    public void execute() {
        karateka.jumpKick();
    }

    @Override
    public String getDescription() {
        return karateka.getName() + " - Удар в прыжке";
    }
}