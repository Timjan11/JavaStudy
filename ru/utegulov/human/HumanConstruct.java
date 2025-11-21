package ru.utegulov.human;


public class HumanConstruct {
    String name;
    Name name2;
    String father;

    public HumanConstruct(String name){
        this.name = name;
    }
    public HumanConstruct(Name name2){
        this.name2 = name2;
    }
    public HumanConstruct(String name, String father){
        this.father = father;
        this.name = name;
    }
    public HumanConstruct(Name name2, String father){
        this.father = father;
        this.name2 = name2;
    }

    public String toString(){
        StringBuilder res = new StringBuilder();

        if(name!=null){
            res.append(name);
        }
        if(name2!= null){
            if(res.length()>0) res.append(" ");
            res.append(name2);
        }
        if(father!= null){
            if(res.length()>0) res.append(" - отец: ");
            res.append(father);
        }


        return res.toString();
    }

}
