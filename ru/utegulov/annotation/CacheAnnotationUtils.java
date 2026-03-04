package ru.utegulov.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CacheAnnotationUtils {


    public static List<Object> cache(Object...objects){

        List<Object> res = new ArrayList<>();

        for(Object obj: objects){
            if(obj==null)continue;
            Class clz = obj.getClass();

            List<String> cached = getCachedMethods(clz);
            res.add(cached);
        }
return res;
    }



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

        List<String> allMethods = getAllMethods(cacheAnnotation.getClass());
        List<String> cachedMethods = new ArrayList<>();
        if(allMethods.isEmpty()){
            return null;
        }

        for (String method: allMethods){
            if(isCacheable(clz, method)){
                cachedMethods.add(method);
            }
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



}


@Cache({"getName", "computeDate"})
class App{

    private String name = "Vanya";
    private int startDateInDays = 12;
    private  int endDateInDays = 18;

    public String getName() {
        return name;
    }

    public int computeDate(int startDateInDays, int endDateInDays){
        return endDateInDays-startDateInDays;
    }

}
