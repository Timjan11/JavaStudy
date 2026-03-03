package ru.utegulov.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface Two {
    String first();
    int second();
}

@Two(first = "Test class", second = 101)
class AnnotationTwoTest{


    public static void main(String[] args) {
        AnnotationTwoTest object = new AnnotationTwoTest();
        Two two  = object.getClass().getAnnotation(Two.class);
        AnnotationTwoTest.isValid(object.getClass());
    }


    public static boolean isValid(Class<?> clazz){

        List<String> errors = new ArrayList<>();

        Two annotation  = clazz.getAnnotation(Two.class);

        if(annotation == null){
            errors.add("Нет аннотации Two на классе");
            System.out.println(errors.toString());
            return false;
        }

        if(annotation.first() == null || annotation.first().isEmpty()){
            System.out.println();
            errors.add("First mustn't be empty");
            System.out.println(errors.toString());
            return false;
        }

        if(annotation.second() <0){
            errors.add("Second must be positive");
            System.out.println(errors.toString());
            return false;
        }

        return true;
    }
}