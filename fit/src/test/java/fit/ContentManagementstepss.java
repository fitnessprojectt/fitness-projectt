package fit;

import java.time.LocalDate;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ContentManagementstepss {

    private Admin app1;
    private String tipContent;
    private LocalDate tipDate;
    private boolean isLoggedIn;
    private boolean isAdmin;

    public ContentManagementstepss() {
        app1 = new Admin();
    }

    @Given("I am logged into the admin portal")
    public void i_am_logged_into_the_admin_portal() {
        app1.loginAsAdmin("adminUsername", "adminPassword"); 
    }

    @Given("I have the necessary permissions to manage content")
    public void i_have_the_necessary_permissions_to_manage_content() {
        app1.checkAdminPermissions(); 
    }

    @Given("an article has been submitted by an instructor")
    public void an_article_has_been_submitted_by_an_instructor() {
        tipContent = "Sample Article Title: Quality Content";
        app1.submitArticle(tipContent, "Sample Content"); 
    }

    @When("I review the content")
    public void i_review_the_content() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.reviewContent(tipContent); 
        } else {
            System.out.println("Content is null or empty, cannot review.");
        }
    }

    @When("the article meets the quality guidelines")
    public void the_article_meets_the_quality_guidelines() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.verifyContentQuality(tipContent);
        } else {
            System.out.println("Content is null or empty, cannot verify quality.");
        }
    }

    @Then("I approve the article")
    public void i_approve_the_article() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.approveArticle(tipContent); 
        } else {
            System.out.println("Content is null or empty, cannot approve.");
        }
    }

    @Then("the article is published on the platform")
    public void the_article_is_published_on_the_platform() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.publishArticle(tipContent);
        } else {
            System.out.println("Content is null or empty, cannot publish.");
        }
    }

    @When("the article does not meet the quality guidelines")
    public void the_article_does_not_meet_the_quality_guidelines() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.rejectContentReview(tipContent);
        } else {
            System.out.println("Content is null or empty, cannot reject.");
        }
    }

    @Then("I reject the article")
    public void i_reject_the_article() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.rejectArticle(tipContent);
        } else {
            System.out.println("Content is null or empty, cannot reject.");
        }
    }

    @Then("notify the instructor with feedback")
    public void notify_the_instructor_with_feedback() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.notifyInstructor("Your article needs improvement to meet quality guidelines."); 
        } else {
            System.out.println("Content is null or empty, cannot notify instructor.");
        }
    }

    @Given("a wellness tip has been shared on the platform")
    public void a_wellness_tip_has_been_shared_on_the_platform() {
        tipContent = "Stay hydrated for better health."; 
        tipDate = LocalDate.now(); 
        app1.submitTip(tipContent); 
    }

    @When("I review the tip")
    public void i_review_the_tip() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.reviewTip(); 
        } else {
            System.out.println("Tip content is null or empty, cannot review.");
        }
    }

    @When("it aligns with the platform's guidelines")
    public void it_aligns_with_the_platform_s_guidelines() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.verifyTipCompliance(tipContent);
        } else {
            System.out.println("Tip content is null or empty, cannot verify compliance.");
        }
    }

    @Then("I approve the tip")
    public void i_approve_the_tip() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.approveTip(tipContent); 
        } else {
            System.out.println("Tip content is null or empty, cannot approve.");
        }
    }

    @Then("it becomes visible to users")
    public void it_becomes_visible_to_users() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.makeTipVisible(tipContent, tipDate, isLoggedIn, isAdmin); 
        } else {
            System.out.println("Tip content is null or empty, cannot make visible.");
        }
    }

    @When("it does not meet health and wellness standards")
    public void it_does_not_meet_health_and_wellness_standards() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.rejectTipReview(tipContent);
        } else {
            System.out.println("Tip content is null or empty, cannot reject.");
        }
    }

    @Then("I reject the tip")
    public void i_reject_the_tip() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.rejectTip(tipContent);
        } else {
            System.out.println("Tip content is null or empty, cannot reject.");
        }
    }

    @Then("provide feedback to the submitter")
    public void provide_feedback_to_the_submitter() {
        if (tipContent != null && !tipContent.isEmpty()) {
            app1.notifySubmitter("Your wellness tip does not align with our standards.", app1); 
        } else {
            System.out.println("Tip content is null or empty, cannot provide feedback.");
        }
    }

    @Given("a user has submitted feedback about content")
    public void a_user_has_submitted_feedback_about_content() {
        app1.submitFeedback("This article contains outdated information.");
    }

    @When("I review the feedback")
    public void i_review_the_feedback() {
        app1.reviewFeedback(); 
    }

    @When("it highlights a valid issue")
    public void it_highlights_a_valid_issue() {
        app1.validateFeedback(null); 
    }

    @Then("I mark the feedback for further action")
    public void i_mark_the_feedback_for_further_action() {
        app1.markFeedbackForAction(null);
    }

    @Then("notify the content team")
    public void notify_the_content_team() {
        app1.notifyContentTeam("A valid issue has been reported by a user."); 
    }

    @Given("a user has submitted a complaint about content")
    public void a_user_has_submitted_a_complaint_about_content() {
        app1.submitComplaint("This article contains misinformation.", null); 
    }

    @When("I review the complaint")
    public void i_review_the_complaint() {
        app1.reviewComplaint(); 
    }

    @When("the complaint is valid")
    public void the_complaint_is_valid() {
        app1.validateComplaint(null); 
    }

    @Then("I remove the content from the platform")
    public void i_remove_the_content_from_the_platform() {
        app1.removeContent(null); 
    }

    @Then("notify the user of the resolution")
    public void notify_the_user_of_the_resolution() {
        app1.notifyUser("The content you flagged has been removed."); 
    }
}
