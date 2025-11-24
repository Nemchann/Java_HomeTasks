package com.nemchann.cities;

import com.nemchann.mathematic.Fraction;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (getClass() != obj.getClass()) return false;
        Path path = (Path) obj;
        return (this.city.equals(path.city));
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, city);
    }
}
