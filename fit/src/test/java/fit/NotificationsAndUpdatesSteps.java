package fit;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.List;

public class NotificationsAndUpdatesSteps {

    MyApplication app;

    public NotificationsAndUpdatesSteps() {
        app = new MyApplication();
    }

    private String programName;
    private List<String> scheduleChange;
    private String newOffer;
    private List<String> enrolledClients;
    private String notificationMessage;

    @When("I update the schedule of a program")
    public void iUpdateTheScheduleOfAProgram() {
        programName = "Fitness Program 1";
        // إذا كان scheduleChange يتكون من أكثر من عنصر، يمكن تعديل هذا ليكون List<String>
        scheduleChange = List.of("Every Monday and Wednesday at 6 PM");
        System.out.println("Updated the schedule for " + programName + ": " + scheduleChange);

        // تحديث الجدول في التطبيق
        app.updateSchedule(programName, scheduleChange);
    }

    @Then("all enrolled clients should receive a notification about the schedule change")
    public void allEnrolledClientsShouldReceiveANotificationAboutTheScheduleChange() {
        enrolledClients = app.getEnrolledClients(programName);
        notificationMessage = "The schedule for " + programName + " has been updated: " + scheduleChange;

        for (String client : enrolledClients) {
            app.sendNotification(client, notificationMessage);
            System.out.println("Notification sent to " + client + ": " + notificationMessage);
        }
    }

    @When("I create a new fitness program")
    public void iCreateANewFitnessProgram() {
        programName = "Fitness Program 2";
        String type = "Weight Loss";  // تحديد نوع البرنامج (مثلًا "Weight Loss")
        String startDate = "2024-01-01";  // تاريخ البدء
        String endDate = "2024-06-01";  // تاريخ الانتهاء
        System.out.println("Created a new fitness program: " + programName);

        // إضافة البرنامج الجديد في التطبيق
        app.createNewProgram(programName, type, startDate, endDate);
    }

    @Then("all clients should receive a notification about the new program")
    public void allClientsShouldReceiveANotificationAboutTheNewProgram() {
        List<String> allClients = app.getAllClients();
        notificationMessage = "A new fitness program is now available: " + programName;

        for (String client : allClients) {
            app.sendNotification(client, notificationMessage);
            System.out.println("Notification sent to " + client + ": " + notificationMessage);
        }
    }

    @When("I create a new offer \\(e.g., discount on a program)")
    public void iCreateANewOfferEGDiscountOnAProgram() {
        newOffer = "20% discount on Fitness Program 2";
        System.out.println("Created a new offer: " + newOffer);

        // إضافة العرض الجديد في التطبيق
        app.createNewOffer(newOffer);
    }

    @Then("all clients should receive a notification about the special offer")
    public void allClientsShouldReceiveANotificationAboutTheSpecialOffer() {
        List<String> allClients = app.getAllClients();
        notificationMessage = "Special offer: " + newOffer;

        for (String client : allClients) {
            app.sendNotification(client, notificationMessage);
            System.out.println("Notification sent to " + client + ": " + notificationMessage);
        }
    }
}
