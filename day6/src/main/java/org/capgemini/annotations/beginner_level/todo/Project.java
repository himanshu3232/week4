package org.capgemini.annotations.beginner_level.todo;

// Sample class using @Todo annotation
public class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void authenticateUser() {
        // Authentication logic
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeQueries() {
        // Query optimization logic
    }

    @Todo(task = "Enhance UI responsiveness", assignedTo = "Charlie", priority = "LOW")
    public void improveUI() {
        // UI enhancement logic
    }
}