package ru.utegulov.reflection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoopark {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        List<Moo> zoo = new ArrayList<>();
        while(true){
            System.out.println("1. Добавить животное");
            System.out.println("2. Пройтись по зоопарку");
            System.out.println("3. Выход");
            Scanner scanner =  new Scanner(System.in);
            int choose =scanner.nextInt();
            if(choose == 3) System.exit(0);
            else if(choose == 2){
                for (Moo m:zoo) m.moo();
            }else if(choose == 1){
                addMoo(zoo);
            }
        }


    }
    public static void addMoo(List<Moo> zoo) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Class cl = List.class; //Литерал класса
        Class cl3 = Class.forName("ru.utegulov.reflection."+name);
//        System.out.println(cl3.isInterface());
        zoo.add((Moo)cl3.newInstance());

    }


}

class Cow implements Moo{
    public void moo(){
        System.out.println("MOO!");
    };
}

class Cat implements Moo{
    @Override
    public void moo() {
        System.out.println("MEOW!");
    }
}
