package ru.utegulov.genericMethods;

import java.util.Collection;

public class Collect {

    public static <T, P extends Collection> P returnPFun(Collection<T> origin, ResultCollection<P> result, FunctionAdd<P, T> fun){
        if(origin == null || result == null || fun == null){
            throw new IllegalArgumentException("Value == null");
        }

        P res = result.create();
        for(T t:origin){
            fun.add(res, t);
        }
        return res;

    }

}
