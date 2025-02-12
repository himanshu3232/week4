package org.capgemini.banking_system;

public class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Balance: " + balance;
    }
}
