package ru.utegulov.geometry;

public class SquareFigure extends GeometryFigure {
    private double side;

    public SquareFigure(double side){
        if(side<=0){
            throw new IllegalArgumentException("Side must be >0");
        }
        this.side = side;
    }
    public double squareOfFigure(){
        return side*side;
    }
}
