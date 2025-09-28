import java.util.ArrayList;
import java.util.List;

public class City {
    List<Path> paths = new ArrayList<>() ;
    String name;

    public City(String name){
        this.name = name;
    }

    public City(String name, Path... paths) {
        this.name = name;
        for (Path path : paths) {
            this.paths.add(path);
        }
    }

    void addPaths(City city, int cost){
        paths.add(new Path(city, cost));
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
