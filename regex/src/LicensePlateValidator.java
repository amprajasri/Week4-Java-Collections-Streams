import java.util.Scanner;

public class LicensePlateValidator {
    public static boolean isValidPlate(String plate) {
        return plate.matches("^[A-Z]{2}[0-9]{4}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter license plate number: ");
        String input = scanner.nextLine();

        if (isValidPlate(input)) {
            System.out.println("✅ Valid license plate");
        } else {
            System.out.println("❌ Invalid license plate");
        }
        scanner.close();
    }
}
