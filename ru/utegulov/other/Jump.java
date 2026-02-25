package ru.utegulov.other;

public class Jump implements Attack{
    private Karateka karateka;

    public Jump(Karateka karateka){
        this.karateka = karateka;
    }


    @Override
    public void perform() {
        System.out.println(karateka.getName()+": вжух!");
    }
}
