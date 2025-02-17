package org.capgemini.annotations.exercise.exercise2;

public class DeprecatedExample {
    public static void main(String[] args) {
        // Create an instance of LegacyAPI
        LegacyAPI legacyAPI = new LegacyAPI();

        // Call the deprecated oldFeature() method
        legacyAPI.oldFeature();  // Warning will be displayed

        // Call the newFeature() method
        legacyAPI.newFeature();
    }
}

