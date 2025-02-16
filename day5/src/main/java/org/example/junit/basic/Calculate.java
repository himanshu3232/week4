package org.example.junit.basic;

public class Calculate {
    // Method to perform division, throws ArithmeticException if divisor is zero
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}