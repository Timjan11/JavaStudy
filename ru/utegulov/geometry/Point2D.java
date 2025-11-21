package ru.utegulov.geometry;

class Point2D extends PointBaseClass {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public String getCoordinates() {
        return "Point(" + x + ", " + y + ")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}