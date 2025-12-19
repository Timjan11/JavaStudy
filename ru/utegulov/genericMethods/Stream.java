package ru.utegulov.genericMethods;

import java.util.ArrayList;
import java.util.List;

public class Stream<T> {
    private final List<T> data;

    public Stream (List<T> source){
        this.data = new ArrayList<>(source);
    }

    public static <T> Stream<T> of(List<T> source){
        return new Stream<>(source);
    }

    //map
    public <R> Stream<R> map(Function<T, R> map){
        List<R> res = new ArrayList<>();
        for(T v : data){
            res.add(map.apply(v));
        }
        return new Stream<>(res);
    }


    public Stream<T> filter(Function<T, Boolean> predicate) {
        List<T> res = new ArrayList<>();
        for (T v : data) {
            if (predicate.apply(v)) {
                res.add(v);
            }
        }
        return new Stream<>(res);
    }


    public T reduce(T identity, Function2<T, T, T> accumulator) {
        T result = identity;
        for (T v : data) {
            result = accumulator.apply(result, v);
        }
        return result;
    }

    // collect
    public <R> R collect(ResultCollection<R> collectionFactory,
                         Function2<R, T, Void> adder) {
        R result = collectionFactory.create();
        for (T v : data) {
            adder.apply(result, v);
        }
        return result;
    }


    @FunctionalInterface
    public interface Function2<A, B, R> {
        R apply(A a, B b);
    }

    public List<T> toList() {
        return new ArrayList<>(data);
    }

}
