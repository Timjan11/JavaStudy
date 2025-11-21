package ru.utegulov.geometry;

class Point3D extends PointBaseClass {
    private int x;
    private int y;
    private int z;

    public Point3D(int x, int y, int z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String getCoordinates() {
        return "Point(" + x + ", " + y + ", " + z + ")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
