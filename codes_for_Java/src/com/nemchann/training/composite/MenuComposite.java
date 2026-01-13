package com.nemchann.training.composite;

import java.util.ArrayList;
import java.util.List;

public class MenuComposite implements MenuComponent{
    private String name;
    private double price;
    private List<MenuComponent> items = new ArrayList<>();

    public MenuComposite(String name){
        this.name = name;
    }

    public void addItem(MenuComponent menuComponent){
        items.add(menuComponent);
        price += menuComponent.getPrice();
    }


    @Override
    public void print() {
        System.out.println("-" + name + " - общая цена: " + price + "\nКомпоненты: ");
        for (MenuComponent menuComponent : items){
            menuComponent.print();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void removeItem(MenuComponent menuComponent) {
        items.remove(menuComponent);
    }

    public void clear() {
        items.clear();
    }
}
