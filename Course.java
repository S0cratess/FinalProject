package org.example;


import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private Assignment[] assignments;
    private Student[] registeredStudents;
    private double[] finalScores;
    private static int nextId = 1;

    public boolean isAssignmentWeightValid() {
        double totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 1.0;
    }

    public boolean registerStudent(Student student) {
        if (!isStudentRegistered(student)) {
            Student[] newRegisteredStudents = new Student[registeredStudents.length + 1];
            System.arraycopy(registeredStudents, 0, newRegisteredStudents, 0, registeredStudents.length);
            newRegisteredStudents[newRegisteredStudents.length - 1] = student;
            registeredStudents = newRegisteredStudents;
            return true;
        }
        return false;
    }

    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.length];
        for (int i = 0; i < registeredStudents.length; i++) {
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
        for (Student s : registeredStudents) {
            if (s.getStudentId().equals(student.getStudentId())) {
                return true;
            }
        }
        return false;
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

    public Student[] getRegisteredStudents() {
        return registeredStudents;
    }

    public double[] getFinalScores() {
        return finalScores;
    }

    public static int getNextId() {
        return nextId;
    }
}
