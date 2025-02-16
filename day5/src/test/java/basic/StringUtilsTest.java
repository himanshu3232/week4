package basic;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    @Test
    void testReverse() {
        assertEquals("dcba", StringUtils.reverse("abcd"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"));
        assertTrue(StringUtils.isPalindrome("Racecar"));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("WORLD", StringUtils.toUpperCase("world"));
        assertNull(StringUtils.toUpperCase(null));
    }
}
