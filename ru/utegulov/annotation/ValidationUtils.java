package ru.utegulov.annotation;

import ru.utegulov.animals.Cat;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;



class ValidationUtils {

    public static void main(String[] args) {
        Cat cat = new Cat("qwf");
        ValidationUtils.validate(cat);

    }




    public static void validate(Object obj){
        Class<?> clazz = obj.getClass();

        Validate validateAnnotation = clazz.getAnnotation(Validate.class); //пытаюсь получить аннотаци. Валидэйт из класса (вернет null или аннотцию)
        if(validateAnnotation == null){
            return;
        }

        Class<?>[] validatorClasses  = validateAnnotation.value(); // полкчаю массив классов валидаторов
        List<String> errors = new ArrayList<>();

        for (Class<?> validatorClass: validatorClasses){
            try{

                Constructor<?> constructor = validatorClass.getDeclaredConstructor();
                constructor.setAccessible(true);
                Object validator = constructor.newInstance();

                if(validator instanceof Validator){
                    Validator<?> typedValidator = (Validator<?>) validator;
                    boolean isValid = ((Validator<Object>) typedValidator).valid(obj);
                    if(!isValid){
                        String error = ((Validator<?>) validator).getErrorMessage();
                        errors.add(error);
                    }
                }
            }catch (Exception e){
                errors.add("Ошибка при создании "+validatorClass.getName());
            }

        }
        if(!errors.isEmpty()){
            throw new ValidationException(errors);
        }

    }

}

class ValidationException extends RuntimeException{
    private final List<String> errors;

    public ValidationException(List<String> errors){
        super(errors.toString());
        this.errors= errors;
    }


    public List<String> getErrors() {
        return errors;
    }
}