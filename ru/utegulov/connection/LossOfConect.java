package ru.utegulov.connection;

public class LossOfConect extends Exception {

    public LossOfConect (){
        super();
    }

    public LossOfConect(String message) {
        super(message);
    }

    public LossOfConect(Throwable cause) {
        super(cause);
    }

    public LossOfConect(String message, Throwable cause) {
        super(message, cause);
    }
}
