package org.capgemini.annotations.advance.role_based_access_control;

// Class with restricted methods
public class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed successfully.");
    }
}
