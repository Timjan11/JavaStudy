
package ru.utegulov.animals;

public class Sparrow extends Birds {
    private final String name = "Воробей";

    public String getName() {
        return name;
    }

    public void sing(){
        System.out.println("Чирик, ёпт");
    }
}
