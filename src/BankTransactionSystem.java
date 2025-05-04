import java.util.Scanner;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// BankAccount class with withdrawal method
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw amount
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a bank account with an initial balance
        BankAccount account = new BankAccount(1000.00);

        try {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            // Attempt to withdraw the amount
            account.withdraw(amount);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid amount! " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance! " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
