package ru.utegulov.genericMethods;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static <T, P> List<P> map(List<T> list, Function<T, P> function){
        if(list == null || function == null){
            throw new IllegalArgumentException("Параметры не могут быть null");
        }
        List<P> res = new ArrayList<>();

        for(T item:list){
            P transformed = function.apply(item);
            res.add(transformed);
        }
        return res;
    }

}
