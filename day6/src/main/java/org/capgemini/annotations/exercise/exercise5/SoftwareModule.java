package org.capgemini.annotations.exercise.exercise5;

public class SoftwareModule {

    // Applying @BugReport multiple times on the same method
    @BugReport(description = "NullPointerException occurs on empty input")
    @BugReport(description = "Performance issue with large data sets")
    public void processData() {
        System.out.println("Processing...");
    }
}
