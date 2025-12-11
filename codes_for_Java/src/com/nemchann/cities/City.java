package com.nemchann.cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class City {
    protected List<Path> paths = new ArrayList<>() ;
    String name;

    public City(String name){
        this.name = name;
    }

    public City(String name, Path... paths) {
        this.name = name;
        for (Path path : paths) {
            this.addPath(path.city, path.cost);
        }
    }

    // Добавление/обновление пути
    public void addPath(City targetCity, int cost) {

        Path existingPath = findPathToCity(targetCity);

        if (existingPath != null) {

            existingPath.cost = cost;
        } else {

            paths.add(new Path(targetCity, cost));
        }
    }

    // Удаление пути
    protected void removePath(City targetCity) {
        Path pathToRemove = findPathToCity(targetCity);
        if (pathToRemove != null) {
            paths.remove(pathToRemove);
        }
    }

    // Поиск пути к конкретному городу
    protected Path findPathToCity(City targetCity) {
        for (Path path : paths) {
            if (path.city == targetCity || path.city.name.equals(targetCity.name)) {
                return path;
            }
        }
        return null;
    }

    void addPaths(City city, int cost){
        paths.add(new Path(city, cost));
    }

    // Получение стоимости пути к городу (возвращает -1 если пути нет)
    public int getPathCost(City targetCity) {
        Path path = findPathToCity(targetCity);
        return path != null ? path.cost : -1;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public List<Path> getPaths() {
        return new ArrayList<>(paths);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof City)) return false;

        City otherCity = (City) obj;

        return this.name.equals(otherCity.name);
    }

    protected boolean haveSamePaths(City city1, City city2) {
        // Получаем множества целевых городов для каждого города
        List<City> city1Targets = getTargetCities(city1);
        List<City> city2Targets = getTargetCities(city2);

        return city1Targets.size() == city2Targets.size() &&
                city1Targets.containsAll(city2Targets);
    }

    private List<City> getTargetCities(City city) {
        List<City> targetCities = new ArrayList<>();
        for (Path path : city.paths) {

            if (!containsCity(targetCities, path.city)) {
                targetCities.add(path.city);
            }
        }
        return targetCities;
    }

    private boolean containsCity(List<City> cities, City targetCity) {
        for (City city : cities) {
            if (city.equals(targetCity)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
//        List<City> targetCities = getTargetCities(this);
//
//        targetCities.sort((c1, c2) -> c1.name.compareTo(c2.name));
//
//        return Objects.hash(name, targetCities);
        return Objects.hash(name);
    }

    public String toString(){
        String result = name + ":\n";

        for (Path path : paths){
            result += "->" + path.city.name + ": " + path.cost;
            result += "\n";
        }
        return result;
    }

}
