package ru.utegulov.student;

public class Student {

    String name;
    int[] grades;



    public Student(String name, int... grades){
        this.name = name;
        if(grades == null){
            throw new NotCorrectGradeExeption("Оценок нет");
        }

        for(int i = 0; i< grades.length;i++){
            if(grades[i]<2||grades[i]>5){
                throw new NotCorrectGradeExeption("Не корректная оценка у студента "+name);
            }
        }

        this.grades = grades;
    }

    public int[] getGrades() {
        return grades;
    }

    public boolean addGrade(int grade) {
        int len= grades.length;
        grades[len] = grade;
        return true;
    }

    public double getAVG(){
        int sum = 0;
        for(int i = 0;i< grades.length;i++){
            sum+=grades[i];
        }
        double avg = sum / grades.length;
        return avg;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        if(this.getName() != ((Student) obj).getName() || this.getAVG() != ((Student) obj).getAVG()) return false;
        return  true;
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
