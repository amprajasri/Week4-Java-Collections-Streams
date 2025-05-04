import java.util.*;

public class RepeatingWords {
    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";

        // Convert to lowercase and remove punctuation
        input = input.toLowerCase().replaceAll("[^a-z\\s]", "");

        String[] words = input.split("\\s+");
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Repeating Words:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
