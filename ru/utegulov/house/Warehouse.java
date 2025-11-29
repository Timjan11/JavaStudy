package ru.utegulov.house;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Warehouse<T> {

    private T obj;

    public Warehouse(T obj){
        this.obj = obj;
    }

    public Optional<T> getObj() {
        return Optional.ofNullable(obj);
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

}
