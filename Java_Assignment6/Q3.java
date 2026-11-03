package Java_Assignment6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3 {

    private static final String EMPLOYEE_FILE = "employees.dat";

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            List<Employee> employees = readEmployeesFromConsole(input);
            serializeEmployees(employees);
            displayEmployees();
        } catch (IOException e) {
            System.err.println("Could not process employee records: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid numeric input: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid employee count: " + e.getMessage());
        }
    }

    private static List<Employee> readEmployeesFromConsole(Scanner input) {
        System.out.print("Number of employees to enter: ");
        int count = Integer.parseInt(input.nextLine().trim());
        if (count < 0) {
            throw new IllegalArgumentException("The employee count cannot be negative.");
        }

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.println("\nEmployee " + (i + 1));
            System.out.print("Employee ID: ");
            int id = Integer.parseInt(input.nextLine().trim());
            System.out.print("Name: ");
            String name = input.nextLine().trim();
            System.out.print("Department: ");
            String department = input.nextLine().trim();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(input.nextLine().trim());
            employees.add(new Employee(id, name, department, salary));
        }
        return employees;
    }

    private static void serializeEmployees(List<Employee> employees) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(EMPLOYEE_FILE))) {
            output.writeObject(new ArrayList<>(employees));
        }
        System.out.println("Employee records saved to " + EMPLOYEE_FILE + ".");
    }

    private static void displayEmployees() throws IOException {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(EMPLOYEE_FILE))) {
            Object storedRecords;
            try {
                storedRecords = input.readObject();
            } catch (ClassNotFoundException e) {
                throw new IOException("The employee record class could not be found.", e);
            }

            if (!(storedRecords instanceof List<?>)) {
                throw new IOException("The file does not contain a list of employee records.");
            }

            System.out.println("\nDeserialized employee records:");
            for (Object record : (List<?>) storedRecords) {
                if (!(record instanceof Employee)) {
                    throw new IOException("The file contains an invalid employee record.");
                }
                System.out.println(record);
            }
        }
    }
}
