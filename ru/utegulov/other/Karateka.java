package ru.utegulov.other;

import java.util.ArrayList;
import java.util.List;


public class Karateka {
    private String name;

    public String getName() {
        return name;
    }

    public Karateka(String name) {
        this.name = name;
    }

    public void performAttack(Attack attack){
        attack.perform();
    }
}
