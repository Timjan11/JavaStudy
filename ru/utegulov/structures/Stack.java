package ru.utegulov.structures;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private List<T> stack = new ArrayList<>();


    public boolean isEmpty(){
        if(stack.size() == 0) return true;
        if(stack.size() <0) throw new IllegalArgumentException("Размер стэка не может быть отрицательным");
        return false;
    }

    public void push(T value){
        stack.add(value);
    }

    public T pop(){
        if(isEmpty()) throw new IllegalStateException("Стэк пуст");
        return stack.remove(stack.size()-1);
    }

    public T peek(){
        return stack.get(stack.size()-1);
    }

}
