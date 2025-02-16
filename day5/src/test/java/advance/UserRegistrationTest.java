package advance;

import org.example.junit.advance.UserRegistration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> UserRegistration.registerUser("JohnDoe", "john@example.com", "Secure123"), "Valid user should not throw exception");
    }

    @Test
    void testEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("", "john@example.com", "Secure123"), "Empty username should throw exception");
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "invalid-email", "Secure123"), "Invalid email should throw exception");
    }

    @Test
    void testShortPassword() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("JohnDoe", "john@example.com", "short"), "Password shorter than 8 characters should throw exception");
    }
}

