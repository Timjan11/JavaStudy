package ru.utegulov.reflection;

import ru.utegulov.geometry.LineWithArgs;
import ru.utegulov.geometry.Point2D;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReflectionUtils {

    private ReflectionUtils() {}

    public static List<Field> fieldCollection(Class<?> clz){
        List<Field> fields = new ArrayList<>();
        Class<?> thisClass = clz;

        while(thisClass != null){
            Field[] declaredFields = thisClass.getDeclaredFields();
            fields.addAll(Arrays.asList(declaredFields));
            thisClass = thisClass.getSuperclass();
        }
        return fields;
    }


    public static void lineConnector(LineWithArgs<Point2D> firstLine, LineWithArgs<Point2D> secondLine) throws NoSuchFieldException, IllegalAccessException {
        Field end = LineWithArgs.class.getDeclaredField("end");
        end.setAccessible(true);
        Point2D endPoint  = (Point2D) end.get(firstLine);

        Field start = LineWithArgs.class.getDeclaredField("start");
        start.setAccessible(true);
        start.set(secondLine, endPoint);
        System.out.println("Первая линия - "+firstLine.toString()+"\n");
        System.out.println("Вторая линия - "+secondLine.toString()+"\n");

    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        Point2D point11 = new Point2D(10, 33);
        Point2D point12 = new Point2D(55, 67);
        Point2D point21 = new Point2D(14, 83);
        Point2D point22 = new Point2D(91, 34);

        LineWithArgs<Point2D> line1 = new LineWithArgs<>(point11, point12);
        LineWithArgs<Point2D> line2 = new LineWithArgs<>(point21, point22);

        ReflectionUtils.lineConnector(line1, line2);

    }

    static class ValidateException extends RuntimeException {
        public ValidateException(String message) {
            super(message);
        }
    }

}

