package ru.utegulov.genericMethods;

@FunctionalInterface
public interface FunctionIf<T> {
    boolean test(T t);
}
