package fit;

import java.time.LocalDate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ContentManagementstepss {

    private MyApplication app;
	private String tipContent;
	private LocalDate tipDate;
	private boolean isLoggedIn;
	private boolean isAdmin;

    public ContentManagementstepss() {
        app = new MyApplication(); // Initialize the application
    }

    @Given("I am logged into the admin portal")
    public void i_am_logged_into_the_admin_portal() {
        app.loginAsAdmin(null, null); // Log in to the admin portal
    }

    @Given("I have the necessary permissions to manage content")
    public void i_have_the_necessary_permissions_to_manage_content() {
        app.checkAdminPermissions(); // Check for necessary permissions
    }

    @Given("an article has been submitted by an instructor")
    public void an_article_has_been_submitted_by_an_instructor() {
        app.submitArticle("Sample Article Title", "Sample Content"); // Simulate article submission
    }

    @When("I review the content")
    public void i_review_the_content() {
        app.reviewContent(null); // Review content
    }

    @When("the article meets the quality guidelines")
    public void the_article_meets_the_quality_guidelines() {
        app.verifyContentQuality(null); // Verify content meets quality guidelines
    }

    @Then("I approve the article")
    public void i_approve_the_article() {
        app.approveArticle(null); // Approve the article
    }

    @Then("the article is published on the platform")
    public void the_article_is_published_on_the_platform() {
        app.publishArticle(null); // Publish the article
    }

    @When("the article does not meet the quality guidelines")
    public void the_article_does_not_meet_the_quality_guidelines() {
        app.rejectContentReview(null); // Handle content that doesn't meet guidelines
    }

    @Then("I reject the article")
    public void i_reject_the_article() {
        app.rejectArticle(null); // Reject the article
    }

    @Then("notify the instructor with feedback")
    public void notify_the_instructor_with_feedback() {
        app.notifyInstructor("Your article needs improvement to meet quality guidelines."); // Notify instructor
    }

    @Given("a wellness tip has been shared on the platform")
    public void a_wellness_tip_has_been_shared_on_the_platform() {
        app.submitTip("Stay hydrated for better health."); // Simulate wellness tip submission
    }

    @When("I review the tip")
    public void i_review_the_tip() {
        app.reviewTip(); // Review the wellness tip
    }

    @When("it aligns with the platform's guidelines")
    public void it_aligns_with_the_platform_s_guidelines() {
        app.verifyTipCompliance(null); // Check tip alignment with guidelines
    }

    @Then("I approve the tip")
    public void i_approve_the_tip() {
        app.approveTip(null); // Approve the tip
    }

    @Then("it becomes visible to users")
    public void it_becomes_visible_to_users() {
        app.makeTipVisible( tipContent, tipDate, isLoggedIn,isAdmin); // Make the tip visible to users
    }

    @When("it does not meet health and wellness standards")
    public void it_does_not_meet_health_and_wellness_standards() {
        app.rejectTipReview(null); // Handle non-compliant tips
    }

    @Then("I reject the tip")
    public void i_reject_the_tip() {
        app.rejectTip(null); // Reject the tip
    }

    @Then("provide feedback to the submitter")
    public void provide_feedback_to_the_submitter() {
        app.notifySubmitter("Your wellness tip does not align with our standards.", app); // Notify submitter
    }

    @Given("a user has submitted feedback about content")
    public void a_user_has_submitted_feedback_about_content() {
        app.submitFeedback("This article contains outdated information."); // Simulate feedback submission
    }

    @When("I review the feedback")
    public void i_review_the_feedback() {
        app.reviewFeedback(); // Review user feedback
    }

    @When("it highlights a valid issue")
    public void it_highlights_a_valid_issue() {
        app.validateFeedback(null); // Validate the feedback
    }

    @Then("I mark the feedback for further action")
    public void i_mark_the_feedback_for_further_action() {
        app.markFeedbackForAction(null); // Mark feedback for further actions
    }

    @Then("notify the content team")
    public void notify_the_content_team() {
        app.notifyContentTeam("A valid issue has been reported by a user."); // Notify the content team
    }

    @Given("a user has submitted a complaint about content")
    public void a_user_has_submitted_a_complaint_about_content() {
        app.submitComplaint("This article contains misinformation.", null); // Simulate complaint submission
    }

    @When("I review the complaint")
    public void i_review_the_complaint() {
        app.reviewComplaint(); // Review the complaint
    }

    @When("the complaint is valid")
    public void the_complaint_is_valid() {
        app.validateComplaint(null); // Validate the complaint
    }

    @Then("I remove the content from the platform")
    public void i_remove_the_content_from_the_platform() {
        app.removeContent(null); // Remove the flagged content
    }

    @Then("notify the user of the resolution")
    public void notify_the_user_of_the_resolution() {
        app.notifyUser("The content you flagged has been removed."); // Notify user of resolution
    }
}

