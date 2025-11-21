package ru.utegulov.house;

public class HouseOnSky {

    private int floors;

    public HouseOnSky(int floors) {
        if (floors <= 0)
            throw new IllegalArgumentException("Количество этажей должно быть > 0");
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        if (floors <= 0) {
            throw new IllegalArgumentException("Количество этажей должно быть > 0");
        }
        this.floors = floors;
    }

    @Override
    public String toString() {
        if (floors == 1) {
            return "Дом с " + floors + " этажом";
        } else {
            return "Дом с " + floors + " этажами";
        }
    }

}
