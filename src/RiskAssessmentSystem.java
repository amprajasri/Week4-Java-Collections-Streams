import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return "ID: " + holderId + ", Name: " + name + ", Risk Score: " + riskScore;
    }
}

public class RiskAssessmentSystem {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H001", "Alice", 65, "Life", 40000),
                new PolicyHolder("H002", "Bob", 62, "Health", 30000),
                new PolicyHolder("H003", "Charlie", 70, "Life", 35000),
                new PolicyHolder("H004", "David", 59, "Life", 20000),
                new PolicyHolder("H005", "Eve", 75, "Life", 60000)
        );

        // 1. Filter: policyType == "Life" and age > 60
        List<PolicyHolder> filtered = holders.stream()
                .filter(h -> h.policyType.equalsIgnoreCase("Life") && h.age > 60)
                .collect(Collectors.toList());

        // 2. Transform: to RiskAssessment with score = premiumAmount / age
        List<RiskAssessment> assessments = filtered.stream()
                .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
                .collect(Collectors.toList());

        // 3. Sort by risk score descending
        List<RiskAssessment> sorted = assessments.stream()
                .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore))
                .collect(Collectors.toList());

        // 4. Categorize: High Risk (> 0.5) and Low Risk (<= 0.5)
        Map<String, List<RiskAssessment>> categorized = sorted.stream()
                .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        // Output
        System.out.println("High Risk Policy Holders:");
        categorized.getOrDefault("High Risk", Collections.emptyList())
                .forEach(System.out::println);

        System.out.println("\nLow Risk Policy Holders:");
        categorized.getOrDefault("Low Risk", Collections.emptyList())
                .forEach(System.out::println);
    }
}
