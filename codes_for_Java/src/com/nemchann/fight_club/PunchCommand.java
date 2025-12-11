package com.nemchann.fight_club;

public class PunchCommand extends KarateCommand {
    public PunchCommand(Karateka karateka) {
        super(karateka);
    }

    @Override
    public void execute() {
        karateka.punch();
    }

    @Override
    public String getDescription() {
        return karateka.getName() + " - Удар рукой";
    }
}
