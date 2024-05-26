package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CourseTest {

    @Test
    void testCalcStudentsAverage() {
        Department department = new Department("Computer Science");

        Address address1 = new Address(123, "New St", "Toronto", "ON",
                "A1B 3C4", "Canada");
        Address address2 = new Address(456, "Old St", "Toronto", "ON",
                "A1B 3C4", "Canada");
        Address address3 = new Address(789, "Wise St", "Toronto", "ON",
                "A1B 3C9", "Canada");

        Student student1 = new Student("Jane", Gender.FEMALE, address1, department);
        Student student2 = new Student("Bill", Gender.MALE, address2, department);
        Student student3 = new Student("Max", Gender.MALE, address3, department);

        Course course = new Course();
        course.setCourseName("Introduction to Programming");
        course.setCredits(3.0);
        course.setDepartment(department);

        course.registerStudent(student1);
        course.registerStudent(student2);
        course.registerStudent(student3);

        course.addAssignment("Assignment 1", 0.3, 100);
        course.addAssignment("Assignment 2", 0.4, 100);
        course.addAssignment("Assignment 3", 0.3, 100);

        Assignment[] assignments = course.getAssignments();
        assignments[0].setScores(new ArrayList<>(List.of(80, 90, 70)));
        assignments[1].setScores(new ArrayList<>(List.of(70, 85, 75)));
        assignments[2].setScores(new ArrayList<>(List.of(85, 80, 90)));

        int[] expectedAverages = {78, 85, 78};
        Assertions.assertArrayEquals(expectedAverages, course.calcStudentsAverage());
    }

    @Test
    void testCalcStudentsAverageAllZeros() {
        Department department = new Department("Computer Science");


        Address address1 = new Address(123, "New St", "Toronto", "ON",
                "A1B 3C4", "Canada");
        Address address2 = new Address(456, "Old St", "Toronto", "ON",
                "A1B 3C4", "Canada");
        Address address3 = new Address(789, "Wise St", "Toronto", "ON",
                "A1B 3C9", "Canada");


        Student student1 = new Student("Jane", Gender.FEMALE, address1, department);
        Student student2 = new Student("Bill", Gender.MALE, address2, department);
        Student student3 = new Student("Max", Gender.MALE, address3, department);


        Course course = new Course();
        course.setCourseName("Introduction to Programming");
        course.setCredits(3.0);
        course.setDepartment(department);

        course.registerStudent(student1);
        course.registerStudent(student2);
        course.registerStudent(student3);


        course.addAssignment("Assignment 1", 0.3, 100);
        course.addAssignment("Assignment 2", 0.4, 100);
        course.addAssignment("Assignment 3", 0.3, 100);


        Assignment[] assignments = course.getAssignments();
        assignments[0].setScores(new ArrayList<>(List.of(0, 0, 0)));
        assignments[1].setScores(new ArrayList<>(List.of(0, 0, 0)));
        assignments[2].setScores(new ArrayList<>(List.of(0, 0, 0)));


        int[] expectedAverages = {0, 0, 0};
        Assertions.assertArrayEquals(expectedAverages, course.calcStudentsAverage());
    }

    @Test
    void testCalcStudentsAverageDifferentScores() {
        Department department = new Department("Computer Science");

        Address address1 = new Address(123, "New St", "Toronto", "ON",
                "A1B 3C4", "Canada");
        Address address2 = new Address(456, "Old St", "Toronto", "ON",
                "A1B 3C4", "Canada");
        Address address3 = new Address(789, "Wise St", "Toronto", "ON",
                "A1B 3C9", "Canada");


        Student student1 = new Student("Jane", Gender.FEMALE, address1, department);
        Student student2 = new Student("Bill", Gender.MALE, address2, department);
        Student student3 = new Student("Max", Gender.MALE, address3, department);


        Course course = new Course();
        course.setCourseName("Introduction to Programming");
        course.setCredits(3.0);
        course.setDepartment(department);

        course.registerStudent(student1);
        course.registerStudent(student2);
        course.registerStudent(student3);

        course.addAssignment("Assignment 1", 0.3, 100);
        course.addAssignment("Assignment 2", 0.4, 100);
        course.addAssignment("Assignment 3", 0.3, 100);


        Assignment[] assignments = course.getAssignments();
        assignments[0].setScores(new ArrayList<>(List.of(60, 80, 90)));
        assignments[1].setScores(new ArrayList<>(List.of(50, 70, 85)));
        assignments[2].setScores(new ArrayList<>(List.of(40, 60, 75)));

        int[] expectedAverages = {50, 70, 83};
        Assertions.assertArrayEquals(expectedAverages, course.calcStudentsAverage());
    }
}
