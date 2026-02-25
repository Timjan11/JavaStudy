package ru.utegulov.reflection;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Validator {

    public static void validate(Object obj, Class<?> testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            if (isTest(method)){
                try {
                    method.setAccessible(true);
                    boolean result = (boolean) method.invoke(null, obj);

                    if (!result) {
                        throw new ReflectionUtils.ValidateException(
                                "ошибка в " + method.getName() +
                                        ": объект " + obj + " не прошел проверку"
                        );
                    }

                } catch (Exception e) {
                    throw new ReflectionUtils.ValidateException(
                            "ошибка при выполнении " + method.getName() +
                                    ": " + e.getCause().getMessage()
                    );
                }
            }
        }
    }
    private static boolean isTest(Method method) {
        return Modifier.isStatic(method.getModifiers()) &&
                method.getReturnType() == boolean.class &&
                method.getParameterCount() == 1;
    }
}


class HumanTests {

    public static boolean testAge(Human human) {
        return human.getAge() >= 1 && human.getAge() <= 200;
    }


    public static boolean testName(Human human) {
        String name = human.getName();
        return name != null && !name.trim().isEmpty();
    }

    public static boolean testPositiveAge(Human human) {
        return human.getAge() > 0;
    }
}

class Human {
    private int age;
    private String name;

    public Human(int age) {
        this.age = age;
        this.name = "Артемка";
    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Human{age=" + age + ", name='" + name + "'}";
    }
}
