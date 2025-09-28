import java.util.ArrayList;
import java.util.List;

public class City {
    List<Path> paths = new ArrayList<>() ;
    String name;

//    public City(String name){
//
//    }

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
