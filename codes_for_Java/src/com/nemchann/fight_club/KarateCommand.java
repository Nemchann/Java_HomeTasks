package com.nemchann.fight_club;

public abstract class KarateCommand implements Command {
    protected final Karateka karateka;

    public KarateCommand(Karateka karateka) {
        this.karateka = karateka;
    }

    @Override
    public abstract void execute();

    @Override
    public abstract String getDescription();
}

