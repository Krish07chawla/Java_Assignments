package Java_Assignment6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Q1 {

    private static final String STUDENT_FILE = "students.txt";

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\nStudent File Manager");
                System.out.println("1. Add student record");
                System.out.println("2. Display student records");
                System.out.println("3. Copy a binary file");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                String choice = input.nextLine().trim();
                switch (choice) {
                    case "1":
                        addStudent(input);
                        break;
                    case "2":
                        displayStudents();
                        break;
                    case "3":
                        copyBinaryFile(input);
                        break;
                    case "4":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Choose 1, 2, 3, or 4.");
                }
            }
        }
    }

    private static void addStudent(Scanner input) {
        System.out.print("Student ID: ");
        String id = input.nextLine().trim();
        System.out.print("Student name: ");
        String name = input.nextLine().trim();
        System.out.print("Course: ");
        String course = input.nextLine().trim();

        try (FileWriter writer = new FileWriter(STUDENT_FILE, true)) {
            writer.write("ID: " + id + " | Name: " + name + " | Course: " + course);
            writer.write(System.lineSeparator());
            System.out.println("Student record saved to " + STUDENT_FILE + ".");
        } catch (IOException e) {
            System.err.println("Could not save the student record: " + e.getMessage());
        }
    }

    private static void displayStudents() {
        try (FileReader reader = new FileReader(STUDENT_FILE)) {
            char[] buffer = new char[1024];
            int charactersRead;
            System.out.println("\nStudent records:");
            while ((charactersRead = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, charactersRead));
            }
        } catch (IOException e) {
            System.err.println("Could not read student records: " + e.getMessage());
        }
    }

    private static void copyBinaryFile(Scanner input) {
        System.out.print("Source binary file: ");
        String source = input.nextLine().trim();
        System.out.print("Destination file: ");
        String destination = input.nextLine().trim();

        byte[] buffer = new byte[8192];
        try (FileInputStream reader = new FileInputStream(source);
             FileOutputStream writer = new FileOutputStream(destination)) {
            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);
            }
            System.out.println("Binary file copied to " + destination + ".");
        } catch (IOException e) {
            System.err.println("Could not copy the binary file: " + e.getMessage());
        }
    }
}
