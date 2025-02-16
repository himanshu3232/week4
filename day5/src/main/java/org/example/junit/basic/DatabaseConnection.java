package org.example.junit.basic;

public class DatabaseConnection {
    private boolean isConnected;

    // Simulates connecting to a database
    public void connect() {
        isConnected = true;
    }

    // Simulates disconnecting from a database
    public void disconnect() {
        isConnected = false;
    }

    public boolean isConnected() {
        return isConnected;
    }
}