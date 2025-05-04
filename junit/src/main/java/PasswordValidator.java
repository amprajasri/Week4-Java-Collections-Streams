public class PasswordValidator {

    public boolean isValid(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper = false, hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }

        return hasUpper && hasDigit;
    }
}
