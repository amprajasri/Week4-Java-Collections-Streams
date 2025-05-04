import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardValidator {
    public static void main(String[] args) {
        String cardNumber = "4111111111111111";  // Example Visa card

        // Regular expression for Visa and MasterCard validation
        String regex = "^(4\\d{15}|5\\d{15})$";

        // Compile the regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);

        if (matcher.matches()) {
            System.out.println(cardNumber + " is a valid credit card number.");
        } else {
            System.out.println(cardNumber + " is an invalid credit card number.");
        }
    }
}
