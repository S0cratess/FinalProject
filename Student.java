package org.example;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = generateStudentId();
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
            course.getRegisteredStudents().add(this);
            for (Assignment assignment : course.getAssignments()) {
                assignment.getScores().add(null);
            }
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.getRegisteredStudents().remove(this);
            return true;
        }
        return false;
    }

    public String toSimplifiedString() {
        return "Student ID: " + studentId + ", Student Name: " + studentName
                + ", Department: " + department.getDepartmentName();
    }

    public String toString() {
        String result = "Student ID: " + studentId + "\n";
        result += "Student Name: " + studentName + "\n";
        result += "Gender: " + gender + "\n";
        result += "Address: " + address + "\n";
        result += "Department: " + department.getDepartmentName() + "\n";
        result += "Registered Courses: " + "\n";
        for (Course course : registeredCourses) {
            result += "Course ID: " + course.getCourseId() + ", Course Name: " + course.getCourseName()
                    + ", Department: " + course.getDepartment().getDepartmentName() + "\n";
        }
        return result;
    }

    private String generateStudentId() {
        return "S" + String.format("%06d", nextId++);
    }

    public String getStudentId() {
        return studentId;
    }

    public Department getDepartment() {
        return department;
    }

    public String getStudentName() {
        return studentName;
    }
}
