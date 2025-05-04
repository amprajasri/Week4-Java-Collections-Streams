import java.util.regex.*;
import java.util.*;

public class ExtractCurrency {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        // Regex pattern to match currency values (with or without $)
        Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(text);

        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        System.out.println("Extracted Currency Values:");
        for (String value : currencyValues) {
            System.out.println(value);
        }
    }
}
