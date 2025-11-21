package ru.utegulov.geometry;

public class Circle extends GeometryFigure {

    private int radius;
    final double PI = 3.14;

    public Circle(int radius){
        if(radius<=0){
            throw new IllegalArgumentException("radius must be >0");
        }
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double squareOfFigure() {
        double res = (PI*radius*radius);
        return res;
    }
}
