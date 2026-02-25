package ru.utegulov.streams;





public class Funs {
    public static int action(Action action, int ...x){
        int res=x[0];
        for(int i=1;i<x.length;i++) res = action.act(res, x[i]);
        return res;
    }
}
