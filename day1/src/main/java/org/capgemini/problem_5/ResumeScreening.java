package org.capgemini.problem_5;

import java.util.*;

// Abstract JobRole class
abstract class JobRole {
    protected String candidateName;
    protected int experience;

    public JobRole(String candidateName, int experience) {
        this.candidateName = candidateName;
        this.experience = experience;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return candidateName + " - " + experience + " years experience";
    }
}

// Specific Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experience) {
        super(candidateName, experience);
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experience) {
        super(candidateName, experience);
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experience) {
        super(candidateName, experience);
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public void displayResumes() {
        for (T resume : resumes) {
            System.out.println(resume);
        }
    }
}

// AI Screening System with Wildcards
class AIScreeningSystem {
    public static void processResumes(List<? extends JobRole> resumes) {
        System.out.println("Processing resumes:");
        for (JobRole resume : resumes) {
            System.out.println("Screening: " + resume);
        }
    }
}

// Main Class for Testing
public class ResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResumes = new Resume<>();
        seResumes.addResume(new SoftwareEngineer("Alice", 5));
        seResumes.addResume(new SoftwareEngineer("Bob", 3));

        Resume<DataScientist> dsResumes = new Resume<>();
        dsResumes.addResume(new DataScientist("Charlie", 4));
        dsResumes.addResume(new DataScientist("David", 2));

        Resume<ProductManager> pmResumes = new Resume<>();
        pmResumes.addResume(new ProductManager("Eve", 6));
        pmResumes.addResume(new ProductManager("Frank", 5));

        System.out.println("Software Engineer Resumes:");
        seResumes.displayResumes();

        System.out.println("\nData Scientist Resumes:");
        dsResumes.displayResumes();

        System.out.println("\nProduct Manager Resumes:");
        pmResumes.displayResumes();

        System.out.println("\nAI Screening Process:");
        List<JobRole> allResumes = Arrays.asList(
                new SoftwareEngineer("Alice", 5),
                new DataScientist("Charlie", 4),
                new ProductManager("Eve", 6)
        );
        AIScreeningSystem.processResumes(allResumes);
    }
}
