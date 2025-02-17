package org.capgemini.reflection.intermediate_level.access_and_modify_static;

import java.lang.reflect.*;

public class ModifyStaticFieldExample {
    public static void main(String[] args) throws Exception {
        // Get the Class object of Configuration
        Class<?> configClass = Configuration.class;

        // Get the private static field 'API_KEY' using reflection
        Field apiKeyField = configClass.getDeclaredField("API_KEY");

        // Make the field accessible (to bypass access control)
        apiKeyField.setAccessible(true);

        // Modify the value of the static field 'API_KEY'
        apiKeyField.set(null, "new-api-key-12345");

        // Print the modified value of the static field
        Configuration.displayAPIKey();  // This should print the new value of API_KEY
    }
}
