package org.capgemini.reflection.basic_level.invoke_private_methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokePrivateMethod {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //create object
        Example example = new Example();
        //store methods
        Method[] methods = example.getClass().getDeclaredMethods();

        //iterate and invoke
        for(Method method : methods){
            method.setAccessible(true);
            method.invoke(example);
        }
    }
}
