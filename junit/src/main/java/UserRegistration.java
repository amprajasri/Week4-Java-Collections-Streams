public class UserRegistration {
    public boolean registerUser(String username, String email, String password) {
        if (username == null || username.isBlank())
            throw new IllegalArgumentException("Invalid username");
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$"))
            throw new IllegalArgumentException("Invalid email");
        if (password == null || password.length() < 6)
            throw new IllegalArgumentException("Invalid password");
        return true;
    }
}
