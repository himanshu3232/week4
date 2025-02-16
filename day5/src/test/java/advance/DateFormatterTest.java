package advance;

import org.example.junit.advance.DateFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;


public class DateFormatterTest {
    @Test
    void testValidDateFormat() throws ParseException {
        assertEquals("15-08-2023", DateFormatter.formatDate("2023-08-15"), "Date should be formatted correctly");
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"), "Date should be formatted correctly");
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(ParseException.class, () -> DateFormatter.formatDate("15/08/2023"), "Invalid format should throw ParseException");
        assertThrows(ParseException.class, () -> DateFormatter.formatDate("2023.08.15"), "Invalid format should throw ParseException");
    }
}