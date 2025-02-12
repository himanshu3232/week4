package org.capgemini.banking_system;

import java.util.*;

public class BankingSystem {
    private final Map<String, Double> accountMap = new HashMap<>(); // Stores accounts
    private final TreeMap<Double, List<String>> sortedAccounts = new TreeMap<>(); // Sorts by balance
    private final Queue<String> withdrawalQueue = new LinkedList<>(); // Processes withdrawals

    // Add a new account
    public void addAccount(String accountNumber, double balance) {
        accountMap.put(accountNumber, balance);
        sortedAccounts.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    // Deposit money into an account
    public void deposit(String accountNumber, double amount) {
        if (accountMap.containsKey(accountNumber)) {
            double oldBalance = accountMap.get(accountNumber);
            double newBalance = oldBalance + amount;

            accountMap.put(accountNumber, newBalance);

            // Update sortedAccounts
            sortedAccounts.get(oldBalance).remove(accountNumber);
            if (sortedAccounts.get(oldBalance).isEmpty()) {
                sortedAccounts.remove(oldBalance);
            }
            sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Request withdrawal (adds to queue)
    public void requestWithdrawal(String accountNumber) {
        if (accountMap.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println(" Withdrawal request added for: " + accountNumber);
        } else {
            System.out.println(" Account not found!");
        }
    }

    // Process withdrawal requests
    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            if (accountMap.get(accountNumber) >= amount) {
                withdraw(accountNumber, amount);
                System.out.println(" Withdrawn " + amount + " from " + accountNumber);
            } else {
                System.out.println(" Insufficient funds for " + accountNumber);
            }
        }
    }

    // Withdraw money from an account
    private void withdraw(String accountNumber, double amount) {
        double oldBalance = accountMap.get(accountNumber);
        double newBalance = oldBalance - amount;

        accountMap.put(accountNumber, newBalance);

        // Update sortedAccounts
        sortedAccounts.get(oldBalance).remove(accountNumber);
        if (sortedAccounts.get(oldBalance).isEmpty()) {
            sortedAccounts.remove(oldBalance);
        }
        sortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
    }

    // Display accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("\n Accounts sorted by balance:");
        sortedAccounts.forEach((balance, accounts) ->
                accounts.forEach(acc -> System.out.println("Account: " + acc + ", Balance: " + balance))
        );
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("ACC1001", 5000);
        bank.addAccount("ACC1002", 3000);
        bank.addAccount("ACC1003", 7000);
        bank.addAccount("ACC1004", 2000);

        bank.displaySortedAccounts();

        bank.deposit("ACC1002", 500);
        System.out.println("\n After deposit:");
        bank.displaySortedAccounts();

        bank.requestWithdrawal("ACC1001");
        bank.requestWithdrawal("ACC1003");

        System.out.println("\n Processing withdrawals (₹2000 each):");
        bank.processWithdrawals(2000);

        bank.displaySortedAccounts();
    }
}
