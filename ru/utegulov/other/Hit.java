package ru.utegulov.other;

public class Hit implements Attack{

    private Karateka karateka;

    public Hit(Karateka karateka){
        this.karateka = karateka;
    }

    @Override
    public void perform() {
        System.out.println(karateka.getName()+": кия!");
    }
}
