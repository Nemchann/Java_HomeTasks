package com.nemchann.fight_club;

public interface Command {
    void execute();
    String getDescription(); // Для отображения информации о команде
}
