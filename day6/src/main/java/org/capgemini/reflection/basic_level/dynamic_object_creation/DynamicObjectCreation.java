package org.capgemini.reflection.basic_level.dynamic_object_creation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DynamicObjectCreation{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Student student = (Student) Class.forName("org.capgemini.reflection.basic_level.dynamic_object_creation.Student")
                .getDeclaredConstructor()
                .newInstance();

        //prints true if student object is not null
        System.out.println(student != null);
    }
}
