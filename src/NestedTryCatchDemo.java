import java.util.Scanner;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take array and divisor as input
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the index of the element to access: ");
        int index = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        try {
            // Nested try-catch for array access and division
            try {
                int element = array[index];  // Accessing the array element
                try {
                    int result = element / divisor;  // Division operation
                    System.out.println("Result of division: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
