package com.nemchann.cities;

import java.util.*;

public class Route {
    private City startCity;
    private City endCity;

    public Route(City startCity, City endCity){
        if (startCity == null || endCity == null) {
            throw new IllegalArgumentException("Города начала и конца не могут быть null");
        }

        this.startCity = startCity;
        this.endCity = endCity;
    }

    public City getStartCity() {
        return startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public void setStartCity(City startCity) {
        if (startCity == null) {
            throw new IllegalArgumentException("Город начала не может быть null");
        }
        this.startCity = startCity;
    }

    public void setEndCity(City endCity) {
        if (endCity == null) {
            throw new IllegalArgumentException("Город конца не может быть null");
        }
        this.endCity = endCity;
    }

    public List<City> getWayBFS() {
        // Если начало и конец совпадают
        if (startCity.equals(endCity)) {
            List<City> result = new ArrayList<>();
            result.add(startCity);
            return result;
        }

        return findShortestPathBFS();
    }

    private List<City> findShortestPathBFS() {
        Queue<City> queue = new LinkedList<>();
        Map<City, City> previousCities = new HashMap<>();
        Set<City> visited = new HashSet<>();

        queue.add(startCity);
        visited.add(startCity);

        while (!queue.isEmpty()) {
            City current = queue.poll();

            // Если достигли конечного города
            if (current.equals(endCity)) {
                return reconstructPath(previousCities);
            }

            // Обрабатываем соседей
            for (Path path : current.getPaths()) {
                City neighbor = path.getCity();

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    previousCities.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // Путь не найден
        return new ArrayList<>();
    }
    private List<City> reconstructPath(Map<City, City> previousCities) {
        List<City> path = new LinkedList<>();
        City current = endCity;

        // Восстанавливаем путь от конца к началу
        while (current != null) {
            path.add(0, current); // Добавляем в начало
            current = previousCities.get(current);
        }

        // Проверяем, что путь начинается с startCity
        if (path.isEmpty() || !path.get(0).equals(startCity)) {
            return new ArrayList<>();
        }

        return path;
    }

    @Override
    public String toString() {
        List<City> way = getWayBFS(); // Используем самый дешевый путь

        if (way.isEmpty()) {
            return "Маршрут не найден";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < way.size(); i++) {
            sb.append(way.get(i).getName());
            if (i < way.size() - 1) {
                sb.append(" → ");
            }
        }

        // Добавляем информацию о стоимости
        int totalCost = calculateTotalCost(way);
        sb.append(" (Общая стоимость: ").append(totalCost).append(")");

        return sb.toString();
    }

    private int calculateTotalCost(List<City> path) {
        if (path.size() < 2) {
            return 0;
        }

        int totalCost = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            City current = path.get(i);
            City next = path.get(i + 1);

            // Находим стоимость пути между соседними городами
            for (Path p : current.getPaths()) {
                if (p.getCity().equals(next)) {
                    totalCost += p.getCost();
                    break;
                }
            }
        }

        return totalCost;
    }

    public int getTotalCost() {
        List<City> way = getWayBFS();
        return calculateTotalCost(way);
    }

    public int getCityCount() {
        return getWayBFS().size();
    }
}
