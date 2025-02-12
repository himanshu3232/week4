package org.capgemini.insurance_management_system;

import java.util.*;
import java.time.LocalDate;


public class InsurancePolicyManagementSystem {
    private final Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private final Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private final Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Policies (Unique):");
        linkedHashSetPolicies.forEach(System.out::println);
    }

    public void getExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);

        System.out.println("\nPolicies Expiring Soon:");
        treeSetPolicies.stream()
                .filter(policy -> policy.expiryDate.isBefore(threshold))
                .forEach(System.out::println);
    }

    public void getPoliciesByCoverageType(String coverageType) {
        System.out.println("\nPolicies for Coverage Type: " + coverageType);
        linkedHashSetPolicies.stream()
                .filter(policy -> policy.coverageType.equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    public void findDuplicatePolicies() {
        Set<String> seenNumbers = new HashSet<>();
        System.out.println("\nDuplicate Policies:");
        hashSetPolicies.stream()
                .filter(policy -> !seenNumbers.add(policy.policyNumber))
                .forEach(System.out::println);
    }

    public void performanceTest() {
        int N = 100000;
        List<InsurancePolicy> testPolicies = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            testPolicies.add(new InsurancePolicy("P" + i, "Holder" + i, LocalDate.of(2025, 5, 1), "Health", 5000));
        }

        System.out.println("\nPerformance Comparison:");

        long startTime, endTime;

        startTime = System.nanoTime();
        Set<InsurancePolicy> testHashSet = new HashSet<>(testPolicies);
        endTime = System.nanoTime();
        System.out.println("HashSet Insertion: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        testHashSet.contains(testPolicies.get(N / 2));
        endTime = System.nanoTime();
        System.out.println("HashSet Search: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        Set<InsurancePolicy> testLinkedHashSet = new LinkedHashSet<>(testPolicies);
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Insertion: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        testLinkedHashSet.contains(testPolicies.get(N / 2));
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Search: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        Set<InsurancePolicy> testTreeSet = new TreeSet<>(testPolicies);
        endTime = System.nanoTime();
        System.out.println("TreeSet Insertion: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        testTreeSet.contains(testPolicies.get(N / 2));
        endTime = System.nanoTime();
        System.out.println("TreeSet Search: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        system.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.of(2025, 3, 15), "Health", 10000));
        system.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.of(2024, 2, 25), "Auto", 5000));
        system.addPolicy(new InsurancePolicy("P1003", "Charlie", LocalDate.of(2024, 3, 5), "Home", 8000));
        system.addPolicy(new InsurancePolicy("P1004", "Alice", LocalDate.of(2024, 4, 10), "Health", 12000));

        system.displayAllPolicies();
        system.getExpiringSoon();
        system.getPoliciesByCoverageType("Health");
        system.findDuplicatePolicies();
        system.performanceTest();
    }
}

