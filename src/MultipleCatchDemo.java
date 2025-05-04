import java.util.*;

public class MultipleCatchDemo {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index: ");
        int index = scanner.nextInt();

        try {
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
