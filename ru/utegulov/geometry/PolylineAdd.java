package ru.utegulov.geometry;

import java.util.Arrays;

public class PolylineAdd {


    public Point[] points;

    public PolylineAdd(){
        this.points = new Point[0];

    }

    public Point[] getPoints() {
        return points;
    }

    public int getLen(Point[] points){
        int len = points.length;
        return len;
    }

    public boolean pointIsEquals(Point[] points1){

        int len = getLen(points);
        int len2 = points1.length;
        if(len != len2) return false;
        boolean flag= true;
        while(flag){
            int i = 0;
            if(i>len) break;
            if(points[i] == points1[i]) flag = true;
            else {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        PolylineAdd poly = (PolylineAdd) obj;
        if((this.getLength() != poly.getLength()))return false;
        if(!(pointIsEquals(poly.getPoints()))) return false;
        return true;
    }

    public PolylineAdd(Point[] points){
        if(points == null){
            this.points = new Point[0];  // если передано ничто то делаем пустой массив
        }
        else{
            this.points = Arrays.copyOf(points, points.length); // иначе создаем копию массива
        }
    }

    public PolylineAdd addNewPoints(Point[] newPoints){
        if(newPoints == null || newPoints.length ==0){
            return new PolylineAdd(this.points);
        }
        Point[] points = new Point[this.points.length+newPoints.length];
        System.arraycopy(this.points, 0, points, 0, this.points.length);
        System.arraycopy(newPoints, 0, points, this.points.length, newPoints.length);
        return new PolylineAdd(points);
    }

    public PolylineAdd addPoints(Point ... newPoints){
        return addNewPoints(newPoints);
    }

    public double getLength() {
        if (points.length < 2) {
            return 0.0;
        }

        double totalLength = 0.0;
        for (int i = 0; i < points.length - 1; i++) {
            totalLength += points[i].distanceTo(points[i + 1]);
        }
        return totalLength;
    }

    public String toString(){
        if(points.length == 0){
            return "Line: {}";  // если нет точек то создаю пустую линию
        }
        StringBuilder res = new StringBuilder("Line {");
        for(int i = 0; i<points.length; i++){
            res.append(points[i]);  // добавил тоочку
            if(i< points.length-1){
                res.append(", "); // запятые
            }
        }
        res.append('}'); // Добавляем закрывающую скобку в конец
        return res.toString();

    }

}



