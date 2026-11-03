package Java_Assignment6;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int employeeId;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(int employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId
                + ", Name: " + name
                + ", Department: " + department
                + ", Salary: " + salary;
    }
}
