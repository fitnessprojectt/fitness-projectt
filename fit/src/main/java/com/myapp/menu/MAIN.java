package com.myapp.menu;
import fit.Admin;
import fit.Clienttt;
import fit.Instructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import fit.Clienttt.ClientProfile;
import fit.Clienttt.Client;


public class MAIN {
    private static Map<String, String> clientsMap = new HashMap<>();
    private static Map<String, String> instructorsMap = new HashMap<>();
	private static Map<String, String> accounts= new HashMap<>();
    public static void main(String[] args) {
    	MAIN app = new MAIN();
        Admin app1 = new Admin();
        Instructor app2 = new Instructor();
        Clienttt app3 = new Clienttt();

        app1.runApplication();

        Scanner scanner = new Scanner(System.in);
  
        
        app2.addProgramToClient("client1", "Yoga Basics");
        app2.markSessionAsCompleted("client1", "Yoga Basics", true); 

        app2.addProgramToClient("client2", "Advanced Cardio");
        app2.markSessionAsCompleted("client2", "Advanced Cardio", false); 

        app1.runApplication();
        boolean exit = false;
        
        app2.sendMessageToClient("client1", "Welcome to the fitness program!");
        app2.sendMessageToClient("client1", "Your next session is scheduled for tomorrow.");

        app2.provideFeedbackToClient("client1", "Great progress, keep it up!");

        app2.viewMessagesForClient("client1","report");

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
                    handleAdminFeatures(scanner, app1);
                    break;
                case 2:
                    handleInstructorFeatures(scanner,app2);
                    break;
                case 3:
                	handleClientFeatures(scanner,app3);
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


    private static void login(Scanner scanner, Clienttt app3) {
        // إعداد الحسابات
        accounts.put("yumna", "pass123");
        accounts.put("enas", "pass456");
        accounts.put("amjad", "pass789");

        boolean loginSuccessful = false;
        while (!loginSuccessful) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // تحقق باستخدام HashMap
            if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
                loginSuccessful = true;
                System.out.println("Login successful!");
            } else {
                System.out.println("Incorrect username or password. Please try again.");
            }
        }
    }
   

    private static void handleAdminFeatures(Scanner scanner, Admin app1) {
        System.out.print("Enter Admin username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Admin password: ");
        String password = scanner.nextLine();

        if (app1.loginAsAdmin(username, password)) {
            System.out.println("Logged in successfully as Admin.");
            AdminMenu(scanner, app1);
        } else {
            System.out.println("Invalid Admin username or password.");
        }
    }

    private static void AdminMenu(Scanner scanner, Admin app1) {
        while (true) {
            System.out.println("\n--- Admin Features ---");
            System.out.println("1. User Management");
            System.out.println("2. Content Management");
            System.out.println("4. Subscription Management");
            System.out.println("5. Exit Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = validateInput(scanner);

            switch (choice) {
                case 1:
                    UserManagementMenu(scanner, app1);
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

    
    
    private static void UserManagementMenu(Scanner scanner, Admin app1) {
        while (true) {
            System.out.println("\n--- User Management ---");
            System.out.println("1. Add Instructor");
            System.out.println("2. Update Instructor");
            System.out.println("3. Deactivate Instructor");
            System.out.println("4. Add Client");
            System.out.println("5. Update Client");
            System.out.println("6. Deactivate Client");
            System.out.println("7. Submit Tip"); 
            System.out.println("8. Reject Tip");
            System.out.println("9. Approve Tip");
            System.out.println("10. Return to Admin Menu");
            System.out.print("Enter your choice: ");
            int choice = validateInput(scanner);

            switch (choice) {
                case 1:
                   app1.addInstructor(scanner);
                    break;
                case 2:
                  app1.updateInstructor(scanner);
                    break;
                case 3:
                 app1.deactivateInstructor(scanner);
                    break;
                case 4:
                	app1.addClient(scanner);
                    break;
                case 5:
                    app1.updateClient(scanner);
                    break;
                case 6:
                    app1.deactivateClient(scanner);
                    break;
             
                case 7:
                    System.out.print("Enter the content of the tip to submit: ");
                    String tipToSubmit = scanner.nextLine();
                    app1.submitTip(tipToSubmit);
                    break;
             
                case 8:
                    System.out.print("Enter the content of the tip to reject: ");
                    String tipToReject = scanner.nextLine();
                    app1.rejectTip(tipToReject);
                    break;
                case 9:
                    System.out.print("Enter the content of the tip to approve: ");
                    String tipToApprove = scanner.nextLine();
                    app1.approveTip(tipToApprove);
                    break;
                case 10:
                    System.out.println("Returning to Admin Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


   

  

    private static void handleClientFeatures(Scanner scanner, Clienttt app3) {
    	   
        login(scanner, app3);
       
        while (true) {
            System.out.println("\n--- Client Features ---");
            System.out.println("1. Account Management");
            System.out.println("2. Program Exploration and Enrollment");
            System.out.println("3. Progress Tracking");
            System.out.println("4. Feedback and Reviews");
            System.out.println("5. Exit");
            System.out.print("Enter command number: ");
            int command = scanner.nextInt();
            scanner.nextLine(); 

            switch (command) {
                case 1:
                    accountManagement(scanner, app3);
                    break;
                case 2:
                    programExplorationAndEnrollment(scanner, app3);
                    break;
                case 3:
                    progressTracking(scanner, app3);
                    break;
                case 4:
                	feedbackAndReviews(scanner, app3);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }        
    
    private static void accountManagement(Scanner scanner, Clienttt app3) {
        while (true) {
            System.out.println("\n--- Account Management ---");
            System.out.println("1. Create Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. View Profile");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int subcommand = scanner.nextInt();
            scanner.nextLine(); 

            if (subcommand == 4) {
                break; 
            }

            switch (subcommand) {
                case 1:
                    createProfile(scanner, app3);
                    break;
                case 2:
                    updateProfile(scanner, app3);
                    break;
                case 3:
                    viewProfile(app3);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void createProfile(Scanner scanner, Clienttt app3) {
        System.out.println("\n*** Create Profile ***");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        app3.getClientProfile().setName(name);

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        app3.getClientProfile().setAge(age);

        System.out.print("Enter your fitness goals (Weight Loss / Muscle Gain / General Fitness / Flexibility and Mobility / Mental Well-being): ");
        String fitnessGoals = scanner.nextLine();
        app3.getClientProfile().setFitnessGoals(fitnessGoals);

        System.out.print("Enter dietary preferences or restrictions (Vegetarian / Vegan / Gluten-Free / Low-Carb / Keto): ");
        String dietaryPreferences = scanner.nextLine();
        app3.getClientProfile().setDietaryPreferences(dietaryPreferences);

        System.out.println("Profile created successfully!");
    }

    private static void updateProfile(Scanner scanner, Clienttt app3) {
        System.out.println("\n*** Update Profile ***");
        System.out.println("Select field to update: ");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Fitness goals");
        System.out.println("4. Dietary preferences");
        System.out.print("Enter choice: ");
        int updateChoice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter new value: ");
        String newValue = scanner.nextLine();

        switch (updateChoice) {
            case 1:
                app3.getClientProfile().setName(newValue);
                break;
            case 2:
                app3.getClientProfile().setAge(Integer.parseInt(newValue));
                break;
            case 3:
                app3.getClientProfile().setFitnessGoals(newValue);
                break;
            case 4:
                app3.getClientProfile().setDietaryPreferences(newValue);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("Profile updated successfully!");
    }


    private static void viewProfile(Clienttt app3) {
        System.out.println("\n*** View Profile ***");
        ClientProfile profile = app3.getClientProfile();
        if (profile != null) {
            System.out.println("Name: " + profile.getName());
            System.out.println("Age: " + profile.getAge());
            System.out.println("Fitness Goals: " + profile.getFitnessGoals());
            System.out.println("Dietary Preferences: " + profile.getDietaryPreferences());
        } else {
            System.out.println("Profile not created yet.");
        }
    }

    
 
  
    public static void programExplorationAndEnrollment(Scanner scanner, Clienttt app3) {
        while (true) {
            System.out.println("\n--- Program Exploration and Enrollment ---");
            System.out.println("1. Browse Programs by Difficulty");
            System.out.println("2. Browse Programs by Focus Area");
            System.out.println("3. Enroll in a Program");
            System.out.println("4. View Program Schedule");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                	System.out.println("\n*** Browse Programs by Difficulty ***");
                    System.out.print("Enter difficulty level (Beginner, Intermediate, Advanced): ");
                    String difficulty = scanner.nextLine();
                    List<String> programsByDifficulty = app3.filterProgramsByDifficulty(difficulty);
                    System.out.println("Programs:");
                    for (String program : programsByDifficulty) {
                        System.out.println(program);
                    }
                    break;
                case 2:
                	System.out.println("\n*** Browse Programs by Focus Area ***");
                    System.out.print("Enter focus area (Weight Loss, Muscle Building, Flexibility, Yoga, Strength): ");
                    String focusArea = scanner.nextLine();
                    List<String> programsByFocusArea = app3.filterProgramsByFocusArea(focusArea);
                    System.out.println("Programs:");
                    for (String program : programsByFocusArea) {
                        System.out.println(program);
                    }
                    break;
                case 3:
                    System.out.println("\n*** Enroll in a Program ***");
                    System.out.print("Enter the program name to enroll: ");
                    String programName = scanner.nextLine();
                    try {
                        app3.selectProgram(programName);
                        String enrollmentMessage = app3.enrollInSelectedProgram();
                        System.out.println(enrollmentMessage);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("\n*** View Program Schedule ***");
                    String schedule = app3.getProgramSchedule();
                    System.out.println(schedule);
                    break;
                case 5:
                    return; 
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }



private static void progressTracking(Scanner scanner, Clienttt app3) {
	while (true) {
        System.out.println("\n--- Progress Tracking ---");
        System.out.println("1. View Milestones");
        System.out.println("2. View Achievements");
        System.out.println("3. View Attendance History");
        System.out.println("4. Set Fitness Goals");
        System.out.println("5. Check Progress Towards Goals");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                System.out.println(app3.viewMilestones());
                break;
            case 2:
                System.out.println(app3.viewAchievements());
                break;
            case 3:
                System.out.println(app3.viewAttendanceHistory());
                break;
            case 4:
                System.out.println("\n*** Set Fitness Goals ***");
                System.out.print("Enter weight goal: ");
                String weightGoal = scanner.nextLine();
                System.out.print("Enter BMI goal: ");
                String bmiGoal = scanner.nextLine();
                System.out.print("Enter running goal (km): ");
                String runGoal = scanner.nextLine();
                app3.setFitnessGoals(weightGoal, bmiGoal, runGoal);
                break;
            case 5:
                System.out.println(app3.checkProgressTowardsGoals());
                break;
            case 6:
                return; 
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
}

private static void feedbackAndReviews(Scanner scanner, Clienttt app3) {
    while (true) {
        System.out.println("\n--- Feedback and Reviews ---");
        System.out.println("1. Rate ");
        System.out.println("2. Review ");
        System.out.println("3. Suggest ");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
        case 1:
        	System.out.println("\n*** Rate ***");
            System.out.print("Enter program name: ");
            String programName = scanner.nextLine();
            System.out.print("Rate out of 5: ");
            int rating = scanner.nextInt();
            scanner.nextLine(); 
            app3.rateProgram(rating);
            System.out.println("Thank you for your feedback!");
            break;
        case 2:
        	System.out.println("\n*** Review ***");
            System.out.print("Add a review: ");
            String review = scanner.nextLine();
            app3.submitProgramReview(review);
            System.out.println("Thank you for your feedback!");
            break;
        case 3:
        	System.out.println("\n*** Suggest ***");
            System.out.print("Enter your suggestion for improvement: ");
            String suggestion = scanner.nextLine();
            app3.submitProgramImprovementSuggestion(suggestion);
            System.out.println("Thank you for your suggestion! It has been submitted to the instructor.");
            break;
        case 4:
        	 return;  
        default:
        	System.out.println("Invalid choice. Try again.");
            break;
    }
}
}

    

private static void handleInstructorFeatures(Scanner scanner, Instructor app2) {
    System.out.print("Enter instructor username: ");
    String username = scanner.nextLine();

    System.out.print("Enter instructor password: ");
    String password = scanner.nextLine();

    if (app2.loginAsInstructor(username, password)) {
        System.out.println("Logged in successfully as instructor.");
        instructorMenu(scanner, app2);
    } else {
        System.out.println("Invalid instructor username or password.");
    }
}

private static void instructorMenu(Scanner scanner, Instructor app2) {
    boolean returnToMenu = false;
    do {
        System.out.println("\n--- Instructor Features ---");
        System.out.println("1. Program Management");
        System.out.println("2. Client Interaction");
        System.out.println("3. Progress Tracking");
        System.out.println("4. Notifications and Updates");
        System.out.println("5. Return to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = validateInput(scanner);

        switch (choice) {
            case 1:
                programManagement(scanner, app2);
                break;
            case 2:
                clientInteractionMenu(scanner, app2);
                break;
            case 3:
                progressTrackingMenu(scanner, app2);
                break;
            case 4:
                notificationsAndUpdatesMenu(scanner, app2); // إضافة القائمة الجديدة
                break;
            case 5:
                returnToMenu = true;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (!returnToMenu);
}

private static void programManagement(Scanner scanner, Instructor app2) {
    boolean returnToMenu = false;
    do {
        System.out.println("\n--- Program Management ---");
        System.out.println("1. Create Program");
        System.out.println("2. Update Program");
        System.out.println("3. Delete Program");
        System.out.println("4. Set Group Session Schedules");
        System.out.println("5. Return to Instructor Menu");
        System.out.print("Enter your choice: ");

        int choice = validateInput(scanner);

        switch (choice) {
            case 1:
                createProgram(scanner, app2); 
                break;
            case 2:
                updateProgram(scanner, app2); 
                break;
            case 3:
                deleteProgram(scanner, app2); 
                break;
            case 4:
                setGroupSessionSchedules(scanner, app2); 
                break;
            case 5:
                returnToMenu = true;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (!returnToMenu);
}

private static void createProgram(Scanner scanner, Instructor app2) {
    System.out.print("Enter Program Title: ");
    String title = scanner.nextLine();

    System.out.print("Enter Duration (e.g., '4 weeks'): ");
    String duration = scanner.nextLine();

    System.out.print("Enter Difficulty Level (e.g., Beginner, Intermediate, Advanced): ");
    String difficulty = scanner.nextLine();

    System.out.print("Enter Goals: ");
    String goals = scanner.nextLine();

    System.out.println("Enter Media Files (type 'done' to finish): ");
    List<String> media = new ArrayList<>();
    while (true) {
        String file = scanner.nextLine();
        if (file.equalsIgnoreCase("done")) break;
        media.add(file);
    }

    System.out.println("Enter Group Session Schedule (dates/times, type 'done' to finish): ");
    List<String> schedule = new ArrayList<>();
    while (true) {
        String session = scanner.nextLine();
        if (session.equalsIgnoreCase("done")) break;
        schedule.add(session);
    }
    System.out.print("Enter Price (enter 0 for free): ");
    double price = scanner.nextDouble();
    scanner.nextLine(); 

    if (app2.createProgram(title, duration, difficulty, goals, media, price, schedule)) {
        System.out.println("Program created successfully!");
    } else {
        System.out.println("Failed to create program. Please check your inputs and try again.");
    }
    programManagement(scanner, app2);
}

private static void updateProgram(Scanner scanner, Instructor app2) {
    System.out.print("Enter Program Title to Update: ");
    String titleToUpdate = scanner.nextLine();

    System.out.print("Enter New Duration (or leave blank to keep current): ");
    String newDuration = scanner.nextLine();

    System.out.print("Enter New Difficulty Level (or leave blank to keep current): ");
    String newDifficulty = scanner.nextLine();

    System.out.print("Enter New Goals (or leave blank to keep current): ");
    String newGoals = scanner.nextLine();

    System.out.println("Enter New Media Files (type 'done' to finish):");
    List<String> newMedia = new ArrayList<>();
    while (true) {
        String file = scanner.nextLine();
        if (file.equalsIgnoreCase("done")) break;
        newMedia.add(file);
    }

    System.out.print("Enter New Price (or -1 to keep current): ");
    double newPrice = scanner.nextDouble();
    scanner.nextLine(); 

    System.out.println("Enter New Schedule (type 'done' to finish):");
    List<String> newSchedule = new ArrayList<>();
    while (true) {
        String session = scanner.nextLine();
        if (session.equalsIgnoreCase("done")) break;
        newSchedule.add(session);
    }

    app2.updateProgram(titleToUpdate, newDuration, newDifficulty, newGoals, newMedia, newPrice, newSchedule);
}

private static void deleteProgram(Scanner scanner, Instructor app2) {
    System.out.print("Enter Program Title to Delete: ");
    String titleToDelete = scanner.nextLine();

    app2.deleteProgram(titleToDelete);
}

private static void setGroupSessionSchedules(Scanner scanner, Instructor app2) {
    System.out.print("Enter Program Title for Group Sessions: ");
    String programTitle = scanner.nextLine();

    System.out.println("Enter Session Type (Online/In-Person): ");
    String sessionType = scanner.nextLine();

    System.out.println("Enter Group Session Schedule (dates/times, type 'done' to finish): ");
    List<String> sessionSchedule = new ArrayList<>();
    while (true) {
        String session = scanner.nextLine();
        if (session.equalsIgnoreCase("done")) break;
        sessionSchedule.add(session);
    }

    app2.setGroupSessionSchedules(programTitle, sessionType, sessionSchedule);
}



private static void clientInteractionMenu(Scanner scanner, Instructor app2) {
    System.out.println("\n--- Client Interaction ---");
    System.out.println("1. Communicate with Clients");
    System.out.println("2. Provide Feedback or Progress Reports");
    System.out.println("3. Return to Instructor Menu");
    System.out.print("Enter your choice: ");

    int choice = validateInput(scanner);

    switch (choice) {
        case 1:
            communicateWithClients(scanner, app2);
            break;
        case 2:
            provideFeedback(scanner, app2); 
            break;
        case 3:
            return; 
        default:
            System.out.println("Invalid choice. Returning to Instructor Menu.");
    }
}

public static void communicateWithClients(Scanner scanner, Instructor app2) {
    System.out.print("Enter client username to communicate with: ");
    String clientUsername = scanner.nextLine();

    if (app2.clientMessages.containsKey(clientUsername)) {
        System.out.println("You are now communicating with " + clientUsername);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Send Message");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = validateInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter your message: ");
                    String message = scanner.nextLine();
                    if (app2.sendMessageToClient(clientUsername, message)) {
                        System.out.println("Message sent to " + clientUsername);
                    } else {
                        System.out.println("Failed to send message. Please try again.");
                    }
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    } else {
        System.out.println("Client not found.");
    }
}

private static void provideFeedback(Scanner scanner, Instructor app2) {
    System.out.println("\n--- Provide Feedback or Progress Reports ---");
    System.out.print("Enter Client Username: ");
    String clientUsername = scanner.nextLine();

    System.out.print("Enter Progress Report: ");
    String report = scanner.nextLine();

    if (app2.provideFeedbackToClient(clientUsername, report)) {
        System.out.println("Progress report sent successfully to " + clientUsername + ".");
    } else {
        System.out.println("Failed to provide feedback. Client may not exist.");
    }
}
private static void progressTrackingMenu(Scanner scanner, Instructor app2) {
    System.out.println("\n--- Progress Tracking ---");
    System.out.println("1. Monitor Client Progress");
    System.out.println("2. Send Motivational Reminders or Recommendations");
    System.out.println("3. Return to Instructor Menu");
    System.out.print("Enter your choice: ");
    
    int choice = validateInput(scanner);
    
    switch (choice) {
        case 1:
            monitorProgress(scanner, app2); 
            break;
        case 2:
            sendMotivationalReminders(scanner, app2); 
            break;
        case 3:
            return; 
        default:
            System.out.println("Invalid choice. Returning to Instructor Menu.");
    }
}

private static void monitorProgress(Scanner scanner, Instructor app2) {
    System.out.print("Enter client username to monitor progress: ");
    String clientUsername = scanner.nextLine();

    if (app2.isClientExist(clientUsername)) {
        System.out.println("Monitoring progress for " + clientUsername);
        double completionRate = app2.getClientCompletionRate(clientUsername); // استدعاء دالة حساب معدل الإتمام
        double attendanceRate = app2.getClientAttendanceRate(clientUsername); // استدعاء دالة حساب معدل الحضور
        
        System.out.println("Completion Rate: " + completionRate + "%");
        System.out.println("Attendance Rate: " + attendanceRate + "%");
    } else {
        System.out.println("Client not found.");
    }
}

private static void sendMotivationalReminders(Scanner scanner, Instructor app2) {
    System.out.print("Enter client username to send motivational reminder: ");
    String clientUsername = scanner.nextLine();

    if (app2.isClientExist(clientUsername)) {
        System.out.println("Sending motivational reminder to " + clientUsername);
        app2.sendMotivationalReminder(clientUsername);
        System.out.println("Reminder sent successfully.");
    } else {
        System.out.println("Client not found.");
    }
}

private static void notificationsAndUpdatesMenu(Scanner scanner, Instructor app2) {
    boolean exit = false;
    do {
        System.out.println("\n--- Notifications and Updates ---");
        System.out.println("1. Notify clients about changes to program schedules");
        System.out.println("2. Announce new programs or special offers");
        System.out.println("3. Return to Instructor Menu");
        System.out.print("Enter your choice: ");

        int choice = validateInput(scanner);

        switch (choice) {
            case 1:
                notifyClientsAboutScheduleChanges(scanner, app2); // استدعاء دالة إرسال إشعار
                break;
            case 2:
                announceNewProgramsOrOffers(scanner, app2); // استدعاء دالة الإعلان عن عروض
                break;
            case 3:
                exit = true;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (!exit);
}

private static void notifyClientsAboutScheduleChanges(Scanner scanner, Instructor app2) {
    System.out.print("Enter program title to notify clients about schedule changes: ");
    String programTitle = scanner.nextLine();

    System.out.print("Enter the updated schedule details: ");
    String updatedSchedule = scanner.nextLine();

    if (app2.notifyClientsAboutSchedule(programTitle, updatedSchedule)) {
        System.out.println("Clients notified about schedule changes successfully.");
    } else {
        System.out.println("Failed to notify clients. Please check program title.");
    }
}

private static void announceNewProgramsOrOffers(Scanner scanner, Instructor app2) {
    System.out.print("Enter announcement message: ");
    String announcement = scanner.nextLine();

    if (app2.announceNewProgramsOrOffers(announcement)) {
        System.out.println("Announcement sent successfully to all clients.");
    } else {
        System.out.println("Failed to send announcement. Please try again.");
    }
}

  

private static int validateInput(Scanner scanner) {
    if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        if (scanner.hasNextLine()) {  // تحقق إذا كان هناك سطر آخر للقراءة
            scanner.nextLine();  // قراءة السطر التالي (المسافة أو السطر الجديد)
        }
        return choice;
    } else {
        System.out.println("Invalid input. Please enter a valid number.");
        if (scanner.hasNextLine()) {
            scanner.nextLine();  // تجاهل الإدخال غير الصحيح
        }
        return -1;
    }
}
}