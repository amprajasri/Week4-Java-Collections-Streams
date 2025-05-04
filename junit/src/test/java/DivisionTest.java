import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivisionTest {

    Division division = new Division();

    @Test
    void testDivideValid() {
        assertEquals(5, division.divide(10, 2));
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> division.divide(10, 0));
    }
}
