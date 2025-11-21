package ru.utegulov.geometry;

import java.util.Arrays;

public class PolylineV2 {

    public Point1D[] points;
    private int len;

    public PolylineV2(){
        this.points = new Point1D[0];

    }

//    public PolylineV2(Point1D[] points){
//        if(points == null){
//            this.points = new Point1D[0];  // если передано ничто то делаем пустой массив
//        }
//        else{
//            this.points = Arrays.copyOf(points, points.length); // иначе создаем копию массива
//        }
//    }

    public PolylineV2(PointWithArgs[] points) {
    }

//    public String toString(){
////        if(points.length == 0){
////            return "Line: {}";  // если нет точек то создаю пустую линию
////        }
//         StringBuilder res = new StringBuilder("Line {");
//        for(int i = 0; i<points.length; i++){
//            res.append(points[i]);  // добавил тоочку
//            if(i< points.length-1){
//                res.append(", "); // запятые
//            }
//        }
//        res.append('}'); // Добавляем закрывающую скобку в конец
//        return res.toString();
//
//    }

}
