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

    public Progress_Tracking_steps() {
        app = new MyApplication();
    }


    @Given("the client has completed a fitness program")
    public void the_client_has_completed_a_fitness_program() {
        app.loginClient(); 
        app.completeFitnessProgram(); 
    }

    @When("the client navigates to the progress section")
    public void theClientNavigatesToTheProgressSection() {
        app.navigateToProgressTrackingPage(); 
    }

    @When("the client requests to view milestones")
    public void theClientRequestsToViewMilestones() {
        displayedInfo = app.viewMilestones(); 
    }

    @Then("the system displays the client’s current weight, BMI, and attendance records")
    public void theSystemDisplaysTheClientSCurrentWeightBMIAndAttendanceRecords() {
        assertNotNull(displayedInfo);
        assertTrue(displayedInfo.contains("Weight"));
        assertTrue(displayedInfo.contains("BMI"));
        assertTrue(displayedInfo.contains("Attendance"));
    }

   
    @When("the client views their achievements")
    public void theClientViewsTheirAchievements() {
        displayedInfo = app.viewAchievements(); 
    }

    @Then("the system displays any badges earned for completing the program")
    public void theSystemDisplaysBadgesEarned() {
        assertNotNull(displayedInfo);
        assertTrue(displayedInfo.contains("Badges"));
    }

  
    @Given("the client has enrolled in a fitness program")
    public void the_client_has_enrolled_in_a_fitness_program() {
        app.loginClient(); 
        app.enrollInProgram(); 
    }

    @When("the client requests to view attendance")
    public void theClientRequestsToViewAttendance() {
        displayedInfo = app.viewAttendanceHistory(); 
    }

    @Then("the system displays the client’s attendance history for the program")
    public void theSystemDisplaysTheClientSAttendanceHistoryForTheProgram() {
        assertNotNull(displayedInfo); 
        System.out.println("Displayed Info: " + displayedInfo); 
        assertTrue(displayedInfo.startsWith("Attendance History:")); 
    }


    
    @Given("the client has set fitness goals")
    public void the_client_has_set_fitness_goals() {
        app.loginClient(); 
        app.setFitnessGoals("Lose 5kg", "Improve BMI", "Run 5km"); 
    }

    @When("the client checks progress towards those goals")
    public void the_client_checks_progress_towards_goals() {
        displayedInfo = app.checkProgressTowardsGoals(); 
    }

    @Then("the system shows how far the client has progressed in terms of weight, BMI, or other metrics")
    public void the_system_shows_progress_in_metrics() {
        assertNotNull(displayedInfo);
        assertTrue(displayedInfo.contains("Weight"));
        assertTrue(displayedInfo.contains("BMI"));
        assertTrue(displayedInfo.contains("Running"));
    }
}