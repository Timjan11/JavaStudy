package ru.utegulov.geometry;

public class Point3D extends Point {
    private int x;
    private int y;
    private int z;

    public Point3D(int x, int y, int z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getCoordinates() {
        return "Point(" + x + ", " + y + ", " + z + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
