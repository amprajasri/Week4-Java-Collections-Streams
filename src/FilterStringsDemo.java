import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStringsDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Mark", "Annie", "David");

        // Filter strings that do NOT start with "A"
        List<String> filteredNames = names.stream()
                .filter(name -> !name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Filtered Names: " + filteredNames);
    }
}
