package fit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementstepss {

    private Admin app1;


    public UserManagementstepss() {
        app1 = new Admin(); // تهيئة MyApplication
    }

    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
        app1.loginAsAdmin("adminUsername", "adminPassword");
    }

   

    @When("I review a submitted wellness article")
    public void i_review_a_submitted_welslness_article(String articleId) {
        app1.reviewSubmittedArticle(articleId);
    }

   
    @Then("the article should be marked as {string}")
    public void the_article_should_be_marked_as(String status) {
        app1.assertArticleStatuss(status);
    }

    @Then("it should be visible on the platform")
    public void it_should_be_visible_on_the_platform() {
        app1.assertArticleStatus(true);
    }

    @Then("it should not be visible on the platform")
    public void it_should_not_be_visible_on_the_platform() {
        app1.assertArticleStatus(false);
    }

 
    @When("I enter {string} into the search bar")
    public void i_enter_into_the_search_bar(String query) {
        app1.enterSearchQuery(query);
    }

    @Then("I should see articles related to {string}")
    public void i_should_see_articles_related_to(String topic) {
        app1.assertArticlesRelatedTo(topic);
    }

    @Then("the search results should contain the word {string} in the title")
    public void the_search_results_should_contain_the_word_in_the_title(String word) {
        app1.assertSearchResultsContain(word);
    }

    @When("I select {string} from the article status dropdown")
    public void i_select_from_the_article_status_dropdown(String status) {
        app1.selectArticleStatus(status, status);
    }

    @Then("I should see only articles with the {string} status")
    public void i_should_see_only_articles_with_the_status(String status) {
        app1.assertOnlyArticlesWithStatus(status);
    }

    @Then("I should see a list of programs sorted by enrollment numbers")
    public void i_should_see_a_list_of_programs_sorted_by_enrollment_numbers() {
        app1.assertProgramsSortedByEnrollment();
    }

    @When("I select {string} as the report type")
    public void i_select_as_the_report_type(String reportType) {
        app1.selectReportType(reportType);
    }

 

    @Then("a PDF report should be created and available for download")
    public void a_pdf_report_should_be_created_and_available_for_download() {
        app1.assertPdfReportAvailableForDownload();
    }

    @Then("I should see two sections: active programs and completed programs")
    public void i_should_see_two_sections_active_programs_and_completed_programs() {
        app1.assertSectionsVisible("active programs", "completed programs");
    }

    @When("I fill in the user's details \\(e.g., name, role)")
    public void i_fill_in_the_user_s_details_e_g_name_role() {
        app1.fillUserDetails();
    }

    @Then("the new user account should be created successfully")
    public void the_new_user_account_should_be_created_successfully() {
        app1.assertUserAccountCreated("John Doe");
    }

    @When("I select an existing user account")
    public void i_select_an_existing_user_account() {
        app1.selectUserAccount("John Doe");
    }

    @When("I update the user details \\(e.g., name, role)")
    public void i_update_the_user_details_e_g_name_role() {
        app1.updateUserDetails("Updated Name", "Updated Role");
    }

    @Then("the user account should be updated successfully")
    public void the_user_account_should_be_updated_successfully() {
        app1.assertUserAccountUpdated("Updated Name");
    }

    @When("I select a user account")
    public void i_select_a_user_account() {
        app1.selectUserAccount("John Doe");
    }

    @Then("the user account should be marked as inactive")
    public void the_user_account_should_be_marked_as_inactive() {
        app1.assertUserAccountInactive("John Doe");
    }

    @When("I review an instructor's application")
    public void i_review_an_instructor_s_application() {
        app1.reviewInstructorApplication("InstructorName");
    }

    @Then("the instructor account should be activated")
    public void the_instructor_account_should_be_activated() {
        app1.assertInstructorAccountActivated("InstructorName");
    }

    //@Then("I should see statistics such as login frequency and program enrollments")
    //public void i_should_see_statistics_such_as_login_frequency_and_program_enrollments() {
      //  app1.assertStatisticsDisplayed();
    //}
    

}