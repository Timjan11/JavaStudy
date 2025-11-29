package ru.utegulov.animals;
import java.util.Random;

public class Parrot extends Birds{
    private final String name = "Попугай";
    private String singingText;

    public Parrot(String singingText){
        this.singingText = singingText;
    }

    public String getName() {
        return name;
    }


    public void sing(){
        int len = singingText.length();
        Random random = new Random();
        int randomInt = random.nextInt(len);
        for(int i = 0; i< randomInt;i++){
            System.out.println(singingText.charAt(i));
        }
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
