import java.util.regex.*;
import java.util.*;

public class ExtractDates {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        // Regex to match dates in dd/mm/yyyy format
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> dates = new ArrayList<>();
        while (matcher.find()) {
            dates.add(matcher.group());
        }

        System.out.println("Extracted Dates:");
        System.out.println(String.join(", ", dates));
    }
}
