package advance;

import org.example.junit.advance.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {
    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123"), "Valid password should pass");
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValid("Short1"), "Password should be at least 8 characters long");
    }

    @Test
    void testNoUppercase() {
        assertFalse(PasswordValidator.isValid("secure123"), "Password should contain at least one uppercase letter");
    }

    @Test
    void testNoDigit() {
        assertFalse(PasswordValidator.isValid("SecurePass"), "Password should contain at least one digit");
    }
}
