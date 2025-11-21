package ru.utegulov.cities;
import java.util.*;

public class Roads {
    private String name;
    private Map<Roads, Integer> routes;

    public Roads(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    public Roads(String name, Map<Roads, Integer> routes) {
        this.name = name;
        this.routes = new HashMap<>(routes);
    }

    public boolean addRoad(Roads city, int cost) {
        if (city == null || city == this) {
            return false;
        }

        routes.put(city, cost);
        return true;
    }

    public boolean removeRoad(Roads city) {
        if (routes.containsKey(city)) {
            routes.remove(city);
            return true;
        }
        return false;
    }

    public Integer getCostTo(Roads city) {
        return routes.get(city);
    }

    public List<Map.Entry<Roads, Integer>> getConnectedCities() {
        return new ArrayList<>(routes.entrySet());
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (routes.isEmpty()) {
            return name + ": []";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": [");

        List<String> routeStrings = new ArrayList<>();
        for (Map.Entry<Roads, Integer> entry : routes.entrySet()) {
            routeStrings.add(entry.getKey().getName() + ": " + entry.getValue());
        }

        sb.append(String.join(", ", routeStrings));
        sb.append("]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roads city = (Roads) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
