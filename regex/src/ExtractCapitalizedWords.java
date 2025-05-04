import java.util.regex.*;
import java.util.*;

public class ExtractCapitalizedWords {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        // Regex to match capitalized words (starting with uppercase followed by lowercase letters)
        String regex = "\\b[A-Z][a-z]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> capitalizedWords = new ArrayList<>();
        while (matcher.find()) {
            String word = matcher.group();
            // Skip words like "The" if not needed
            if (!word.equals("The")) {
                capitalizedWords.add(word);
            }
        }

        System.out.println("Capitalized Words:");
        System.out.println(String.join(", ", capitalizedWords));
    }
}
