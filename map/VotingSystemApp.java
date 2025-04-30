import java.util.*;

class VotingSystem {
    private Map<String, Integer> hashMapVotes = new HashMap<>();
    private Map<String, Integer> linkedHashMapVotes = new LinkedHashMap<>();
    private Map<String, Integer> treeMapVotes = new TreeMap<>();

    public void addVote(String candidate) {
        hashMapVotes.put(candidate, hashMapVotes.getOrDefault(candidate, 0) + 1);
        linkedHashMapVotes.put(candidate, linkedHashMapVotes.getOrDefault(candidate, 0) + 1);
        treeMapVotes.put(candidate, treeMapVotes.getOrDefault(candidate, 0) + 1);
    }

    public void displayVotes() {
        System.out.println("Votes in HashMap:");
        for (Map.Entry<String, Integer> entry : hashMapVotes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("\nVotes in LinkedHashMap (Order of Voting):");
        for (Map.Entry<String, Integer> entry : linkedHashMapVotes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("\nVotes in TreeMap (Sorted Order):");
        for (Map.Entry<String, Integer> entry : treeMapVotes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public String getWinner() {
        return treeMapVotes.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public void resetVotes() {
        hashMapVotes.clear();
        linkedHashMapVotes.clear();
        treeMapVotes.clear();
    }
}

public class VotingSystemApp {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.addVote("Alice");
        votingSystem.addVote("Bob");
        votingSystem.addVote("Alice");
        votingSystem.addVote("Charlie");
        votingSystem.addVote("Bob");

        votingSystem.displayVotes();

        System.out.println("\nWinner: " + votingSystem.getWinner());

        votingSystem.resetVotes();
        System.out.println("\nAfter Resetting Votes:");
        votingSystem.displayVotes();
    }
}
