package org.capgemini.reflection.intermediate_level.dynamic_method_invoke;

import java.lang.reflect.*;
import java.util.Scanner;


public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        // Create an object of MathOperations
        MathOperations mathOperations = new MathOperations();

        // Get the class object of MathOperations
        Class<?> mathClass = mathOperations.getClass();

        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to choose a method (add, subtract, multiply)
        System.out.println("Choose a method (add, subtract, multiply): ");
        String methodName = scanner.nextLine().toLowerCase();

        // Ask the user for two numbers to perform the operation
        System.out.println("Enter the first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = scanner.nextInt();

        // Dynamically invoke the chosen method using reflection
        try {
            // Get the method based on the user's input
            Method method = mathClass.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically and get the result
            int result = (int) method.invoke(mathOperations, num1, num2);

            // Print the result
            System.out.println("Result: " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("Error: The method does not exist.");
        } catch (InvocationTargetException e) {
            System.out.println("Error: An error occurred during method invocation.");
        } catch (IllegalAccessException e) {
            System.out.println("Error: Illegal access to the method.");
        }

        // Close the scanner
        scanner.close();
    }
}
