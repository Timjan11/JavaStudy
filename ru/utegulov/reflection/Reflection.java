package ru.utegulov.reflection;

public class Reflection {

    public static void main(String[] args) {
        A a = new A();
        Class clz = a.getClass();
        System.out.println(clz.isInterface());
        System.out.println(clz.getSuperclass());


    }

}
