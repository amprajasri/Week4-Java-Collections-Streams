import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("15-05-2024", formatter.formatDate("2024-05-15"));
    }

    @Test
    void testInvalidDateFormat() {
        assertEquals("Invalid date", formatter.formatDate("15/05/2024"));
    }

    @Test
    void testNonexistentDate() {
        assertEquals("Invalid date", formatter.formatDate("2024-02-30"));
    }
}
