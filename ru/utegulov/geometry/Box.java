package ru.utegulov.geometry;

public class Box<T> {
    private T ob;


    public T takeOb(){
        T res = this.ob;
        this.ob = null;
        return res;
    }

    public void push(T newOb){
        if(this.ob == null) throw new NotEmptyBoxException("Box is not empty!");
        this.ob = newOb;
    }

    public boolean isFull(){
        if(this.ob == null) return false;
        return true;
    }

    public T getObject(){
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    @Override
    public String toString() {
        if(!(isFull())) return "Box is Empty";
        return "Box have a value: "+ ob;
    }
}
