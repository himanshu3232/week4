package org.capgemini.annotations.intermediate_level.field_validation;

// Test the annotation
public class MaxLengthValidator {
    public static void main(String[] args) {
        try {
            User user1 = new User("ShortName"); // Valid
            System.out.println("User1 created successfully");

            User user2 = new User("ThisNameIsTooLong"); // Should throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}
