import java.util.function.BiFunction;

public class BiFunctionInterfaceExample {
    public static void main(String[] args) {
        // BiFunction to concatenate two strings with a space
        BiFunction<String, String, String> concatenateStrings = (str1, str2) -> str1 + " " + str2;

        // Input strings
        String firstString = "Hello";
        String secondString = "World";

        // Concatenating the strings using the BiFunction interface
        String result = concatenateStrings.apply(firstString, secondString);

        // Output: displaying the concatenated result
        System.out.println("Concatenated String: " + result);
    }
}
