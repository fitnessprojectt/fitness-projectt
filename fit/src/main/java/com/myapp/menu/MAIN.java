package com.myapp.menu;

import fit.MyApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MAIN {
    private static Map<String, String> clientsMap = new HashMap<>();
    private static Map<String, String> instructorsMap = new HashMap<>();

    public static void main(String[] args) {
        MyApplication app = new MyApplication();
        app.runApplication();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Fitness Management System ===");
            System.out.println("1. Admin Features");
            System.out.println("2. Instructor Features");
            System.out.println("3. Client Features");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = validateInput(scanner);

            switch (choice) {
                case 1:
                    handleAdminFeatures(scanner, app);
                    break;
                case 2:
                    handleInstructorFeatures(scanner);
                    break;
                case 3:
                    handleClientFeatures(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // دالة تسجيل الدخول
    private static void login(Scanner scanner, MyApplication app) {
        List<String[]> accounts = new ArrayList<>();
        accounts.add(new String[]{"jana", "pass123"});
        accounts.add(new String[]{"enas", "pass456"});
        accounts.add(new String[]{"amjad", "pass789"});

        boolean loginSuccessful = false;
        while (!loginSuccessful) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            for (String[] account : accounts) {
                if (account[0].equals(username) && account[1].equals(password)) {
                    loginSuccessful = true;
                    System.out.println("Login successful!");
                    break;
                }
            }

            if (!loginSuccessful) {
                System.out.println("Incorrect username or password. Please try again.");
            }
        }
    }

    //////////////////////////// Admin Features ////////////////////////////

    private static void handleAdminFeatures(Scanner scanner, MyApplication app) {
        System.out.print("Enter Admin username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Admin password: ");
        String password = scanner.nextLine();

        if (app.loginAsAdmin(username, password)) {
            System.out.println("Logged in successfully as Admin.");
            AdminMenu(scanner, app);
        } else {
            System.out.println("Invalid Admin username or password.");
        }
    }

    private static void AdminMenu(Scanner scanner, MyApplication app) {
        while (true) {
            System.out.println("\n--- Admin Features ---");
            System.out.println("1. User Management");
            System.out.println("2. Program Monitoring");
            System.out.println("3. Content Management");
            System.out.println("4. Subscription Management");
            System.out.println("5. Exit Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = validateInput(scanner);

            switch (choice) {
                case 1:
                    UserManagementMenu(scanner, app);
                    break;
                case 2:
                    System.out.println("Program Monitoring selected.");
                    break;
                case 3:
                    System.out.println("Content Management selected.");
                    break;
                case 4:
                    System.out.println("Subscription Management selected.");
                    break;
                case 5:
                    System.out.println("Exiting Admin Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void UserManagementMenu(Scanner scanner, MyApplication app) {
        while (true) {
            System.out.println("\n--- User Management ---");
            System.out.println("1. Add Instructor");
            System.out.println("2. Update Instructor");
            System.out.println("3. Deactivate Instructor");
            System.out.println("4. Add Client");
            System.out.println("5. Update Client");
            System.out.println("6. Deactivate Client");
            System.out.println("7. Approve New Instructor Registrations");
            System.out.println("8. Monitor User Activity");
            System.out.println("9. Return to Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = validateInput(scanner);

            switch (choice) {
                case 1:
                    addInstructor(scanner);
                    break;
                case 2:
                    updateInstructor(scanner);
                    break;
                case 3:
                    deactivateInstructor(scanner);
                    break;
                case 4:
                    addClient(scanner);
                    break;
                case 5:
                    updateClient(scanner);
                    break;
                case 6:
                    deactivateClient(scanner);
                    break;
                case 7:
                    approveInstructorRegistration(scanner);
                    break;
                case 8:
                    monitorUserActivity(app);
                    break;
                case 9:
                    System.out.println("Returning to Admin Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //////////////////////////// دوال العملاء ////////////////////////////

    private static void handleClientFeatures(Scanner scanner) {
        System.out.println("Client features are not implemented yet.");
    }

    //////////////////////////// دوال المدربين ////////////////////////////

    private static void handleInstructorFeatures(Scanner scanner) {
        System.out.println("Instructor features are not implemented yet.");
    }

    //////////////////////////// وظائف المساعدة ////////////////////////////

    private static void addInstructor(Scanner scanner) {
        System.out.print("Enter instructor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter instructor password: ");
        String password = scanner.nextLine();
        instructorsMap.put(name, password);
        System.out.println("Instructor added successfully!");
    }

    private static void updateInstructor(Scanner scanner) {
        System.out.print("Enter instructor name: ");
        String name = scanner.nextLine();
        if (instructorsMap.containsKey(name)) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            instructorsMap.put(name, newPassword);
            System.out.println("Instructor updated successfully!");
        } else {
            System.out.println("Instructor not found.");
        }
    }

    private static void deactivateInstructor(Scanner scanner) {
        System.out.print("Enter instructor name: ");
        String name = scanner.nextLine();
        if (instructorsMap.remove(name) != null) {
            System.out.println("Instructor deactivated successfully!");
        } else {
            System.out.println("Instructor not found.");
        }
    }

    private static void addClient(Scanner scanner) {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client password: ");
        String password = scanner.nextLine();
        clientsMap.put(name, password);
        System.out.println("Client added successfully!");
    }

    private static void updateClient(Scanner scanner) {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        if (clientsMap.containsKey(name)) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            clientsMap.put(name, newPassword);
            System.out.println("Client updated successfully!");
        } else {
            System.out.println("Client not found.");
        }
    }

    private static void deactivateClient(Scanner scanner) {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        if (clientsMap.remove(name) != null) {
            System.out.println("Client deactivated successfully!");
        } else {
            System.out.println("Client not found.");
        }
    }

    private static void approveInstructorRegistration(Scanner scanner) {
        System.out.println("Approve Instructor Registration functionality is not implemented yet.");
    }

    private static void monitorUserActivity(MyApplication app) {
        System.out.println("Monitor User Activity functionality is not implemented yet.");
    }

    private static int validateInput(Scanner scanner) {
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            return choice;
        } else {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
}
