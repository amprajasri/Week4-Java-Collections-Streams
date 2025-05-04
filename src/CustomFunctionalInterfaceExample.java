@FunctionalInterface
interface SquareCalculator {
    // Single abstract method to calculate the square of a number
    int calculateSquare(int number);

    // Default method to print the result
    default void printResult(int number) {
        int square = calculateSquare(number);
        System.out.println("The square of " + number + " is: " + square);
    }
}

public class CustomFunctionalInterfaceExample {
    public static void main(String[] args) {
        // Implementing the functional interface using lambda expression
        SquareCalculator squareCalculator = (number) -> number * number;

        // Calling the default method to print the result
        squareCalculator.printResult(5);
    }
}
