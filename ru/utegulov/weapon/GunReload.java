package ru.utegulov.weapon;

public class GunReload {

    private int bullets=0;
    private int maxBullets;

    public GunReload(int max){
        this.maxBullets = max;
    }

    public int getBullets(){
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public int getMaxBullets() {
        return maxBullets;
    }

    public void gunReloading(int x){
        if (x<=0){
            throw new IllegalArgumentException("Error! bullets must be >0");
        }
        if(x>getMaxBullets() || getBullets()+x>getMaxBullets()){
            setBullets(getMaxBullets());
        }
        bullets += x;
    }

    public void unreloading(){
        setBullets(0);
    }

    public boolean isFull(){
        if(getBullets()==0){
            return false;
        }else{
            return true;
        }
    }

    public void fire(){
        if(bullets>0){
            System.out.println("Бах!");
            bullets--;
        }
        else{ System.out.println("Клац!");}
    }

}
