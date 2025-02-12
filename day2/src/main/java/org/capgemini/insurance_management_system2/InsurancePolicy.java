package org.capgemini.insurance_management_system2;

import java.time.LocalDate;

public class InsurancePolicy {
    String policyNumber;
    String policyHolderName;
    LocalDate expiryDate;

    public InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyHolderName + ", Expiry: " + expiryDate;
    }
}