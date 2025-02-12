package org.capgemini.insurance_management_system2;

import java.util.*;
import java.time.LocalDate;


public class InsurancePolicyManagementSystem {
    private final Map<String, InsurancePolicy> policyMap = new HashMap<>(); // Fast lookup by policy number
    private final Map<String, InsurancePolicy> orderedPolicies = new LinkedHashMap<>(); // Maintains insertion order
    private final TreeMap<LocalDate, List<InsurancePolicy>> expirySortedPolicies = new TreeMap<>(); // Sorted by expiry date

    // Add a new policy
    public void addPolicy(InsurancePolicy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);

        expirySortedPolicies.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Retrieve a policy by number
    public InsurancePolicy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // List all policies expiring within the next 30 days
    public List<InsurancePolicy> getExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        List<InsurancePolicy> expiringPolicies = new ArrayList<>();

        expirySortedPolicies.subMap(today, true, threshold, true).values().forEach(expiringPolicies::addAll);
        return expiringPolicies;
    }

    // List all policies for a specific policyholder
    public List<InsurancePolicy> getPoliciesByHolder(String holderName) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : policyMap.values()) {
            if (policy.policyHolderName.equalsIgnoreCase(holderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        NavigableMap<LocalDate, List<InsurancePolicy>> expiredEntries = expirySortedPolicies.headMap(today, true);

        for (List<InsurancePolicy> policies : expiredEntries.values()) {
            for (InsurancePolicy policy : policies) {
                policyMap.remove(policy.policyNumber);
                orderedPolicies.remove(policy.policyNumber);
            }
        }

        expiredEntries.clear(); // Remove from TreeMap
    }

    // Display all policies in insertion order
    public void displayAllPolicies() {
        orderedPolicies.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        system.addPolicy(new InsurancePolicy("P1001", "Alice", LocalDate.of(2025, 3, 15)));
        system.addPolicy(new InsurancePolicy("P1002", "Bob", LocalDate.of(2024, 2, 25)));
        system.addPolicy(new InsurancePolicy("P1003", "Charlie", LocalDate.of(2024, 3, 5)));
        system.addPolicy(new InsurancePolicy("P1004", "Alice", LocalDate.of(2024, 4, 10)));

        System.out.println("🔍 Retrieve Policy P1002: " + system.getPolicy("P1002"));

        System.out.println("\n📅 Policies Expiring in Next 30 Days:");
        System.out.println(system.getExpiringSoon());

        System.out.println("\n👤 Policies for Alice:");
        System.out.println(system.getPoliciesByHolder("Alice"));

        System.out.println("\n🗑 Removing Expired Policies...");
        system.removeExpiredPolicies();

        System.out.println("\n📋 All Active Policies:");
        system.displayAllPolicies();
    }
}

