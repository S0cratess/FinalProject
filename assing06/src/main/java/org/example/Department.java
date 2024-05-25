package org.example;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public String getDepartmentName() {
        return departmentName;
    }

    //all argument constructor
    public Department(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = generateDepartmentId();
            this.departmentName = departmentName;
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * validates a department name
     * @param departmentName department name to be validated
     * @return true if the department name is valid if not false
     */
    public static boolean validateDepartmentName(String departmentName) {
        if (departmentName == null) return false;

        for (char i : departmentName.toCharArray()) {
            if (!Character.isLetter(i) && i != ' ') {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets the next available department ID
     * @return the next available department ID
     */
    public static int getNextId() {
        return nextId;
    }

    private String generateDepartmentId() {
        return "D" + String.format("%02d", nextId++);
    }
}
