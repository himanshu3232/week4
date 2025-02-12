package org.capgemini.voting_system;

import java.util.*;

public class VotingSystem {
    private final Map<String, Integer> voteMap = new HashMap<>();
    private final Map<String, Integer> linkedVoteMap = new LinkedHashMap<>();
    private final Map<String, Integer> sortedVoteMap = new TreeMap<>();

    // Method to cast a vote
    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        linkedVoteMap.put(candidate, linkedVoteMap.getOrDefault(candidate, 0) + 1);
        sortedVoteMap.put(candidate, sortedVoteMap.getOrDefault(candidate, 0) + 1);
    }

    // Display votes in HashMap (unordered)
    public void displayVotesUnordered() {
        System.out.println("\nVotes (Unordered - HashMap):");
        voteMap.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes));
    }

    // Display votes in LinkedHashMap (insertion order)
    public void displayVotesInsertionOrder() {
        System.out.println("\nVotes (Insertion Order - LinkedHashMap):");
        linkedVoteMap.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes));
    }

    // Display votes in TreeMap (sorted order)
    public void displayVotesSorted() {
        System.out.println("\nVotes (Sorted Order - TreeMap):");
        sortedVoteMap.forEach((candidate, votes) -> System.out.println(candidate + ": " + votes));
    }

    // Display winner
    public void displayWinner() {
        String winner = Collections.max(voteMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("\nWinner: " + winner + " with " + voteMap.get(winner) + " votes.");
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        // Casting votes
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Charlie");

        // Displaying results
        votingSystem.displayVotesUnordered();
        votingSystem.displayVotesInsertionOrder();
        votingSystem.displayVotesSorted();
        votingSystem.displayWinner();
    }
}

