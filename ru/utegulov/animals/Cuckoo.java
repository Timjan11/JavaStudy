package ru.utegulov.animals;
import java.util.Random;

public class Cuckoo extends Birds{
    private final String name = "Кукушка";
    private Random random = new Random();


    public String getName() {
        return name;
    }

    public void sing(){
        final int randomInt = random.nextInt(10);
        for(int i = 0; i<randomInt;i++){
            System.out.println("ку-ку");
        }
    }
}
