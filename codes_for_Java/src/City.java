import java.util.ArrayList;
import java.util.List;

public class City {
    private List<Path> paths = new ArrayList<>() ;
    private String name;

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
        // Ищем существующий путь к этому городу
        Path existingPath = findPathToCity(targetCity);

        if (existingPath != null) {
            // Если путь уже существует - обновляем стоимость
            existingPath.cost = cost;
        } else {
            // Если пути нет - создаем новый
            paths.add(new Path(targetCity, cost));
        }
    }

    // Удаление пути
    public void removePath(City targetCity) {
        Path pathToRemove = findPathToCity(targetCity);
        if (pathToRemove != null) {
            paths.remove(pathToRemove);
        }
    }

    // Поиск пути к конкретному городу
    private Path findPathToCity(City targetCity) {
        for (Path path : paths) {
            if (path.city.equals(targetCity)) {
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
        return new ArrayList<>(paths); // Возвращаем копию для защиты от изменений
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
