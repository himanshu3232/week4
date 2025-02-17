package org.capgemini.annotations.exercise.exercise3;

import java.util.ArrayList;

public class SuppressWarning {

    // Using @SuppressWarnings to suppress unchecked warnings
    @SuppressWarnings({"unchecked"})
    public static void main(String[] args) {
        // Create an ArrayList without generics
        ArrayList list = new ArrayList();

        // Adding different types of objects to the list
        list.add("Hello, World!");  // String
        list.add(42);  // Integer
        list.add(3.14);  // Double

        // Retrieving elements from the list
        String message = (String) list.get(0);  // Explicit cast required due to lack of generics
        int number = (int) list.get(1);  // Explicit cast required
        double pi = (double) list.get(2);  // Explicit cast required

        // Output the retrieved values
        System.out.println("Message: " + message);
        System.out.println("Number: " + number);
        System.out.println("Pi: " + pi);
    }
}
