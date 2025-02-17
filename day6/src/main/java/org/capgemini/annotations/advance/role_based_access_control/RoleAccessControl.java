package org.capgemini.annotations.advance.role_based_access_control;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Access control logic
public class RoleAccessControl {
    public static void main(String[] args) throws Exception {
        SecureService service = new SecureService();
        executeMethodIfAllowed(service, "adminTask");

        // Change user role and retry
        UserContext.setRole("ADMIN");
        executeMethodIfAllowed(service, "adminTask");
    }

    private static void executeMethodIfAllowed(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();
                if (UserContext.getRole().equals(requiredRole)) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied!");
                }
            } else {
                method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

