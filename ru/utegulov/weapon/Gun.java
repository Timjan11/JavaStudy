package ru.utegulov.weapon;


public class Gun {

    int bullets;

    Gun(){
        bullets = 5;
    }

    public Gun(int x){
        bullets = x;
    }

    public void fire(){
        if(bullets>0){
            System.out.println("Бах!");
            bullets--;
        }
        else{ System.out.println("Клац!");}
    }


}
