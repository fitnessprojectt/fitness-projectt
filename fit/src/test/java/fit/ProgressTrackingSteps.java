package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProgressTrackingSteps {
    Instructor app2;
    private String selectedClient;
    private String clientProgress;
    private String motivationalMessage;
    private String username = "instructor";
    private String password = "password123";

    public ProgressTrackingSteps() {
        app2 = new Instructor();
        app2.loginAsInstructor("israa", "soso123");
    }

	


    @Given("the instructor is logged in successfully")
    public void theInstructorIsLoggedInSuccessfully() {
        System.out.println("Starting login process...");
        boolean loggedIn = app2.loginAsInstructor(username, password);
      
        System.out.println("Instructor logged in successfully.");
    }


    @Given("the instructor navigates to the Client Progress page")
    public void theInstructorNavigatesToTheClientProgressPage() {
        app2.navigateToPage1();
    }

    @When("the instructor selects a client")
    public void theInstructorSelectsAClient() {
        selectedClient = "Client 1";
        app2.selectClient(selectedClient);
    }

    @Then("the instructor should see the client's progress \\(e.g., completion rate, attendance)")
    public void theInstructorShouldSeeTheClientSProgressEGCompletionRateAttendance() {
        clientProgress = app2.getClientProgress(selectedClient);
        System.out.println("Client's progress: " + clientProgress);
    }

    @When("the instructor writes a motivational message")
    public void theInstructorWritesAMotivationalMessage() {
        motivationalMessage = "You're doing great! Keep pushing!";
        System.out.println("Instructor wrote the motivational message: " + motivationalMessage);
    }
  
    @Then("the client should receive the motivational reminder")
    public void theClientShouldReceiveTheMotivationalReminder() {
        app2.sendMotivationalMessage(selectedClient, motivationalMessage);
    }
}
