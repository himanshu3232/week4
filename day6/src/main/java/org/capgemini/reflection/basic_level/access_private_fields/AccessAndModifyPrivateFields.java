package org.capgemini.reflection.basic_level.access_private_fields;

import java.lang.reflect.Field;

//modifies private fields
public class AccessAndModifyPrivateFields {
    public static void main(String[] args) throws IllegalAccessException {
        //make object
        Person person = new Person();
        //get class
        Class<?> personClass = person.getClass();
        Field[] fields = personClass.getDeclaredFields();
        for(Field field : fields){
            if(field.getName().equals("age")){
                field.setAccessible(true);
                System.out.println("Original value: " + field.get(person));
                field.set(person,5);
                System.out.println("New value of the private final field is : " + field.get(person));
            }
        }
    }
}

