package org.capgemini.serialization;

import java.io.*;
import java.util.*;

// Employee class implementing Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Overriding toString() for better display
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeSerialization {
    private static final String FILE_NAME = "employees.ser";

    // Method to serialize employee list
    public static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize employee list
    public static List<Employee> deserializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees have been deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }

    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 60000));
        employees.add(new Employee(2, "Jane Smith", "HR", 55000));
        employees.add(new Employee(3, "Mike Brown", "Finance", 70000));

        // Serialize the list of employees
        serializeEmployees(employees);

        // Deserialize and display employees
        List<Employee> deserializedEmployees = deserializeEmployees();
        deserializedEmployees.forEach(System.out::println);
    }
}
