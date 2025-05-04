import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {
    UserRegistration reg = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertTrue(reg.registerUser("john", "john@example.com", "pass123"));
    }

    @Test
    void testInvalidUsername() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                reg.registerUser("", "john@example.com", "pass123"));
        assertEquals("Invalid username", e.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                reg.registerUser("john", "johnexample.com", "pass123"));
        assertEquals("Invalid email", e.getMessage());
    }

    @Test
    void testInvalidPassword() {
        Exception e = assertThrows(IllegalArgumentException.class, () ->
                reg.registerUser("john", "john@example.com", "123"));
        assertEquals("Invalid password", e.getMessage());
    }
}
