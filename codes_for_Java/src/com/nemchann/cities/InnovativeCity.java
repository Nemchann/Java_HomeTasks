package com.nemchann.cities;

import java.util.ArrayList;
import java.util.List;

public class InnovativeCity extends City{
    public InnovativeCity(String name){
        super(name);
    }

    public InnovativeCity(String name, Path...paths){
        super(name, paths);
    }

    // Переопределенный метод добавления пути с созданием обратного пути
    @Override
    public void addPath(City targetCity, int cost) {
        // Сначала вызываем родительский метод для добавления пути
        super.addPath(targetCity, cost);

        // Затем добавляем обратный путь из targetCity в этот город
        if (targetCity instanceof InnovativeCity) {
            InnovativeCity innovativeTarget = (InnovativeCity) targetCity;

            // Добавляем обратный путь, используя protected метод findPathToCity
            Path existingReversePath = innovativeTarget.findPathToCity(this);
            if (existingReversePath != null) {
                existingReversePath.setCost(cost);  // Обновляем стоимость обратного пути
            } else {
                innovativeTarget.paths.add(new Path(this, cost));  // Создаем новый обратный путь
            }
        }
    }
//    Старый метод removePath() было решено оставить

    public void removeBidirectionalPath(InnovativeCity targetCity) {
        // Удаляем прямой путь
        super.removePath(targetCity);

        // Удаляем обратный путь
        targetCity.removePath(this);
    }
    // НОВЫЙ метод для удобного добавления двусторонних путей
    public void addBidirectionalPath(InnovativeCity targetCity, int cost) {
        // Добавляем путь в обе стороны
        this.addPath(targetCity, cost);
        targetCity.addPath(this, cost);
    }

    @Override
    protected boolean haveSamePaths(City city1, City city2) {
        // Для InnovativeCity нормализуем пути перед сравнением
        List<City> normalized1 = getNormalizedTargetCities(city1);
        List<City> normalized2 = getNormalizedTargetCities(city2);

        return normalized1.size() == normalized2.size() &&
                normalized1.containsAll(normalized2);
    }

    /**
     * Нормализует целевые города - убирает дубликаты
     */
    private List<City> getNormalizedTargetCities(City city) {
        List<City> normalized = new ArrayList<>();
        for (Path path : city.paths) {
            if (!containsCity(normalized, path.city)) {
                normalized.add(path.city);
            }
        }
        return normalized;
    }

//    Метод - содержится ли город в списке городов
    private boolean containsCity(List<City> cities, City target) {
        return cities.stream().anyMatch(city -> city.name.equals(target.name));
    }
}
