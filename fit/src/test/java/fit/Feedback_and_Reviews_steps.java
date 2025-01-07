package fit;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import org.junit.Test;

public class Feedback_and_Reviews_steps {

    private Clienttt app3;
    private String reviewText;
    private int rating;
    private String suggestionText;

    public Feedback_and_Reviews_steps() {
        app3 = new Clienttt(); 
    }

    @Before
    public void setup() {
        // Prepopulate the system with valid credentials
        app3.loginClient("validUsername", "validPassword");
    }
    @Test
    public void testClientLogin() {
        String username = "validUsername";
        String password = "validPassword";

        app3.loginClient(username, password);
        assertTrue("Login failed. Ensure username and password are correct.", app3.isLoggedIn());
    }
    @Given("the client has completed a fitness program")
    public void the_client_has_completed_a_fitness_program() {
        // Ensure these are valid credentials in your system
        String username = "validUsername";
        String password = "validPassword";

        app3.loginClient(username, password);

        // Verify the login was successful
        assertTrue("Login failed. Ensure username and password are correct.", app3.isLoggedIn());

        app3.completeFitnessProgram();
    }

    @When("the client navigates to the feedback section")
    public void the_client_navigates_to_the_feedback_section() {
        app3.navigateToFeedbackSection(); 
    }

    @When("the client rates the program with a score of 1 to 5")
    public void the_client_rates_the_program_with_a_score_of_1_to_5() {
        rating = 4; 
        app3.rateProgram(rating); 
    }

    @When("the client writes a review")
    public void the_client_writes_a_review() {
        reviewText = "Great program, highly recommend!"; 
        app3.submitProgramReview(reviewText); 
    }

    @Then("the system saves the feedback and associates it with the completed program")
    public void the_system_saves_the_feedback_and_associates_it_with_the_completed_program() {
        assertEquals(rating, app3.getProgramRating()); 
        assertTrue(app3.isReviewVisible()); 
        assertEquals(reviewText, app3.getReviewComments()); 
    }

    
    @When("the client writes a suggestion for improving the program")
    public void the_client_writes_a_suggestion_for_improving_the_program() {
        suggestionText = "Add more variety in the workouts."; 
        app3.submitProgramImprovementSuggestion(suggestionText); 
    }

    @Then("the system sends the suggestion to the instructor for review")
    public void the_system_sends_the_suggestion_to_the_instructor_for_review() {
        assertTrue(app3.isSuggestionStored());
        assertEquals(suggestionText, app3.getStoredSuggestion()); 
    }

    
    @When("the client selects \"View Program Feedback\" from the main menu")
    public void the_client_selects_view_program_feedback_from_the_main_menu() {
        app3.viewPreviousFeedback(); 
    }

    @Then("the system displays the client’s previously submitted feedback for the selected program")
    public void the_system_displays_the_clients_previously_submitted_feedback_for_the_selected_program() {
        String previousFeedback = app3.getPreviousFeedback();
        if (reviewText == null || reviewText.isEmpty()) {
            assertNull(previousFeedback); 
        } else {
            assertEquals(reviewText, previousFeedback);
        }
    }
}
