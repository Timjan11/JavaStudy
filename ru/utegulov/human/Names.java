package ru.utegulov.human;

public class Names {

    String lastname;
    String firstname;
    String patronymic;

    public Names(String lastname){
        this.lastname= lastname;
    }
    public Names(String lastname, String firstname){
        this.lastname = lastname;
        this.firstname = firstname;

    }

    public Names(String lastname, String firstname, String patronymic){
        this.lastname = lastname;
        this.firstname = firstname;
        this.patronymic = patronymic;
    }



    public String toString(){
        StringBuilder res = new StringBuilder();
         if(lastname!= null){
             res.append(lastname);
         }

         if(firstname!= null){
             if(res.length()>0) res.append(" ");
             res.append(firstname);
         }

         if(patronymic!=null){
             if(res.length()>0) res.append(" ");
             res.append(patronymic);
         }

         return res.toString();
    }

}
