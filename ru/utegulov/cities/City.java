package ru.utegulov.cities;

import java.util.Objects;

public class City {

    private String name;
    private City[] connectedCities;
    private int[] costs;
    private int routeCount;


    public City(String name) {
        this.name = name;
        this.connectedCities = new City[10];
        this.costs = new int[10];
        this.routeCount = 0;
    }


    public City[] getConnectedCities() {
        routeCount = connectedCities.length;
        return connectedCities;
    }

    public boolean connectedCitiesIsEquals(Object[] otherCities) {
        // Проверка на null и длину
        if (otherCities == null || getConnectedCities().length != otherCities.length) {
            return false;
        }

        // Поэлементное сравнение через equals()
        for (int i = 0; i < getConnectedCities().length; i++) {
            if (!Objects.equals(getConnectedCities()[i], otherCities[i])) {
                return false; // Возвращаем false при первом несовпадении
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;

        // Проверяем, что obj - объект того же класса
        if (!(obj instanceof City)) return false;

        City other = (City) obj;

        // Сравниваем массивы connectedCities
        return connectedCitiesIsEquals(other.getConnectedCities());
    }

    public City(String name, Object... routes) {
        this(name);

        for (int i = 0; i < routes.length; i += 2) {
            if (i + 1 < routes.length && routes[i] instanceof City) {
                City city = (City) routes[i];
                int cost = ((Integer) routes[i + 1]).intValue();
                addRoute(city, cost);
            }
        }
    }


    public void addRoute(City city, int cost) {

        if (routeCount >= connectedCities.length) {
            City[] newCities = new City[connectedCities.length * 2];
            int[] newCosts = new int[costs.length * 2];

            for (int i = 0; i < routeCount; i++) {
                newCities[i] = connectedCities[i];
                newCosts[i] = costs[i];
            }

            connectedCities = newCities;
            costs = newCosts;
        }

        connectedCities[routeCount] = city;
        costs[routeCount] = cost;
        routeCount++;
    }

    public String toString() {
        StringBuilder result = new StringBuilder(name);

        if (routeCount > 0) {
            result.append(" -> ");
            for (int i = 0; i < routeCount; i++) {
                if (i > 0) {
                    result.append(", ");
                }
                result.append(connectedCities[i].name)
                        .append(": ")
                        .append(costs[i]);
            }
        } else {
            result.append(" (нет маршрутов)");
        }

        return result.toString();
    }
}