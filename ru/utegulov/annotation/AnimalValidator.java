package ru.utegulov.annotation;

import ru.utegulov.animals.Cat;



public class AnimalValidator implements Validator<Cat>{


    @Override
    public boolean valid(Cat cat) {
        String name  = cat.getName();
        return name != null && !name.isEmpty();
    }


    @Override
    public String getErrorMessage() {
        return "Name must be not empty!";
    }


}
