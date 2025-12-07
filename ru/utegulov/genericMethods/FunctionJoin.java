package ru.utegulov.genericMethods;

import java.util.List;

@FunctionalInterface
public interface FunctionJoin<T> {

    T join(T t, T t2);

}
