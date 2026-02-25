package ru.utegulov.other;

import java.util.ArrayList;
import java.util.List;

public class CombinationAttack implements Attack{
    private List<Attack> attacks = new ArrayList<>();


    public void addAttack(Attack attack){
        attacks.add(attack);
    }

    public void removeAttack(Attack attack){
        attacks.remove(attack);
    }

    public void clearAttack(){
        attacks.clear();
    }


   @Override
    public void perform() {
        for(Attack attack:attacks){
            attack.perform();
        }
    }
}
