package org.example;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private Assignment[] assignments;
    private List<Student> registeredStudents; // Changed from Student[] to List<Student>
    private double[] finalScores;
    private static int nextId = 1;

    public Course() {
        this.registeredStudents = new ArrayList<>();
    }

    public boolean isAssignmentWeightValid() {
        double totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 1.0;
    }

    /**
     * registers a student to a course
     * @param student the student to register
     * @return true if succesfully registered, false if not
     */
    public boolean registerStudent(Student student) {
        if (!isStudentRegistered(student)) {
            registeredStudents.add(student);
            return true;
        }
        return false;
    }

    public boolean dropStudent(Student student) {
        return registeredStudents.remove(student);
    }

    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];
        for (int i = 0; i < registeredStudents.size(); i++) {
            int sum = 0;
            for (Assignment assignment : assignments) {
                sum += assignment.getScores().get(i);
            }
            averages[i] = sum / assignments.length;
        }
        return averages;
    }

    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        if (assignments == null) {
            assignments = new Assignment[0];
        }
        Assignment[] newAssignments = new Assignment[assignments.length + 1];
        System.arraycopy(assignments, 0, newAssignments, 0, assignments.length);
        newAssignments[newAssignments.length - 1] = new Assignment(assignmentName, weight, maxScore);
        assignments = newAssignments;
        return true;
    }

    public void generateScores() {
    }

    public void displayScores() {
    }

    public String toSimplifiedString() {
        return "Course ID: " + courseId + ", Course Name: " + courseName + ", Credits: " + credits +
                ", Department: " + department.getDepartmentName();
    }

    public String toString() {
        String result = "Course ID: " + courseId + "\n";
        result += "Course Name: " + courseName + "\n";
        result += "Credits: " + credits + "\n";
        result += "Department: " + department.getDepartmentName() + "\n";
        result += "Assignments: " + "\n";
        for (Assignment assignment : assignments) {
            result += assignment + "\n";
        }
        result += "Registered Students: " + "\n";
        for (Student student : registeredStudents) {
            result += "Student ID: " + student.getStudentId() + ", Student Name: " + student.getStudentName() +
                    ", Department: " + student.getDepartment().getDepartmentName() + "\n";
        }
        return result;
    }

    private boolean isStudentRegistered(Student student) {
        return registeredStudents.contains(student);
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCredits() {
        return credits;
    }

    public Department getDepartment() {
        return department;
    }

    public Assignment[] getAssignments() {
        return assignments;
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setAssignments(Assignment[] assignments) {
        this.assignments = assignments;
    }

    public void setRegisteredStudents(List<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public void setFinalScores(double[] finalScores) {
        this.finalScores = finalScores;
    }

    public static void setNextId(int nextId) {
        Course.nextId = nextId;
    }

    public double[] getFinalScores() {
        return finalScores;
    }

    public static int getNextId() {
        return nextId;
    }
}
