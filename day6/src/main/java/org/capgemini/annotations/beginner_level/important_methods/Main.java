package org.capgemini.annotations.beginner_level.important_methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Example example = new Example();
        Class<?> exampleClass = example.getClass();
        Method[] methods = exampleClass.getDeclaredMethods();
        for(Method method : methods){
            method.setAccessible(true);
            method.invoke(example);
        }
    }
}
