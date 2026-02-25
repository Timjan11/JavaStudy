package ru.utegulov.other;

import ru.utegulov.geometry.Point;

import java.util.ArrayList;
import java.util.List;


interface Converter<T>{
    T convert(String value);
}

class StrConvert implements Converter<String>{
    @Override
    public String convert(String value) {
        return value;
    }
}

class IntConvert implements Converter<Integer>{
    @Override
    public Integer convert(String value) {
        try {
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            return 0;
        }
    }
}

class PointConvert implements Converter<Point>{
    @Override
    public Point convert(String value) {
        try{
            String[] str = value.split(",");
            int x = Integer.parseInt(str[0].trim());
            int y = Integer.parseInt(str[1].trim());
            return new Point(x, y);
        }catch (Exception e){
            return new Point(0, 0);
        }
    }
}

public class DataBase {

    public List<String> str = List.of("wiefi", "pwejf", "uwyefdv", "ierbg", "d", "wef", "ewf", "wek", "56b", "fewvx");



}
