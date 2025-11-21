package ru.utegulov.geometry;

public class SideOfSquare {

    private Point topLeft;
    private int sideLength;

    public SideOfSquare(Point topLeft, int sideLength) {
        this.topLeft = topLeft;
        if(sideLength<0){ throw new IllegalArgumentException("Сторона квадрата должна быть положительной!");}

        this.sideLength = sideLength;
    }


    public SideOfSquare(int x, int y, int sideLength) {
        this.topLeft = new Point(x, y);
        if(sideLength<0){ throw new IllegalArgumentException("Сторона квадрата должна быть положительной!");}

        this.sideLength = sideLength;
    }

    public void setSideLength(int sideLength){
        if(sideLength<0){
            throw new IllegalArgumentException("Сторона квадрата должна быть положительной!");
        }
        this.sideLength = sideLength;
    }

    public PolylineWihtArrOfPoints getPolyline() {
        Point[] corners = new Point[5];

        // Левый верхний угол
        corners[0] = new Point(topLeft.getX(), topLeft.getY());
        // Правый верхний угол
        corners[1] = new Point(topLeft.getX() + sideLength, topLeft.getY());
        // Правый нижний угол
        corners[2] = new Point(topLeft.getX() + sideLength, topLeft.getY() + sideLength);
        // Левый нижний угол
        corners[3] = new Point(topLeft.getX(), topLeft.getY() + sideLength);
        // Замыкаем квадрат - возвращаемся в левый верхний угол
        corners[4] = new Point(topLeft.getX(), topLeft.getY());

        return new PolylineWihtArrOfPoints(corners);
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft + " со стороной " + sideLength;
    }


    public Point getTopLeft() {
        return topLeft;
    }

    public int getSideLength() {
        return sideLength;
    }

}
