import java.util.Scanner;

public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String input = scanner.nextLine();

        if (isValidUsername(input)) {
            System.out.println("✅ Valid username");
        } else {
            System.out.println("❌ Invalid username");
        }
        scanner.close();
    }
}
