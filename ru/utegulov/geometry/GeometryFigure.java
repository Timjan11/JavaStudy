package ru.utegulov.geometry;

abstract class GeometryFigure {
    public abstract double squareOfFigure();

    public void info(){
        System.out.println("Square: "+ squareOfFigure());
    }
}

