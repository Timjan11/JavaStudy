package ru.utegulov.geometry;


import java.util.Objects;

public class Point implements Cloneable{
    int x;
    int y;
     public Point(double v, double y){
         this(0, 0);

     }

     public Point(){

     }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


     public Point(int x, int y){
         this.x = x;
         this.y = y;

     }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj == null) return false;
        if(!(getClass() == obj.getClass()))return false;
        Point point = (Point) obj;
        if(this.x != point.x || this.y != point.y){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Object clone() throws CloneNotSupportedException{
         return super.clone();
    }

    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

     public String toString(){
         return "{" + x + ";" + y + "}";
     }
}
