package com.nemchann.fight_club;

public class KickCommand extends KarateCommand {
    public KickCommand(Karateka karateka) {
        super(karateka);
    }

    @Override
    public void execute() {
        karateka.kick();
    }

    @Override
    public String getDescription() {
        return karateka.getName() + " - Удар ногой";
    }
}
