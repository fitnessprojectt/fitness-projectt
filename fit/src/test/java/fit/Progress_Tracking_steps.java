package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Progress_Tracking_steps {

    private Clienttt app3;
    private String displayedInfo;

    public Progress_Tracking_steps() {
        app3 = new Clienttt();
    }
    
    @When("the client navigates to the progress section")
    public void theClientNavigatesToTheProgressSection() {
        app3.navigateToProgressTrackingPage();
    }

    @When("the client requests to view milestones")
    public void theClientRequestsToViewMilestones() {
        app3.viewMilestones();
    }

    @Then("the system displays the client’s current weight, BMI, and attendance records")
    public void theSystemDisplaysTheClientSCurrentWeightBMIAndAttendanceRecords() {
        displayedInfo = app3.viewProgress();
        assertNotNull(displayedInfo);
        assertTrue(displayedInfo.contains("Weight"));
        assertTrue(displayedInfo.contains("BMI"));
        assertTrue(displayedInfo.contains("Attendance"));
    }

   
    @When("the client views their achievements")
    public void the_client_views_their_achievements() {
        assertNotNull("Client should be logged in to view achievements", displayedInfo);
        displayedInfo = app3.viewAchievements();
    }

    @Then("the system displays any badges earned for completing the program")
    public void the_system_displays_badges_earned() {
        assertNotNull("Displayed information cannot be null", displayedInfo);
        assertTrue(displayedInfo.contains("Badges")); 
    }

    @Given("the client has enrolled in a fitness program")
    public void the_client_has_enrolled_in_a_fitness_program() {
        String username = "yumna"; 
        String password = "pass123";
        try {
            app3.loginClient(username, password);
        } catch (RuntimeException e) {
            System.err.println("Login failed: " + e.getMessage());
            assertTrue("Login failed: " + e.getMessage(), false);
        }
    }

    @When("the client requests to view attendance")
    public void theClientRequestsToViewAttendance() {
        }

    @Then("the system displays the client’s attendance history for the program")
    public void theSystemDisplaysTheClientSAttendanceHistoryForTheProgram() {
        
    }

    
    @Given("the client has set fitness goals")
    public void the_client_has_set_fitness_goals() {
        assertNotNull("Displayed information cannot be null", displayedInfo);
                if (displayedInfo.isEmpty()) {
            fail("Displayed information is empty");
        }

        app3.loginClient(displayedInfo, displayedInfo);
        
        app3.setFitnessGoals("Lose 5kg", "Improve BMI","Run 5km");
    }
    @When("the client checks progress towards those goals")
    public void the_client_checks_progress_towards_goals() {
        displayedInfo = app3.checkProgressTowardsGoals(); 
    }

    @Then("the system shows how far the client has progressed in terms of weight, BMI, or other metrics")
    public void the_system_shows_progress_in_metrics() {
        assertNotNull(displayedInfo);
        assertTrue(displayedInfo.contains("Weight"));
        assertTrue(displayedInfo.contains("BMI"));
        assertTrue(displayedInfo.contains("Running"));
    }
}