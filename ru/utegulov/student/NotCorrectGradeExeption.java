package ru.utegulov.student;

public class NotCorrectGradeExeption extends RuntimeException {
    public NotCorrectGradeExeption(){
        super();
    }


    public NotCorrectGradeExeption(String message) {
        super(message);
    }
}
