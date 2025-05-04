import java.util.regex.*;
import java.util.*;

public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Define a list of known programming languages
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "Go", "C", "C++", "C#", "Ruby", "Swift", "Kotlin", "Rust", "TypeScript");

        // Regex pattern to match capitalized words
        Pattern pattern = Pattern.compile("\\b[A-Z][a-zA-Z#+]*\\b");
        Matcher matcher = pattern.matcher(text);

        Set<String> foundLanguages = new LinkedHashSet<>();
        while (matcher.find()) {
            String word = matcher.group();
            if (languages.contains(word)) {
                foundLanguages.add(word);
            }
        }

        // Output result
        System.out.println("Extracted Languages:");
        for (String lang : foundLanguages) {
            System.out.println(lang);
        }
    }
}
