package ru.utegulov.other;

public class Kick implements Attack{
    private Karateka karateka;

    public Kick(Karateka karateka){
        this.karateka = karateka;
    }

    @Override
    public void perform() {
        System.out.println(karateka.getName()+": бац!");
    }
}
