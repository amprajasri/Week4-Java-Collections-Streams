import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accountMap = new HashMap<>();
    private Map<Double, Integer> sortedAccountMap = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void addAccount(int accountNumber, double balance) {
        accountMap.put(accountNumber, balance);
        sortedAccountMap.put(balance, accountNumber);
    }

    public void processWithdrawalRequest(int accountNumber, double amount) {
        if (accountMap.containsKey(accountNumber)) {
            double currentBalance = accountMap.get(accountNumber);
            if (currentBalance >= amount) {
                accountMap.put(accountNumber, currentBalance - amount);
                withdrawalQueue.add(accountNumber);
                System.out.println("Withdrawal of $" + amount + " successful for account " + accountNumber);
            } else {
                System.out.println("Insufficient balance in account " + accountNumber);
            }
        } else {
            System.out.println("Account " + accountNumber + " does not exist.");
        }
    }

    public void processNextWithdrawal() {
        if (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processed withdrawal request for account: " + accountNumber);
        } else {
            System.out.println("No withdrawal requests to process.");
        }
    }

    public void displayAccounts() {
        System.out.println("Customer Accounts:");
        for (Map.Entry<Integer, Double> entry : accountMap.entrySet()) {
            System.out.println("Account Number: " + entry.getKey() + ", Balance: $" + entry.getValue());
        }
    }

    public void displaySortedAccounts() {
        System.out.println("\nSorted Accounts by Balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccountMap.entrySet()) {
            System.out.println("Account Number: " + entry.getValue() + ", Balance: $" + entry.getKey());
        }
    }

    public void displayWithdrawalQueue() {
        System.out.println("\nWithdrawal Request Queue:");
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No pending withdrawal requests.");
        } else {
            for (Integer accountNumber : withdrawalQueue) {
                System.out.println("Account Number: " + accountNumber);
            }
        }
    }
}

public class BankingSystemApp {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount(101, 5000.00);
        bank.addAccount(102, 3000.00);
        bank.addAccount(103, 10000.00);

        bank.displayAccounts();

        bank.processWithdrawalRequest(101, 2000.00);
        bank.processWithdrawalRequest(102, 3500.00);
        bank.processWithdrawalRequest(104, 500.00); // Non-existent account

        bank.displayWithdrawalQueue();

        bank.processNextWithdrawal();
        bank.processNextWithdrawal();

        bank.displaySortedAccounts();
    }
}
