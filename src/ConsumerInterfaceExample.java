import java.util.*;
import java.util.function.Consumer;

public class ConsumerInterfaceExample {
    public static void main(String[] args) {
        // List of strings
        List<String> strings = Arrays.asList("hello", "world", "java", "lambda");

        // Consumer to print each string in uppercase
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());

        // Using forEach to apply the consumer to each element in the list
        strings.forEach(printUpperCase);
    }
}
