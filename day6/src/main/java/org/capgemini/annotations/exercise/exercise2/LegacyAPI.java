package org.capgemini.annotations.exercise.exercise2;

// Class LegacyAPI
public class LegacyAPI {

    // Deprecated method
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. It is deprecated and should not be used.");
    }

    // New method that replaces the old method
    public void newFeature() {
        System.out.println("This is the new feature. Use this instead of the old feature.");
    }
}
