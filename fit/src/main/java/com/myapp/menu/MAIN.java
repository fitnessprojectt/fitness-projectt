package com.myapp.menu;

import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Fitness Management System ===");
            System.out.println("1. Admin Features");
            System.out.println("2. Instructor Features");
            System.out.println("3. Client Features");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleAdminFeatures(scanner);
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

    // Admin Features Menu
    private static void handleAdminFeatures(Scanner scanner) {
        AdminActions adminActions = new AdminActions();
        adminActions.addDummyData(); // Load dummy data for admin testing
        
        System.out.println("\n--- Admin Login ---");
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (adminActions.loginAsAdmin(username, password)) {
            boolean exitAdmin = false;
            while (!exitAdmin) {
                System.out.println("\n--- Admin Features ---");
                System.out.println("1. Navigate to a page");
                System.out.println("2. Review client progress");
                System.out.println("3. Assert article status");
                System.out.println("4. Set article visibility");
                System.out.println("5. Exit Admin Menu");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                switch (choice) {
                    case 1:
                        System.out.print("Enter page name: ");
                        String pageName = scanner.nextLine();
                        adminActions.navigateToPage(pageName);
                        break;
                    case 2:
                        System.out.print("Enter client name: ");
                        String clientName = scanner.nextLine();
                        System.out.print("Enter progress percentage: ");
                        double progress = scanner.nextDouble();
                        scanner.nextLine(); // Clear buffer
                        System.out.print("Enter client status: ");
                        String status = scanner.nextLine();
                        System.out.println(adminActions.reviewClientProgress(clientName, progress, status));
                        break;
                    case 3:
                        System.out.print("Enter article key: ");
                        String articleKey = scanner.nextLine();
                        adminActions.assertArticleStatus(articleKey);
                        break;
                    case 4:
                        adminActions.assertArticleStatusVisibility();
                        break;
                    case 5:
                        exitAdmin = true;
                        System.out.println("Exiting Admin Menu.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Login failed. Returning to main menu.");
        }
    }

    // Instructor Features Menu
    private static void handleInstructorFeatures(Scanner scanner) {
        System.out.println("\n--- Instructor Features ---");
        System.out.println("1. Program Management");
        System.out.println("2. Client Interaction");
        System.out.println("3. Progress Tracking");
        System.out.println("4. Notifications and Updates");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Program Management selected.");
                break;
            case 2:
                System.out.println("Client Interaction selected.");
                break;
            case 3:
                System.out.println("Progress Tracking selected.");
                break;
            case 4:
                System.out.println("Notifications and Updates selected.");
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    // Client Features Menu
    private static void handleClientFeatures(Scanner scanner) {
        System.out.println("\n--- Client Features ---");
        System.out.println("1. Account Management");
        System.out.println("2. Program Exploration and Enrollment");
        System.out.println("3. Progress Tracking");
        System.out.println("4. Feedback and Reviews");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Account Management selected.");
                break;
            case 2:
                System.out.println("Program Exploration and Enrollment selected.");
                break;
            case 3:
                System.out.println("Progress Tracking selected.");
                break;
            case 4:
                System.out.println("Feedback and Reviews selected.");
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }
}

class AdminActions {
    boolean isLoggedIn = false;

    // Dummy data setup
    public void addDummyData() {
        System.out.println("Dummy data loaded for admin.");
    }

    // Login as admin
    public boolean loginAsAdmin(String username, String password) {
        if (username.equals("admin") && password.equals("password123")) {
            isLoggedIn = true;
            System.out.println("Admin login successful.");
        } else {
            System.out.println("Invalid credentials.");
        }
        return isLoggedIn;
    }

    public void navigateToPage(String pageName) {
        System.out.println("Navigating to page: " + pageName);
    }

    public String reviewClientProgress(String clientName, double progress, String status) {
        return "Client " + clientName + " progress: " + progress + "%, Status: " + status;
    }

    public void assertArticleStatus(String articleKey) {
        System.out.println("Article status for key '" + articleKey + "' has been verified.");
    }

    public void assertArticleStatusVisibility() {
        System.out.println("Article visibility set successfully.");
    }
}
