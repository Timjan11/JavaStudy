package ru.utegulov.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Entity {

    @Override
    public String toString() {

        List<Field> allFields = getAllFields(this.getClass());
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getSimpleName());
        result.append(" {");


        for (Field field : allFields) {


            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (value == null) {
                continue;
            }
            result.append("\n");


            result.append(field.getName());
            result.append(" = ");
            result.append(value);

        }

        result.append("\n}");
        return result.toString();
    }

    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        Class<?> currentClass = clazz;

        while (currentClass != null && currentClass != Object.class) {
            Field[] declaredFields = currentClass.getDeclaredFields();
            for (Field field : declaredFields) {
                fields.add(field);
            }
            currentClass = currentClass.getSuperclass();
        }

        return fields;
    }
}

class A1 extends Entity {
    String s = "hello";
    int x = 42;
}

class B extends A1 {
    String text = "B";
}

class Test {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b);

    }
}
