package ru.utegulov.genericMethods;

import java.util.ArrayList;
import java.util.List;

public class Join {

    public static <T> T join(List<T> list,T init, FunctionJoin<T> fun){

        if(list == null || fun ==null){
            throw new IllegalArgumentException("list or fun is null");
        }

        T res = init;
        for(T t:list){
            res= fun.join(res, t);
        }
        return res;

    }


}
