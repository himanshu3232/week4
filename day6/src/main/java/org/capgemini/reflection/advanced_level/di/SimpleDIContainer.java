package org.capgemini.reflection.advanced_level.di;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class SimpleDIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    // Registers an instance of a class
    public <T> void register(Class<T> clazz, T instance) {
        instances.put(clazz, instance);
    }

    // Resolves the dependency for the given class
    public <T> T resolve(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T instance = (T) instances.get(clazz);

        // If instance is not already created, create and inject dependencies
        if (instance == null) {
            // Create a new instance of the class
            instance = clazz.newInstance();

            // Scan fields and inject dependencies
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    // Make the field accessible (even if it's private)
                    field.setAccessible(true);

                    // Resolve the dependency for the field and inject it
                    field.set(instance, resolve(field.getType()));
                }
            }

            // Register the created instance for future use
            register(clazz, instance);
        }

        return instance;
    }
}
