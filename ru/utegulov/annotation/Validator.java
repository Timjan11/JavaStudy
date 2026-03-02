package ru.utegulov.annotation;

public interface Validator<T> {
    boolean valid(T object);
    String getErrorMessage();


}
