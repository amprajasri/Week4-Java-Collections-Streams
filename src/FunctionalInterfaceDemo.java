@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // Lambda to add two numbers
        Calculator addition = (a, b) -> a + b;

        // Lambda to multiply two numbers
        Calculator multiplication = (a, b) -> a * b;

        int result1 = addition.operate(10, 5);
        int result2 = multiplication.operate(10, 5);

        System.out.println("Addition Result: " + result1);
        System.out.println("Multiplication Result: " + result2);
    }
}
