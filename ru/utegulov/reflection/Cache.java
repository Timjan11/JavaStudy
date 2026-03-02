//package ru.utegulov.reflection;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.util.Map;
//
//public class Cache {
//    public static <T> T cache(T object){
//        if(object == null){
//            return null;
//        }
//
//        Class<?> clz  = object.getClass();
//        CacheHandler hadler = new CacheHandler(object);
//
//        if(clz.getInterfaces().length>0){
//            return (T) Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), handler);
//
//        }else{
//            return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class<?>[]{clz}, hadler);
//        }
//
//    }
//
//    static class CacheHandler implements InvocationHandler{
//
//
//        private final Object object;
//        private final Map<String, Object> cache;
//        private final Object snapshot;
//
//        public CacheHandler(Object object, Map<String, Object> cache, Object snapshot) {
//            this.object = object;
//            this.cache = cache;
//            this.snapshot = snapshot;
//        }
//
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            if(args != null && args.length>0){
//                return method.invoke(object, args);
//            }
//        }
//    }
//
//}
