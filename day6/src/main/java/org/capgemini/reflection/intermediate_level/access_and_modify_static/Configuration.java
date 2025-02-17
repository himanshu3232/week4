package org.capgemini.reflection.intermediate_level.access_and_modify_static;

public class Configuration {
    // Private static field
    private static final String API_KEY = "default-api-key";

    // Method to display the value of the API_KEY
    public static void displayAPIKey() {
        System.out.println("API Key: " + API_KEY);
    }
}