package org.capgemini.reflection.advanced_level.to_json;

import java.lang.reflect.Field;

public class ObjectToJson {

    // Method to convert an object to a JSON-like string using reflection
    public static String toJson(Object obj) throws IllegalAccessException {
        // Get the class of the object
        Class<?> objClass = obj.getClass();

        // Initialize a StringBuilder to build the JSON string
        StringBuilder jsonBuilder = new StringBuilder();

        // Start the JSON object
        jsonBuilder.append("{");

        // Get all declared fields (including private fields)
        Field[] fields = objClass.getDeclaredFields();

        // Iterate through the fields and add them to the JSON string
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); // Allow access to private fields

            // Get the field name and value
            String fieldName = field.getName();
            Object fieldValue = field.get(obj);

            // Append the field name and value to the JSON string
            jsonBuilder.append("\"").append(fieldName).append("\":");

            // Check the type of the field value and handle accordingly
            if (fieldValue instanceof String) {
                jsonBuilder.append("\"").append(fieldValue).append("\"");
            } else {
                jsonBuilder.append(fieldValue);
            }

            // Add a comma if it's not the last field
            if (i < fields.length - 1) {
                jsonBuilder.append(", ");
            }
        }

        // End the JSON object
        jsonBuilder.append("}");

        // Return the generated JSON-like string
        return jsonBuilder.toString();
    }

    public static void main(String[] args) {
        // Example class with fields
        // Create an object of Person
        Person person = new Person("John Doe", 30, "johndoe@example.com");

        try {
            // Convert the Person object to a JSON-like string
            String json = toJson(person);

            // Print the generated JSON string
            System.out.println(json);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
