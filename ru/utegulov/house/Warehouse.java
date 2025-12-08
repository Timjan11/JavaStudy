package ru.utegulov.house;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Warehouse<T> {

    private T obj;


    public static final Warehouse<?> NULL_WAREHOUSE = new Warehouse<>(null);


    public Warehouse(T obj){
        setValue(obj);
    }



    public Optional<T> getObj() {
        return Optional.ofNullable(obj);
    }

    public void setValue(T obj){
        if(obj == null){
            throw new NullPointerException();
        }
        this.obj = obj;
    }


    public static <T> Warehouse<T> nullableOf(T value) {
        if (value == null) {
            // Возвращаем единственный экземпляр хранилища с null
            return (Warehouse<T>) NULL_WAREHOUSE;
        }
        return new Warehouse<>(value);
    }

    public static <T> Warehouse<T> nullStorage() {
        return (Warehouse<T>) NULL_WAREHOUSE;
    }

    public T getValue() {
        return obj;
    }



    public boolean isNullStorage() {
        return this == NULL_WAREHOUSE;
    }

    @Override
    public String toString() {
        if (this == NULL_WAREHOUSE) {
            return "NullStorage{value=null}";
        }
        return "Storage{value=" + obj + "}";
    }
}

    //
//    private T obj;
//
//    public Warehouse(T obj){
//        this.obj = obj;
//    }
//
//    public T getObj() {
//        if(this.obj == null){
//            throw new NoSuchElementException();
//        }
//
//        return obj;
//    }
//
//    public T orElse(T other){
//        if(other == null){
//            return other;
//        }
//        return obj;
//    }


