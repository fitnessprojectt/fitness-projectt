package fit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementstepss {

    private MyApplication app;

    public UserManagementstepss() {
        app = new MyApplication(); // تهيئة MyApplication
    }

    @Given("I am logged in as an admin")
    public void i_am_logged_in_as_an_admin() {
        app.loginAsAdmin("adminUsername", "adminPassword");
    }

    @When("I navigate to the {string} page in content management")
    public void i_navigate_to_the_page_in_content_management(String pageName) {
        app.navigateToPage(pageName);
    }

    @When("I review a submitted wellness article")
    public void i_review_a_submitted_welslness_article(String articleId) {
        app.reviewSubmittedArticle(articleId);
    }

    @When("I click the {string} button")
    public void i_click_the_button(String buttonName) {
        app.clickButton1(buttonName);
    }

    @Then("the article should be marked as {string}")
    public void the_article_should_be_marked_as(String status) {
        app.assertArticleStatuss(status);
    }

    @Then("it should be visible on the platform")
    public void it_should_be_visible_on_the_platform() {
        app.assertArticleStatus(true);
    }

    @Then("it should not be visible on the platform")
    public void it_should_not_be_visible_on_the_platform() {
        app.assertArticleStatus(false);
    }

    @When("I navigate to the {string} page")
    public void i_navigate_to_the_page(String pageName) {
        app.navigateToPage(pageName);
    }

    @When("I enter {string} into the search bar")
    public void i_enter_into_the_search_bar(String query) {
        app.enterSearchQuery(query);
    }

    @Then("I should see articles related to {string}")
    public void i_should_see_articles_related_to(String topic) {
        app.assertArticlesRelatedTo(topic);
    }

    @Then("the search results should contain the word {string} in the title")
    public void the_search_results_should_contain_the_word_in_the_title(String word) {
        app.assertSearchResultsContain(word);
    }

    @When("I select {string} from the article status dropdown")
    public void i_select_from_the_article_status_dropdown(String status) {
        app.selectArticleStatus(status, status);
    }

    @Then("I should see only articles with the {string} status")
    public void i_should_see_only_articles_with_the_status(String status) {
        app.assertOnlyArticlesWithStatus(status);
    }

    @Then("I should see a list of programs sorted by enrollment numbers")
    public void i_should_see_a_list_of_programs_sorted_by_enrollment_numbers() {
        app.assertProgramsSortedByEnrollment();
    }

    @When("I select {string} as the report type")
    public void i_select_as_the_report_type(String reportType) {
        app.selectReportType(reportType);
    }

    @When("I click {string}")
    public void i_click(String buttonName) {
        app.clickButton1(buttonName);
    }

    @Then("a PDF report should be created and available for download")
    public void a_pdf_report_should_be_created_and_available_for_download() {
        app.assertPdfReportAvailableForDownload();
    }

    @Then("I should see two sections: active programs and completed programs")
    public void i_should_see_two_sections_active_programs_and_completed_programs() {
        app.assertSectionsVisible("active programs", "completed programs");
    }

    @When("I fill in the user's details \\(e.g., name, role)")
    public void i_fill_in_the_user_s_details_e_g_name_role() {
        app.fillUserDetails();
    }

    @Then("the new user account should be created successfully")
    public void the_new_user_account_should_be_created_successfully() {
        app.assertUserAccountCreated("John Doe");
    }

    @When("I select an existing user account")
    public void i_select_an_existing_user_account() {
        app.selectUserAccount("John Doe");
    }

    @When("I update the user details \\(e.g., name, role)")
    public void i_update_the_user_details_e_g_name_role() {
        app.updateUserDetails("Updated Name", "Updated Role");
    }

    @Then("the user account should be updated successfully")
    public void the_user_account_should_be_updated_successfully() {
        app.assertUserAccountUpdated("Updated Name");
    }

    @When("I select a user account")
    public void i_select_a_user_account() {
        app.selectUserAccount("John Doe");
    }

    @Then("the user account should be marked as inactive")
    public void the_user_account_should_be_marked_as_inactive() {
        app.assertUserAccountInactive("John Doe");
    }

    @When("I review an instructor's application")
    public void i_review_an_instructor_s_application() {
        app.reviewInstructorApplication("InstructorName");
    }

    @Then("the instructor account should be activated")
    public void the_instructor_account_should_be_activated() {
        app.assertInstructorAccountActivated("InstructorName");
    }

    @Then("I should see statistics such as login frequency and program enrollments")
    public void i_should_see_statistics_such_as_login_frequency_and_program_enrollments() {
        app.assertStatisticsDisplayed();
    }
}
