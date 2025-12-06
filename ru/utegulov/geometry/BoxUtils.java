package ru.utegulov.geometry;


import ru.utegulov.geometry.*;

import java.util.List;
import java.util.Random;

import static java.lang.Double.NEGATIVE_INFINITY;

public class BoxUtils {

    public  double findMaxValue(List<Box<? extends Number>> boxes){
        double maxValue = NEGATIVE_INFINITY;
        if(boxes == null){
            throw new NullPointerException("массив коробок пуст");
        }
        boolean flag = false;

        for(Box<? extends Number> box: boxes){

            if(box!=null && box.isFull()){
                Number number = box.getObject();
                if(number != null){
                    double value = number.doubleValue();
                    if(value > maxValue){
                        maxValue = value;
                        flag = true;
                    }
                }
            }
        }
        if(!flag){
            throw new NotFoundMaxValueException("Не найдено максимального значения!");
        }
        return maxValue;
    }



    public void pushPoint3DInBox(Box<? extends Point> box){

        Random random = new Random();
        int randomX = random.nextInt(100);
        int randomY = random.nextInt(100);
        int randomZ = random.nextInt(100);
        Point3D point3D = new Point3D(randomX, randomY, randomZ);


        if(box.isFull()){
            throw new NotEmptyBoxException("В коробке уже есть значение!");
        }else{

            //решил через сырой тип rawType это значит, что компилятор не проверяет тип передавемого значения
            Box rawBox  = (Box) box;
            rawBox.push(point3D);
        }

    }

}
