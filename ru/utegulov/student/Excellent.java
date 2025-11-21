package ru.utegulov.student;
public class Excellent {

    String name;
    int[] grades;

    public Excellent(String name, int... grades){
        this.name = name;
        this.grades = grades;
    }

    public double mean(){
        if(grades.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i =0; i< grades.length;i++){
            sum+= grades[i];
        }
        int res = sum/ grades.length;
        return res;
    }

    public boolean isExcelent(){
        if(grades.length == 0){
            return false;
        }
        if(grades.length > 0 && mean() == 5){
            return true;
        }
        return false;
    }


    public String toString() {
        if (grades == null || grades.length == 0){
            return "Студент " + name + " без оценок";
        }
        else{
            StringBuilder res = new StringBuilder("Студент " + name + " с оценками: ");
            for(int i = 0; i< grades.length;i++){
                res.append(grades[i]);
                if(i< grades.length-1){
                    res.append(",");
                }
            }
            return res.toString();
        }
    }

}
