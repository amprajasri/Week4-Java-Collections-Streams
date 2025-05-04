import java.util.*;
import java.util.stream.*;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudSummary {
    String policyNumber;
    long fraudCount;
    double totalFraudAmount;

    FraudSummary(String policyNumber, long fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return "Policy: " + policyNumber + ", Fraud Count: " + fraudCount + ", Total Fraud Amount: $" + totalFraudAmount;
    }
}

public class FraudDetectionSystem {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "P1001", 15000, "2023-01-01", true),
                new Transaction("T2", "P1002", 8000, "2023-01-02", true),
                new Transaction("T3", "P1001", 20000, "2023-01-03", true),
                new Transaction("T4", "P1003", 60000, "2023-01-04", true),
                new Transaction("T5", "P1001", 30000, "2023-01-05", true),
                new Transaction("T6", "P1001", 12000, "2023-01-06", true),
                new Transaction("T7", "P1001", 11000, "2023-01-07", true),
                new Transaction("T8", "P1004", 9000, "2023-01-08", true)
        );

        // Step 1: Filter fraudulent transactions with amount > $10,000
        List<Transaction> filtered = transactions.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.toList());

        // Step 2 & 3: Group by policyNumber and aggregate fraud count & amount
        Map<String, FraudSummary> summaryMap = filtered.stream()
                .collect(Collectors.groupingBy(
                        t -> t.policyNumber,
                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                            long count = list.size();
                            double totalAmount = list.stream().mapToDouble(t -> t.amount).sum();
                            return new FraudSummary(list.get(0).policyNumber, count, totalAmount);
                        })
                ));

        // Step 4: Generate alerts for high-risk policies
        System.out.println(" Fraud Alerts:");
        summaryMap.values().stream()
                .filter(s -> s.fraudCount > 5 || s.totalFraudAmount > 50000)
                .forEach(System.out::println);
    }
}
