package basic;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic.Calculate;
import org.junit.jupiter.api.Test;

public class CalculateTest {
    @Test
    void testDivide() {
        assertEquals(2, Calculate.divide(6, 3)); // Normal division
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> Calculate.divide(6, 0));
        assertEquals("Cannot divide by zero", exception.getMessage()); // Verify exception message
    }
}

