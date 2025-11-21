package ru.utegulov.human;

public class NotEmptyNames {


    private final String lastname;
    private final String firstname;
    private final String patronymic;

    public NotEmptyNames(String lastname) {
        this(lastname, null, null);
    }

    public NotEmptyNames(String lastname, String firstname) {
        this(lastname, firstname, null);
    }

    public NotEmptyNames(String lastname, String firstname, String patronymic) {
        if (lastname == null || lastname.trim().isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой!");
        }
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
