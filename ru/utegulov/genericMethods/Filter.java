package ru.utegulov.genericMethods;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static<T, P> List<T> map(List<T> list, FunctionIf<T> fun){

        if(list == null || fun == null){
            throw new IllegalArgumentException("List or FunctionIf is null");
        }

        List<T> listRes = new ArrayList<>();
        for(T t:list){
            if(fun.test(t)){
                listRes.add(t);
            }

        }
        return listRes;
    }


}
