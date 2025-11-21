package ru.utegulov.animals;

public class Cat {
    String name;


    public Cat(String name){
        this.name = name;
    }


    public String toString() {
        return "cat: "+ name;
    }

    public void sayMeow(){
        System.out.println(name + ": Мяу!");
    }

    public void sayMeowNcnt(int n){
        StringBuilder str = new StringBuilder(name+": ");
        for(int i =0;i<n;i++){
            str.append("мяу");
            if(i<n-1){
                str.append("-");
            }
        }
        System.out.println(str);
    }
}
