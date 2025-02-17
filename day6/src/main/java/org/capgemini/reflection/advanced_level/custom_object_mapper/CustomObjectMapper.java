package org.capgemini.reflection.advanced_level.custom_object_mapper;

import java.lang.reflect.*;
import java.util.Map;


public class CustomObjectMapper {

    // Method to convert a Map to an object of the specified class
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        // Create a new instance of the class
        T obj = clazz.getDeclaredConstructor().newInstance();

        // Iterate over each entry in the properties map
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            // Get the field name and value from the map
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();

            try {
                // Get the field from the class (considering it may be private)
                Field field = clazz.getDeclaredField(fieldName);

                // Make the field accessible if it's private
                field.setAccessible(true);

                // Set the field value (appropriate casting will happen automatically)
                field.set(obj, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // If the field doesn't exist or access is restricted, print an error
                System.out.println("Error setting field: " + fieldName + " -> " + e.getMessage());
            }
        }

        // Return the populated object
        return obj;
    }

    public static void main(String[] args) {
        try {
            // Create a map with property names and values
            Map<String, Object> properties = Map.of(
                    "name", "John Doe",
                    "age", 30,
                    "email", "johndoe@example.com"
            );

            // Convert the map into a Person object using reflection
            Person person = toObject(Person.class, properties);

            // Print the object details
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            System.out.println("Email: " + person.getEmail());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
