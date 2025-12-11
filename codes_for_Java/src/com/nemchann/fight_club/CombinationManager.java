package com.nemchann.fight_club;

import java.util.ArrayList;
import java.util.List;

// CombinationManager.java
public class CombinationManager {
    private final List<Command> commands = new ArrayList<>();
    private String name; // имя комбинации (опционально)

    public CombinationManager() {}

    public CombinationManager(String name) {
        this.name = name;
    }

    // Добавить команду
    public void addCommand(Command command) {
        commands.add(command);
    }

    // Создать и добавить удар ногой для указанного каратиста
    public void addKick(Karateka karateka) {
        commands.add(new KickCommand(karateka));
    }

    // Создать и добавить удар рукой для указанного каратиста
    public void addPunch(Karateka karateka) {
        commands.add(new PunchCommand(karateka));
    }

    // Создать и добавить удар в прыжке для указанного каратиста
    public void addJumpKick(Karateka karateka) {
        commands.add(new JumpKickCommand(karateka));
    }

    // Методы для управления комбинацией
    public void insertCommand(int index, Command command) {
        if (index >= 0 && index <= commands.size()) {
            commands.add(index, command);
        }
    }

    public void removeCommand(int index) {
        if (index >= 0 && index < commands.size()) {
            commands.remove(index);
        }
    }

    public void clearCombination() {
        commands.clear();
    }

    // Выполнить всю комбинацию
    public void execute() {
        if (name != null) {
            System.out.println("=== Выполнение комбинации: " + name + " ===");
        } else {
            System.out.println("=== Выполнение комбинации ===");
        }

        for (int i = 0; i < commands.size(); i++) {
            System.out.print((i + 1) + ". ");
            commands.get(i).execute();
        }

        System.out.println("Комбинация завершена!\n");
    }

    // Показать комбинацию
    public void show() {
        if (name != null) {
            System.out.println("Комбинация: " + name);
        }
        System.out.println("Текущая последовательность:");

        if (commands.isEmpty()) {
            System.out.println("  (пусто)");
        } else {
            for (int i = 0; i < commands.size(); i++) {
                System.out.println((i + 1) + ". " + commands.get(i).getDescription());
            }
        }
        System.out.println();
    }

    // Геттеры/сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return commands.size();
    }
}