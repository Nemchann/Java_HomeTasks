import java.util.ArrayList;
import java.util.List;

public class City {
    protected List<Path> paths = new ArrayList<>() ;
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
        return new ArrayList<>(paths);
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
