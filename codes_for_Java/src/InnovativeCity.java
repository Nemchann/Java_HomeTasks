import java.util.ArrayList;
import java.util.List;

public class InnovativeCity extends City{
    public InnovativeCity(String name){
        super(name);
    }

    public InnovativeCity(String name, Path...paths){
        super(name, paths);
    }

    public void addPath(InnovativeCity targetCity, int cost){
        Path existingPath = findPathToCity(targetCity);

        if (existingPath != null) {

            existingPath.cost = cost;
        } else {

            paths.add(new Path(targetCity, cost));
        }
    }

    private Path findPathToCity(InnovativeCity targetCity) {
        for (Path path : paths) {
            if (path.city.equals(targetCity)) {
                return path;
            }
        }
        return null;
    }
}
