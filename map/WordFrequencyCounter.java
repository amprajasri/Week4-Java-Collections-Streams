import java.util.*;
import java.nio.file.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws Exception {
        String content = Files.readString(Path.of("input.txt"));
        content = content.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = content.split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        System.out.println(freqMap);
    }
}
