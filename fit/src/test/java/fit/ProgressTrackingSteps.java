package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProgressTrackingSteps {
    MyApplication app;

    public ProgressTrackingSteps() {
        app = new MyApplication();
    }

    private String selectedClient;
    private String clientProgress;
    private String motivationalMessage;

    // تعديل: إضافة متغيرات username و password
    private String username = "instructor";
    private String password = "password123";

    @Given("the instructor is logged in successfully")
    public void theInstructorIsLoggedInSuccessfully() {
        // تصحيح التهجئة وتمرير username و password بشكل صحيح
        boolean loggedIn = app.loginAsInstructor(username, password);
        if (!loggedIn) {
            throw new RuntimeException("Login failed");
        }
        System.out.println("Instructor logged in successfully.");
    }

    @Given("the instructor navigates to the Client Progress page")
    public void theInstructorNavigatesToTheClientProgressPage() {
        app.navigateToPage("Client Progress");
    }

    @When("the instructor selects a client")
    public void theInstructorSelectsAClient() {
        selectedClient = "Client 1";
        app.selectClient(selectedClient);
    }

    @Then("the instructor should see the client's progress \\(e.g., completion rate, attendance)")
    public void theInstructorShouldSeeTheClientSProgressEGCompletionRateAttendance() {
        clientProgress = app.getClientProgress(selectedClient);
        System.out.println("Client's progress: " + clientProgress);
    }

    @When("the instructor writes a motivational message")
    public void theInstructorWritesAMotivationalMessage() {
        motivationalMessage = "You're doing great! Keep pushing!";
        System.out.println("Instructor wrote the motivational message: " + motivationalMessage);
    }

    @Then("the client should receive the motivational reminder")
    public void theClientShouldReceiveTheMotivationalReminder() {
        app.sendMotivationalMessage(selectedClient, motivationalMessage);
    }
}
