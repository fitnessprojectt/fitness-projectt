package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Progress_Tracking_steps {

    private MyApplication app;
    private String displayedInfo;
	private String username;
	private String password;

    public Progress_Tracking_steps() {
        app = new MyApplication(); // Initialize MyApplication
    }

 // Scenario 1: Track personal fitness milestones
    @Given("the client has completed a fitness program")
    public void the_client_has_completed_a_fitness_program() {
        app.loginClient(username, password); // Log in the client
        app.completeFitnessProgram(); // Mark the fitness program as completed
    }

    @When("the client navigates to the progress section")
    public void theClientNavigatesToTheProgressSection() {
        app.navigateToProgressTrackingPage(); // Navigate to the progress page
    }

    @When("the client requests to view milestones")
    public void theClientRequestsToViewMilestones() {
        displayedInfo = app.viewMilestones(); // View milestones
    }

    @Then("the system displays the client’s current weight, BMI, and attendance records")
    public void theSystemDisplaysTheClientSCurrentWeightBMIAndAttendanceRecords() {
        assertNotNull(displayedInfo);
        assertTrue(displayedInfo.contains("Weight"));
        assertTrue(displayedInfo.contains("BMI"));
        assertTrue(displayedInfo.contains("Attendance"));
    }

    // Scenario 2: View achievements after completing a program
    @When("the client views their achievements")
    public void theClientViewsTheirAchievements() {
        displayedInfo = app.viewAchievements(); // View achievements
    }

    @Then("the system displays any badges earned for completing the program")
    public void theSystemDisplaysBadgesEarned() {
        assertNotNull(displayedInfo);
        assertTrue(displayedInfo.contains("Badges"));
    }

    // Scenario 3: Client views program attendance
    @Given("the client has enrolled in a fitness program")
    public void the_client_has_enrolled_in_a_fitness_program() {
        app.loginClient(username, username); // Log in the client
        app.enrollInProgram(); // Enroll the client in a program
    }

    @When("the client requests to view attendance")
    public void theClientRequestsToViewAttendance() {
        displayedInfo = app.viewAttendanceHistory(); // View attendance
    }

    @Then("the system displays the client’s attendance history for the program")
    public void theSystemDisplaysTheClientSAttendanceHistoryForTheProgram() {
        assertNotNull(displayedInfo); // Ensure displayedInfo is not null
        System.out.println("Displayed Info: " + displayedInfo); // Debugging output
        assertTrue(displayedInfo.startsWith("Attendance History:")); // Verify the content
    }


    // Scenario 4: Client checks progress towards goals
    @Given("the client has set fitness goals")
    public void the_client_has_set_fitness_goals() {
        app.loginClient(username, password); // Log in the client
        app.setFitnessGoals("Lose 5kg", "Improve BMI", "Run 5km"); // Set fitness goals
    }

    @When("the client checks progress towards those goals")
    public void the_client_checks_progress_towards_goals() {
        displayedInfo = app.checkProgressTowardsGoals(); // Check progress
    }

    @Then("the system shows how far the client has progressed in terms of weight, BMI, or other metrics")
    public void the_system_shows_progress_in_metrics() {
        assertNotNull(displayedInfo);
        assertTrue(displayedInfo.contains("Weight"));
        assertTrue(displayedInfo.contains("BMI"));
        assertTrue(displayedInfo.contains("Running"));
    }
}