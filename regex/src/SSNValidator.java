import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String text1 = "My SSN is 123-45-6789.";
        String text2 = "This number 123456789 is invalid.";

        validateSSN(text1);
        validateSSN(text2);
    }

    public static void validateSSN(String text) {
        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("✅ \"" + matcher.group() + "\" is valid");
        } else {
            System.out.println("❌ No valid SSN found in: \"" + text + "\"");
        }
    }
}
