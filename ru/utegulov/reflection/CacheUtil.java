package ru.utegulov.reflection;
import java.lang.reflect.*;
import java.util.*;

class CacheEntry {
    Object result;
    int objectHash;
    long lastAccess;

    CacheEntry(Object result, int objectHash) {
        this.result = result;
        this.objectHash = objectHash;
        this.lastAccess = System.currentTimeMillis();
    }
}

public class CacheUtil {

    public static <T> T cache(T object) {
        if (object == null) return null;

        return (T) Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                getAllInterfaces(object.getClass()),
                new CacheHandler(object)
        );
    }

    private static Class<?>[] getAllInterfaces(Class<?> clazz) {
        Set<Class<?>> interfaces = new HashSet<>();
        while (clazz != null) {
            interfaces.addAll(Arrays.asList(clazz.getInterfaces()));
            clazz = clazz.getSuperclass();
        }
        return interfaces.toArray(new Class<?>[0]);
    }

    static class CacheHandler implements InvocationHandler {
        private final Object target;
        private final Map<String, CacheEntry> cache = new HashMap<>();
        private int lastStateHash;

        CacheHandler(Object target) {
            this.target = target;
            this.lastStateHash = computeStateHash();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (args != null && args.length > 0) {
                return method.invoke(target, args);
            }

            String methodName = method.getName();
            int currentHash = computeStateHash();

            boolean objectChanged = (currentHash != lastStateHash);

            if (objectChanged) {
                lastStateHash = currentHash;
            }

            CacheEntry entry = cache.get(methodName);

            if (entry == null || objectChanged) {
                System.out.println("Реальный вызов " + methodName);
                Object result = method.invoke(target, args);
                cache.put(methodName, new CacheEntry(result, currentHash));
                return result;
            }

            System.out.println("Кэшированный результат для " + methodName);
            return entry.result;
        }

        private int computeStateHash() {
            try {
                int hash = 0;
                for (Field field : target.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value = field.get(target);
                    hash += (value != null ? value.hashCode() : 0);
                }
                return hash;
            } catch (Exception e) {
                return System.identityHashCode(target);
            }
        }
    }
}

class A2 {
    public String stringField;
    private int secret = 42;

    public A2(String str) {
        this.stringField = str;
    }

    public int cacheTest() {
        System.out.println("original method");
        return secret;
    }

    public String getString() {
        return stringField;
    }

    public int add(int x) {
        return secret + x;
    }
}

interface Testable {
    int getValue();
    String getMessage();
}

class B1 implements Testable {
    public int counter = 0;

    @Override
    public int getValue() {
        counter++;
        System.out.println("B.getValue() вызван");
        return counter;
    }

    @Override
    public String getMessage() {
        System.out.println("B.getMessage() вызван");
        return "Message #" + counter;
    }
}
