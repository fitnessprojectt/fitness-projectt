package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class Feedback_and_Reviews_steps {

    private MyApplication app;
    private String reviewText;
    private int rating;
    private String suggestionText;

    public Feedback_and_Reviews_steps() {
        app = new MyApplication(); 
    }

    
    @Given("the client has completed a fitness program")
    public void the_client_has_completed_a_fitness_program() {
        app.loginClient(); 
        app.completeFitnessProgram(); 
    }

    @When("the client navigates to the feedback section")
    public void the_client_navigates_to_the_feedback_section() {
        app.navigateToFeedbackSection(); 
    }

    @When("the client rates the program with a score of 1 to 5")
    public void the_client_rates_the_program_with_a_score_of_1_to_5() {
        rating = 4; 
        app.rateProgram(rating); 
    }

    @When("the client writes a review")
    public void the_client_writes_a_review() {
        reviewText = "Great program, highly recommend!"; 
        app.submitProgramReview(reviewText); 
    }

    @Then("the system saves the feedback and associates it with the completed program")
    public void the_system_saves_the_feedback_and_associates_it_with_the_completed_program() {
        assertEquals(rating, app.getProgramRating()); 
        assertTrue(app.isReviewVisible()); 
        assertEquals(reviewText, app.getReviewComments()); 
    }

    
    @When("the client writes a suggestion for improving the program")
    public void the_client_writes_a_suggestion_for_improving_the_program() {
        suggestionText = "Add more variety in the workouts."; 
        app.submitProgramImprovementSuggestion(suggestionText); 
    }

    @Then("the system sends the suggestion to the instructor for review")
    public void the_system_sends_the_suggestion_to_the_instructor_for_review() {
        assertTrue(app.isSuggestionStored());
        assertEquals(suggestionText, app.getStoredSuggestion()); 
    }

    
    @When("the client selects \"View Program Feedback\" from the main menu")
    public void the_client_selects_view_program_feedback_from_the_main_menu() {
        app.viewPreviousFeedback(); 
    }

    @Then("the system displays the client’s previously submitted feedback for the selected program")
    public void the_system_displays_the_clients_previously_submitted_feedback_for_the_selected_program() {
        String previousFeedback = app.getPreviousFeedback();
        if (reviewText == null || reviewText.isEmpty()) {
            assertNull(previousFeedback); 
        } else {
            assertEquals(reviewText, previousFeedback);
        }
    }
}
