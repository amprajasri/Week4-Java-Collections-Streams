import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class PredicateComposition {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abcdef", "ab", "abcxyz", "abcdefg", "xyz", "a", "abc");

        // Predicate for length > 5
        Predicate<String> lengthGreaterThanFive = str -> str.length() > 5;

        // Predicate for containing substring "abc"
        Predicate<String> containsSubstring = str -> str.contains("abc");

        // Combine both predicates using and()
        Predicate<String> combinedPredicate = lengthGreaterThanFive.and(containsSubstring);

        // Filter the list using the combined predicate
        List<String> filteredStrings = strings.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toList());

        // Print the filtered list
        System.out.println("Filtered strings: " + filteredStrings);
    }
}
