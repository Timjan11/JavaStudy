package ru.utegulov.annotationUtils;


import ru.utegulov.annotation.Invoke;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Collector {
    public static Map<String, Object> collect(Class<?>[] clazzes){

        Map<String, Object> mapOfCollectedMethods = new HashMap<>();
        for(Class<?> clz: clazzes){
            Method[] currentClassMethods = clz.getDeclaredMethods();
            for(Method method:currentClassMethods){

                try{

                    if(method.getParameters() != null){
                        continue;
                    }
                    if(method.getReturnType()!=void.class){
                        continue;
                    }
                    if (method.isAnnotationPresent(Invoke.class)){
                        continue;
                    }

                    method.setAccessible(true);

                    Object obj = clz.getDeclaredConstructor().newInstance();

                    Object value = method.invoke(obj);
                    mapOfCollectedMethods.put(method.getName(), value);

                } catch (Exception e){
                    throw new RuntimeException("Error for invoke "+ method.getName());
                }


            }
        }
return mapOfCollectedMethods;
    }

}
