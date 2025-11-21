package ru.utegulov.student;
public class DiapasoneOfGrades {

    String name;
    int[] grades;



    public DiapasoneOfGrades(String name, int... grades){
        for(int i = 0; i< grades.length;i++){
            if(grades[i]>=5 && grades[i] <= 2){
                throw new IllegalArgumentException("Grades must be in {2-5}!");
            }
        }
        this.name = name;
        this.grades = grades;
    }

    public int[] getGrades() {
        return grades;
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
