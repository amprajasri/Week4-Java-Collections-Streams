import java.util.Scanner;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        return color.matches("^#[0-9a-fA-F]{6}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hex color code: ");
        String input = scanner.nextLine();

        if (isValidHexColor(input)) {
            System.out.println("✅ Valid hex color code");
        } else {
            System.out.println("❌ Invalid hex color code");
        }
        scanner.close();
    }
}
