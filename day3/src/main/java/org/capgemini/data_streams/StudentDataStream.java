package org.capgemini.data_streams;

import java.io.*;

public class StudentDataStream {
    private static final String FILE_NAME = "students.dat";

    // Method to store student data
    public static void storeStudentData(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME, true))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data stored successfully.");
        } catch (IOException e) {
            System.err.println("Error writing student data: " + e.getMessage());
        }
    }

    // Method to retrieve student data
    public static void retrieveStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.err.println("Error reading student data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Storing student data
        storeStudentData(101, "John Doe", 3.8);
        storeStudentData(102, "Jane Smith", 3.9);
        storeStudentData(103, "Mike Brown", 3.7);

        // Retrieving student data
        System.out.println("\nRetrieved Student Data:");
        retrieveStudentData();
    }
}

