package ru.utegulov.reflection;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ValidateException extends RuntimeException{
        public ValidateException(String message){
            super(message);
        }
}


public class Validator {

    public static void main(String[] args) {
        Human human1 = new Human("Oleg", 13, 167);
        Validator.validate(human1, HumanTests.class);

    }




    private static final Map<Integer, String> MAP_OF_ERRORS = Map.of(
            0, "All right!",
            1, "Name is Empty!",
            2, "First character is not in upper case!",
            3, "Not allowed character in Name (!, @, &, $, * ...)",
            4, "Not correct age",
            5, "Not correct weight"
    );
    public static void validate(Object obj, Class<?> clz) {
        List<String> errors = new ArrayList<>();
        Method[] methods = clz.getDeclaredMethods();
        for(Method m: methods){
            try{
                m.setAccessible(true);
                int errorCode = (int) m.invoke(null, obj);
                if(errorCode!=0){
                    StringBuilder stringBuilder = new StringBuilder("ошибка: "+MAP_OF_ERRORS.get(errorCode));
                    errors.add(String.valueOf(stringBuilder));
                }

            } catch (Exception e) {
                // Безопасное получение сообщения об ошибке
                String errorDetails;
                if (e.getCause() != null) {
                    errorDetails = e.getCause().getMessage();
                } else {
                    errorDetails = e.getMessage();
                }

                String errorMessage = String.format("Ошибка при выполнении %s: %s",
                        m.getName(),
                        errorDetails != null ? errorDetails : "Неизвестная ошибка");
                errors.add(errorMessage);

                // Для отладки можно раскомментировать:
                // e.printStackTrace();
            }

        }

        if (!errors.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String error : errors) {
                sb.append(error).append("\n");
            }
            throw new ValidateException(sb.toString().trim());
        }

    }

}



class HumanTests {


    private static boolean isValidArrOfChars(String name){
        if(name==null)return false;
        char[] chars = name.toCharArray();
        for(int i = 0; i<chars.length;i++){
            if(chars[i]<65 || (chars[i] > 90 && chars[i]<97) || chars[i]>122){
                return false;
            }
        }
        return true;
    }

    public static int NameTest(Human human){
        String name = human.getName();
        if(name.isEmpty()){
            return 1;
        } else if (name.toCharArray()[0] < 'A' || name.toCharArray()[0]>'Z') {
            return 2;
        } else if (!isValidArrOfChars(name)) {
            return 3;
        }
        return 0;
    }

    public static int ageTest(Human human){
        int age = human.getAge();
        if(age<0 || age > 150){
            return 4;
        }
        return 0;
    }
    public static int heightTest(Human human){
        int height = human.getHeight();
        if(height<0 || height >300){
            return 5;
        }
        return 0;
    }




}

class Human {
    private String name;
    private int age;
    private int height;

    public Human(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}

