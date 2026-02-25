package ru.utegulov.reflection;

import java.io.*;
import java.util.*;

public class ObjectWriter {
    private String filename;

    public ObjectWriter(String filename) {
        this.filename = filename;
    }

    public void write(List<?> objects) {
        try (FileWriter fw = new FileWriter(new File(filename))) {
            for (Object obj : objects) {

                String representation = objectToString(obj);
                fw.write(representation + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }

    private String objectToString(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj.getClass().getName());

        for (java.lang.reflect.Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                sb.append("_").append(value);
            } catch (IllegalAccessException e) {
                sb.append("_null");
            }
        }
        return sb.toString();
    }
}

class ObjectReader<T> {
    private String filename;
    private Class<T> type;

    public ObjectReader(String filename, Class<T> type) {
        this.filename = filename;
        this.type = type;
    }

    public List<T> read() {
        List<T> result = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                T obj = stringToObject(line);
                if (obj != null) {
                    result.add(obj);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    private T stringToObject(String line) {
        try {
            String[] parts = line.split("_");
            String className = parts[0];

            Class<?> clazz = Class.forName(className);

            Object instance = clazz.newInstance();

            java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                if (i + 1 < parts.length) {
                    fields[i].setAccessible(true);
                    fields[i].set(instance, parts[i + 1]);
                }
            }
            return (T) instance;

        } catch (Exception e) {
            System.out.println("Ошибка создания объекта: " + e.getMessage());
            return null;
        }
    }
}

class Person {
    public String name;
    public String city;

    public Person() {}

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', city='" + city + "'}";
    }
}

class Product {
    public String title;
    public String price;

    public Product() {}

    public Product(String title, String price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{title='" + title + "', price='" + price + "'}";
    }
}



