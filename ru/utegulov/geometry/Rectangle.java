package ru.utegulov.geometry;

public class Rectangle extends GeometryFigure {

    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB){
        if(sideA<=0||sideB<=0){
            throw new IllegalArgumentException("sides must be >0");
        }
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double squareOfFigure(){
        return sideA*sideB;
    }

}
