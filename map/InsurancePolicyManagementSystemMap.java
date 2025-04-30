import java.time.LocalDate;
import java.util.*;

class Policy {
    int policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(int policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyHolderName + ", Expiry: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}

class InsurancePolicyManager {
    Map<Integer, Policy> hashMap = new HashMap<>();
    Map<Integer, Policy> linkedHashMap = new LinkedHashMap<>();
    Map<Integer, Policy> treeMap = new TreeMap<>(new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return hashMap.get(a).getExpiryDate().compareTo(hashMap.get(b).getExpiryDate());
        }
    });

    public void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);
        treeMap.put(policy.policyNumber, policy);
    }

    public Policy getPolicy(int policyNumber) {
        return hashMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiringSoonPolicies = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Policy policy : treeMap.values()) {
            if (!policy.expiryDate.isBefore(now) && policy.expiryDate.isBefore(now.plusDays(30))) {
                expiringSoonPolicies.add(policy);
            }
        }
        return expiringSoonPolicies;
    }

    public List<Policy> getPoliciesByPolicyholder(String policyHolderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : hashMap.values()) {
            if (policy.policyHolderName.equalsIgnoreCase(policyHolderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        Iterator<Map.Entry<Integer, Policy>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Policy> entry = iterator.next();
            if (entry.getValue().expiryDate.isBefore(now)) {
                iterator.remove();
            }
        }
    }

    public void displayPolicies(Map<Integer, Policy> policyMap) {
        for (Policy policy : policyMap.values()) {
            System.out.println(policy);
        }
    }
}

public class InsurancePolicyManagementSystemMap {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();
        
        Policy policy1 = new Policy(101, "Alice", LocalDate.of(2023, 5, 30), "Health", 1500.50);
        Policy policy2 = new Policy(102, "Bob", LocalDate.of(2023, 6, 15), "Auto", 1200.75);
        Policy policy3 = new Policy(103, "Alice", LocalDate.of(2023, 6, 5), "Home", 1000.25);
        
        manager.addPolicy(policy1);
        manager.addPolicy(policy2);
        manager.addPolicy(policy3);

        System.out.println("Policy with number 101: " + manager.getPolicy(101));

        System.out.println("\nPolicies expiring soon:");
        manager.getPoliciesExpiringSoon().forEach(System.out::println);

        System.out.println("\nPolicies for Alice:");
        manager.getPoliciesByPolicyholder("Alice").forEach(System.out::println);

        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();

        System.out.println("\nPolicies after removal of expired ones:");
        manager.displayPolicies(manager.hashMap);
    }
}
