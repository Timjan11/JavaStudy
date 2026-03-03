package ru.utegulov.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CacheAnnotationUtils {
    public static boolean isCacheable(Class<?> clazz, String methodName){

        List<String>  errors = new ArrayList<>();

        Cache cacheAnnotation = clazz.getAnnotation(Cache.class);

        if (cacheAnnotation == null){
            errors.add("На классе нет аннотации Cache");
            return false;
        }
        if(methodName.isEmpty()||methodName==null){
            errors.add("Method name mustn't be empty");
            return false;
        }

        String[] cachedMethods = cacheAnnotation.value();

        if(cachedMethods.length == 0)return true;

        for(String method:cachedMethods){
            if(method.equals(methodName)) return true;
        }
        return false;
    }

    public static List<String> getCachedMethods(Class<?> clz){

        Cache cacheAnnotation = clz.getAnnotation(Cache.class);

        List<String> cachedMethods = Arrays.stream(cacheAnnotation.value()).toList();

        if(cachedMethods.isEmpty()){
            return getAllMethods(clz);
        }
        return cachedMethods;
    }

    public static List<String> getAllMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        List<String> methodNames = new ArrayList<>();

        for (Method method : methods) {
            methodNames.add(method.getName());
        }

        return methodNames;
    }

    public static void main(String[] args) {
        Cache cache = App.class.getAnnotation(Cache.class);

        System.out.println("App: "+ Arrays.toString(cache.value()));
    }

}


@Cache({"getName", "computeDate"})
class App{

    private String name;
    private int startDateInDays;
    private  int endDateInDays;

    public String getName() {
        return name;
    }

    public int computeDate(int startDateInDays, int endDateInDays){
        return endDateInDays-startDateInDays;
    }

}
