package fit;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.List;

public class NotificationsAndUpdatesSteps {

    Instructor app2;

    public NotificationsAndUpdatesSteps() {
        app2 = new Instructor();
    }

    private String programName;
    private List<String> scheduleChange;
    private String newOffer;
    private List<String> enrolledClients;
    private String notificationMessage;

    @When("I update the schedule of a program")
    public void iUpdateTheScheduleOfAProgram() {
        programName = "Fitness Program 1";
        scheduleChange = List.of("Every Monday and Wednesday at 6 PM");
        System.out.println("Updated the schedule for " + programName + ": " + scheduleChange);

        app2.updateSchedule(programName, scheduleChange);
    }

    @Then("all enrolled clients should receive a notification about the schedule change")
    public void allEnrolledClientsShouldReceiveANotificationAboutTheScheduleChange() {
        enrolledClients = app2.getEnrolledClients(programName);
        notificationMessage = "The schedule for " + programName + " has been updated: " + scheduleChange;

        for (String client : enrolledClients) {
            app2.sendNotification(client, notificationMessage);
            System.out.println("Notification sent to " + client + ": " + notificationMessage);
        }
    }

    @When("I create a new fitness program")
    public void iCreateANewFitnessProgram() {
        programName = "Fitness Program 2";
        String type = "Weight Loss"; 
        String startDate = "2024-01-01";  
        String endDate = "2024-06-01";  
        System.out.println("Created a new fitness program: " + programName);

        app2.createNewProgram(programName, type, startDate, endDate);
    }

    @Then("all clients should receive a notification about the new program")
    public void allClientsShouldReceiveANotificationAboutTheNewProgram() {
        List<String> allClients = app2.getAllClients();
        notificationMessage = "A new fitness program is now available: " + programName;

        for (String client : allClients) {
            app2.sendNotification(client, notificationMessage);
            System.out.println("Notification sent to " + client + ": " + notificationMessage);
        }
    }

    @When("I create a new offer \\(e.g., discount on a program)")
    public void iCreateANewOfferEGDiscountOnAProgram() {
        newOffer = "20% discount on Fitness Program 2";
        System.out.println("Created a new offer: " + newOffer);

        app2.createNewOffer(newOffer);
    }

    @Then("all clients should receive a notification about the special offer")
    public void allClientsShouldReceiveANotificationAboutTheSpecialOffer() {
        List<String> allClients = app2.getAllClients();
        notificationMessage = "Special offer: " + newOffer;

        for (String client : allClients) {
            app2.sendNotification(client, notificationMessage);
            System.out.println("Notification sent to " + client + ": " + notificationMessage);
        }
    }
}