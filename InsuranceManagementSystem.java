import java.time.LocalDate;
import java.util.*;

class Policy implements Comparable<Policy> {
    private int policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(int policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return policyNumber == policy.policyNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    public void display() {
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Policyholder Name: " + policyHolderName);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Coverage Type: " + coverageType);
        System.out.println("Premium Amount: " + premiumAmount);
        System.out.println("--------------------------");
    }
}

class PolicyManager {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();
    private List<Policy> allPolicies = new ArrayList<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
        allPolicies.add(policy);
    }

    public void displayAllUniquePolicies() {
        for (Policy p : hashSet) {
            p.display();
        }
    }

    public void displayPoliciesExpiringSoon() {
        LocalDate now = LocalDate.now();
        LocalDate within30 = now.plusDays(30);
        for (Policy p : treeSet) {
            if (!p.getExpiryDate().isBefore(now) && p.getExpiryDate().isBefore(within30)) {
                p.display();
            }
        }
    }

    public void displayPoliciesByCoverageType(String type) {
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                p.display();
            }
        }
    }

    public void displayDuplicatePolicies() {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (Policy p : allPolicies) {
            frequency.put(p.getPolicyNumber(), frequency.getOrDefault(p.getPolicyNumber(), 0) + 1);
        }
        for (Policy p : allPolicies) {
            if (frequency.get(p.getPolicyNumber()) > 1) {
                p.display();
            }
        }
    }

    public void comparePerformance() {
        List<Policy> samplePolicies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            samplePolicies.add(new Policy(i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Health", 1000 + i));
        }

        long start, end;

        Set<Policy> hs = new HashSet<>();
        start = System.nanoTime();
        for (Policy p : samplePolicies) hs.add(p);
        end = System.nanoTime();
        System.out.println("HashSet add: " + (end - start) + " ns");

        start = System.nanoTime();
        hs.contains(samplePolicies.get(5000));
        end = System.nanoTime();
        System.out.println("HashSet search: " + (end - start) + " ns");

        start = System.nanoTime();
        hs.remove(samplePolicies.get(5000));
        end = System.nanoTime();
        System.out.println("HashSet remove: " + (end - start) + " ns");

        Set<Policy> lhs = new LinkedHashSet<>();
        start = System.nanoTime();
        for (Policy p : samplePolicies) lhs.add(p);
        end = System.nanoTime();
        System.out.println("LinkedHashSet add: " + (end - start) + " ns");

        start = System.nanoTime();
        lhs.contains(samplePolicies.get(5000));
        end = System.nanoTime();
        System.out.println("LinkedHashSet search: " + (end - start) + " ns");

        start = System.nanoTime();
        lhs.remove(samplePolicies.get(5000));
        end = System.nanoTime();
        System.out.println("LinkedHashSet remove: " + (end - start) + " ns");

        Set<Policy> ts = new TreeSet<>();
        start = System.nanoTime();
        for (Policy p : samplePolicies) ts.add(p);
        end = System.nanoTime();
        System.out.println("TreeSet add: " + (end - start) + " ns");

        start = System.nanoTime();
        ts.contains(samplePolicies.get(5000));
        end = System.nanoTime();
        System.out.println("TreeSet search: " + (end - start) + " ns");

        start = System.nanoTime();
        ts.remove(samplePolicies.get(5000));
        end = System.nanoTime();
        System.out.println("TreeSet remove: " + (end - start) + " ns");
    }
}

public class InsuranceManagementSystem {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy(101, "Alice", LocalDate.now().plusDays(10), "Health", 1200));
        manager.addPolicy(new Policy(102, "Bob", LocalDate.now().plusDays(20), "Auto", 900));
        manager.addPolicy(new Policy(103, "Charlie", LocalDate.now().plusDays(5), "Home", 1500));
        manager.addPolicy(new Policy(101, "Alice", LocalDate.now().plusDays(10), "Health", 1200));

        System.out.println("All Unique Policies:");
        manager.displayAllUniquePolicies();

        System.out.println("Policies Expiring in Next 30 Days:");
        manager.displayPoliciesExpiringSoon();

        System.out.println("Policies with Coverage Type 'Health':");
        manager.displayPoliciesByCoverageType("Health");

        System.out.println("Duplicate Policies:");
        manager.displayDuplicatePolicies();

        System.out.println("Performance Comparison:");
        manager.comparePerformance();
    }
}
