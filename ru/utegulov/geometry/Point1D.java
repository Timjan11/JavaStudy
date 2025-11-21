package ru.utegulov.geometry;

public class Point1D extends PointBaseClass {
    private int x;

    public Point1D(int x) {
        super();
        this.x = x;
    }

    @Override
    public String getCoordinates() {
        return "Point(" + x + ")";
    }

    public int getX() {
        return x;
    }
}
