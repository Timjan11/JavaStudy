package ru.utegulov.geometry;

public class Point2D extends Point{
    private int x;
    private int y;


    public Point2D(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public String getCoordinates() {
        return "Point(" + x + ", " + y + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}