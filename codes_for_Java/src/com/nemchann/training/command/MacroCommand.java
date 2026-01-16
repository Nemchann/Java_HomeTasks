package com.nemchann.training.command;

import java.util.ArrayList;
import java.util.List;


public class MacroCommand implements Command{
    private List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = new ArrayList<>(commands);
    }

    @Override
    public void execute() {
        System.out.println("Запуск макроса...");
        for (Command command : commands) {
            command.execute();
        }
        System.out.println("✅ Макрос выполнен");
    }

    @Override
    public void undo() {
        System.out.println("↩️ Отмена макроса...");
        // Отменяем в обратном порядке
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}
