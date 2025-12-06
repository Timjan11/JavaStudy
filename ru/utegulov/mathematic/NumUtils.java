package ru.utegulov.mathematic;

import java.util.List;
import java.util.Random;

public class NumUtils {

    private static Random RANDOM = new Random();

    public void fillList(List<? super Integer> list){
        if(list == null){
            throw new IllegalArgumentException("Пустой список");
        }
        list.clear();
        for(int i = 0; i<100;i++){
            int randomInt = 1+ RANDOM.nextInt(100);
            list.add(randomInt);
        }
    }


}
