package org.capgemini.annotations.exercise.exercise5;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void main(String[] args) {
        try {
            // Get the SoftwareModule class
            Class<SoftwareModule> clazz = SoftwareModule.class;

            // Get the method with the annotations
            Method method = clazz.getMethod("processData");

            // Check for individual @BugReport annotations (Java 8+)
            if (method.isAnnotationPresent(BugReport.class)) {
                BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
                System.out.println("Bug Reports:");
                for (BugReport report : bugReports) {
                    System.out.println("- " + report.description());
                }
            }

            // Check if the method has the container annotation (alternative approach)
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReportsContainer = method.getAnnotation(BugReports.class);
                System.out.println("\nBug Reports (Using Container):");
                for (BugReport report : bugReportsContainer.value()) {
                    System.out.println("- " + report.description());
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
