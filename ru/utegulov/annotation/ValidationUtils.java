package ru.utegulov.annotation;

import ru.utegulov.animals.Cat;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

class ValidationUtils {

    public static void main(String[] args) {
        Cat cat = new Cat("qwf");
        Cat cat2 = new Cat("valid");
        ValidationUtils.validate(cat, cat2);
    }

    public static void validate(Object... objects) {
        List<String> allErrors = new ArrayList<>();

        for (Object obj : objects) {
            if (obj == null) continue;

            Class<?> clazz = obj.getClass();
            Validate validateAnnotation = clazz.getAnnotation(Validate.class);

            if (validateAnnotation == null) {
                continue;
            }

            Class<?>[] validatorClasses = validateAnnotation.value();
            List<String> errors = new ArrayList<>();

            for (Class<?> validatorClass : validatorClasses) {
                try {
                    Constructor<?> constructor = validatorClass.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    Object validator = constructor.newInstance();

                    if (validator instanceof Validator) {
                        Validator<?> typedValidator = (Validator<?>) validator;
                        boolean isValid = ((Validator<Object>) typedValidator).valid(obj);
                        if (!isValid) {
                            String error = typedValidator.getErrorMessage();
                            errors.add(error);
                        }
                    }
                } catch (Exception e) {
                    errors.add("Ошибка при создании " + validatorClass.getName());
                }
            }

            allErrors.addAll(errors);
        }

        if (!allErrors.isEmpty()) {
            throw new ValidationException(allErrors);
        }
    }
}

class ValidationException extends RuntimeException {
    private final List<String> errors;

    public ValidationException(List<String> errors) {
        super(errors.toString());
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}