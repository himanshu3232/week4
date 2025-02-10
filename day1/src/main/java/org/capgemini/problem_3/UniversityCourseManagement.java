package org.capgemini.problem_3;

import java.util.*;

// Abstract class representing a Course Type
abstract class CourseType {
    protected String name;
    protected String department;

    public CourseType(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

// Specific Course Types
class ExamCourse extends CourseType {
    public ExamCourse(String name, String department) {
        super(name, department);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name, String department) {
        super(name, department);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name, String department) {
        super(name, department);
    }
}

// Generic Course Management Class
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public void displayCourses() {
        for (T course : courses) {
            System.out.println(course);
        }
    }
}

// University Course Manager with Wildcards
class University {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

// Main Class for Testing
public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Mathematics", "Science"));
        examCourses.addCourse(new ExamCourse("Physics", "Engineering"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("History", "Arts"));
        assignmentCourses.addCourse(new AssignmentCourse("Economics", "Commerce"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research", "Computer Science"));
        researchCourses.addCourse(new ResearchCourse("Biomedical Innovations", "Medical"));

        System.out.println("Exam Courses:");
        examCourses.displayCourses();

        System.out.println("\nAssignment Courses:");
        assignmentCourses.displayCourses();

        System.out.println("\nResearch Courses:");
        researchCourses.displayCourses();
    }
}

