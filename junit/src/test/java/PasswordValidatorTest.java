import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Secure123"));
    }

    @Test
    void testTooShortPassword() {
        assertFalse(validator.isValid("Ab1"));
    }

    @Test
    void testMissingUppercase() {
        assertFalse(validator.isValid("secure123"));
    }

    @Test
    void testMissingDigit() {
        assertFalse(validator.isValid("SecurePass"));
    }

    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}
