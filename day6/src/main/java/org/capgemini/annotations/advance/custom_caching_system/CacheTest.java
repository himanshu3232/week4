package org.capgemini.annotations.advance.custom_caching_system;

// Test class to validate caching
public class CacheTest {
    public static void main(String[] args) throws Exception {
        ExpensiveCalculator calculator = new ExpensiveCalculator();

        System.out.println("Result: " + calculator.computeSquare(5)); // Computes
        System.out.println("Result: " + calculator.computeSquare(5)); // Cached
        System.out.println("Result: " + calculator.computeSquare(7)); // Computes
        System.out.println("Result: " + calculator.computeSquare(7)); // Cached
    }
}
