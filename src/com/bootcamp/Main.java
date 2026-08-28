package com.bootcamp;

import com.bootcamp.model.Student;
import com.bootcamp.service.StudentService;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static StudentService service = new StudentService();

    // TODO: Day 1 - AI Practice (Code Exploration)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("========================================");
        System.out.println(" Welcome to Student Management System ");
        System.out.println("========================================");

        while (running) {
            printMenu();
            System.out.print("Select an option: ");
            
            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input type!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    listAllStudents();
                    break;
                case 2:
                    addNewStudentUI(scanner);
                    break;
                case 3:
                    triggerSearchUI(scanner);
                    break;
                case 4:
                    System.out.println("Average GPA: " + service.calculateAverageGpa());
                    break;
                case 9:
                    // DAY 9 TARGET: Extensibility Hook
                    runCustomTeamModule(scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. View All Students");
        System.out.println("2. Add New Student");
        System.out.println("3. Find Student by ID (Buggy)");
        System.out.println("4. Display Class GPA Average (Buggy)");
        System.out.println("9. Custom Team Module (Day 9 Challenge)");
        System.out.println("0. Exit");
    }

    // TODO: Day 9 - AI Practice (Autonomous Feature Customization)
    private static void runCustomTeamModule(Scanner scanner) {
        System.out.println("\n[Day 9 Feature Module Placeholder]");
        System.out.println("Use AI to implement your assigned domain module (e.g., Attendance, Fees, Teacher Management).");
    }

    private static void listAllStudents() {
        List<Student> students = service.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Student s : students) {
            s.printInfo();
        }
    }

    private static void addNewStudentUI(Scanner scanner) {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter GPA: ");
        double gpa = Double.parseDouble(scanner.nextLine());

        service.addStudent(new Student(id, name, email, gpa));
        System.out.println("Student added successfully!");
    }

    private static void triggerSearchUI(Scanner scanner) {
        System.out.print("Enter Student ID to Search: ");
        String id = scanner.nextLine();
        
        Student result = service.findStudentById(id);
        if (result != null) {
            result.printInfo();
        } else {
            System.out.println("Student not found.");
        }
    }
}