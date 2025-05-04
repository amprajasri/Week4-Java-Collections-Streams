import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    LocalDate claimDate;
    String status;

    Claim(String claimId, String policyNumber, double claimAmount, LocalDate claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class PolicySummary {
    String policyNumber;
    double totalAmount;
    double averageAmount;

    PolicySummary(String policyNumber, double totalAmount, double averageAmount) {
        this.policyNumber = policyNumber;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    @Override
    public String toString() {
        return "Policy: " + policyNumber +
                ", Total: $" + totalAmount +
                ", Average: $" + averageAmount;
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "P1001", 8000, LocalDate.of(2023, 5, 10), "Approved"),
                new Claim("C002", "P1002", 12000, LocalDate.of(2023, 6, 12), "Approved"),
                new Claim("C003", "P1001", 6000, LocalDate.of(2023, 7, 15), "Rejected"),
                new Claim("C004", "P1003", 7000, LocalDate.of(2023, 8, 18), "Approved"),
                new Claim("C005", "P1002", 3000, LocalDate.of(2023, 9, 20), "Approved"),
                new Claim("C006", "P1003", 9000, LocalDate.of(2023, 10, 22), "Approved"),
                new Claim("C007", "P1004", 10000, LocalDate.of(2023, 11, 25), "Pending")
        );

        // 1. Filter: Approved and > $5000
        List<Claim> filtered = claims.stream()
                .filter(c -> c.status.equalsIgnoreCase("Approved") && c.claimAmount > 5000)
                .collect(Collectors.toList());

        // 2. Group by policyNumber
        Map<String, List<Claim>> grouped = filtered.stream()
                .collect(Collectors.groupingBy(c -> c.policyNumber));

        // 3. Aggregate per policy
        List<PolicySummary> summaries = grouped.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Claim> policyClaims = entry.getValue();
                    double total = policyClaims.stream().mapToDouble(c -> c.claimAmount).sum();
                    double avg = policyClaims.stream().mapToDouble(c -> c.claimAmount).average().orElse(0);
                    return new PolicySummary(policy, total, avg);
                })
                .collect(Collectors.toList());

        // 4. Top 3 by totalAmount
        List<PolicySummary> top3 = summaries.stream()
                .sorted((a, b) -> Double.compare(b.totalAmount, a.totalAmount))
                .limit(3)
                .collect(Collectors.toList());

        // Print results
        System.out.println("Top 3 Policies with Highest Total Claim Amounts:");
        top3.forEach(System.out::println);
    }
}
