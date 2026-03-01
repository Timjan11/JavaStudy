package ru.utegulov.reflection;

import ru.utegulov.annotation.Default;

import java.lang.reflect.Field;
import java.util.*;

class Entity {
    @Override
    public String toString() {

        Field[] allFields = getAllFields();
        StringBuilder strRes = new StringBuilder();
        strRes.append(getClass().getSimpleName());
        strRes.append("{");
        boolean isFirst = true;

        for(Field field:allFields){
            field.setAccessible(true);
            if(!isFirst){
                strRes.append(", ");
            }
            isFirst = false;
            strRes.append(field.getName());
            strRes.append("=");
            try {
                Object value = field.get(this);
                strRes.append(value);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        strRes.append("}\n");
        return strRes.toString();
    }


    private Field[] getAllFields(){
        Map<String, Field> fieldMap = new HashMap<>();
        Class thisClass = getClass();
        while(thisClass != null){
            Field[] declaredFields  = thisClass.getDeclaredFields();
            for(Field field:declaredFields){
                fieldMap.put(field.getName(), field);
            }
            thisClass= thisClass.getSuperclass();
        }
        return fieldMap.values().toArray(new Field[0]);
    }


}
class A1 extends Entity {
    String name = "hello";
    int x  = 42;
}

class B extends A1 {
    String text = "B";
}



public class Test {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b);
    }
}
