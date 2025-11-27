package ru.utegulov.geometry;

import java.util.NoSuchElementException;

public final class Warehouse<T> {

    private T obj;

    public Warehouse(T obj){
        this.obj = obj;
    }

    public T getObj() {
        if(this.obj == null){
            throw new NoSuchElementException();
        }

        return obj;
    }

    public T orElse(T other){
        if(other == null){
            return other;
        }
        return obj;
    }

}
