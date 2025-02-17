package org.capgemini.reflection.basic_level.get_class_info;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

//Gets class name from the user and displays their constructor, fields and methods
public class GetClassInformation {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String path = "org.capgemini.reflection.basic_level.get_class_info.";
            //get class name from user
            System.out.print("Enter class name: ");
            String className = path + sc.next();
            //store class
            Class<?> userClass = Class.forName(className);
            //store fields
            Field[] fields = userClass.getDeclaredFields();
            //store methods
            Method[] methods = userClass.getDeclaredMethods();
            //store constructors
            Constructor<?>[] constructors = userClass.getDeclaredConstructors();
            for(Field field : fields)
                System.out.print("Field name: " + field.getName() + " ");

            System.out.println("\n------------------");

            for (Method method : methods)
                System.out.print("Method name: " + method.getName() + " ");

            System.out.println("\n------------------");

            for (Constructor<?> constructor : constructors)
                System.out.println("Constructor name: " + constructor.getName() + " ");

            System.out.println("\n------------------");

        }catch (ClassNotFoundException e){
            System.out.println("Invalid class name!");
        }
    }
}
