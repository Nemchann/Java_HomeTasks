package com.nemchann.geometry;

import java.util.ArrayList;
import java.util.List;

public class CompositeGroup implements Shiftable {
    private final List<Shiftable> components = new ArrayList<>();
    private final String name;

    public CompositeGroup(String name) {
        this.name = name;
    }

    public CompositeGroup(String name, Shiftable... components) {
        this.name = name;
        for (Shiftable component : components) {
            this.components.add(component);
        }
    }

    // Добавление компонента в группу
    public void add(Shiftable component) {
        components.add(component);
    }

    // Удаление компонента из группы
    public void remove(Shiftable component) {
        components.remove(component);
    }

    // Получение списка компонентов
    public List<Shiftable> getComponents() {
        return new ArrayList<>(components);
    }

    // Получение компонента по индексу
    public Shiftable getComponent(int index) {
        return components.get(index);
    }

    // Получение размера группы
    public int size() {
        return components.size();
    }

    // Реализация Shiftable - сдвиг всех компонентов группы
    @Override
    public void shift(Coordinate coordinate, int value) {
        System.out.println("Сдвиг группы '" + name + "' по координате " + coordinate + " на " + value);
        for (Shiftable component : components) {
            component.shift(coordinate, value);
        }
    }

    @Override
    public void shift(int dx, int dy) {
        System.out.println("Сдвиг группы '" + name + "' на (" + dx + ", " + dy + ")");
        for (Shiftable component : components) {
            component.shift(dx, dy);
        }
    }

    // Рекурсивный вывод структуры группы
    public void printStructure() {
        printStructure(0);
    }

    private void printStructure(int indent) {
        String indentStr = "  ".repeat(indent);
        System.out.println(indentStr + "Группа: " + name + " (элементов: " + components.size() + ")");

        for (Shiftable component : components) {
            if (component instanceof CompositeGroup) {
                ((CompositeGroup) component).printStructure(indent + 1);
            } else {
                System.out.println(indentStr + "  - " + getComponentDescription(component));
            }
        }
    }

    private String getComponentDescription(Shiftable component) {
        if (component instanceof Dot) {
            return "Точка: " + ((Dot) component).getCoordinates();
        } else if (component instanceof Line) {
            Line<?> line = (Line<?>) component;
            return "Линия: " + line.getStart().getCoordinates() + " -> " + line.getEnd().getCoordinates();
        } else if (component instanceof Figure) {
            return "Фигура: " + component.getClass().getSimpleName();
        } else {
            return component.getClass().getSimpleName();
        }
    }

    @Override
    public String toString() {
        return "CompositeGroup[" + name + ", элементов: " + components.size() + "]";
    }
}