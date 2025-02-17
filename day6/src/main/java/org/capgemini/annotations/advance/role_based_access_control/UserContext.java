package org.capgemini.annotations.advance.role_based_access_control;

// Simulated user role
public class UserContext {
    private static String currentUserRole = "USER"; // Default role

    public static void setRole(String role) {
        currentUserRole = role;
    }

    public static String getRole() {
        return currentUserRole;
    }
}