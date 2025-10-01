

public class Path {
    int cost;
    City city;

    public Path(City city, int cost){
        this.city = city;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public City getCity() {
        return city;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
