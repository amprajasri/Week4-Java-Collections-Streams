import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalHandlingExample {
    public static void main(String[] args) {
        // Sample list of integers
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Get the maximum value using Optional
        Optional<Integer> maxValue = getMaxValue(numbers);

        // Check if a value is present and print it, otherwise print a message
        maxValue.ifPresentOrElse(
                value -> System.out.println("Maximum value: " + value),
                () -> System.out.println("The list is empty.")
        );
    }

    // Method to get the maximum value from the list and return it as Optional
    public static Optional<Integer> getMaxValue(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo);  // Return Optional of maximum value
    }
}
