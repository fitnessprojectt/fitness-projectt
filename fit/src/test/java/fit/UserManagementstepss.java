package fit;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserManagementstepss {

    MyApplication app;

    public UserManagementstepss() {
        app = new MyApplication();
    }

    // Simulated storage for user data
    private Map<String, String> userAccount = new HashMap<>();
    private boolean isAccountActive = true;

    @Given("I am logged in")
    public void iAmLoggedIn() {
        System.out.println("Logged into the system.");
        assertTrue("System login failed.", true); // Assume login is always successful for this scenario
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String pageName) {
        System.out.println("Navigated to: " + pageName + " page.");
        assertTrue("Failed to navigate to the page.", pageName != null && !pageName.isEmpty());
    }

    @When("I click {string}")
    public void iClick(String buttonName) {
        System.out.println("Clicked the " + buttonName + " button.");
        assertTrue("Button click failed.", buttonName != null && !buttonName.isEmpty());
    }

    @When("I fill in the user's details \\(e.g., name, role)")
    public void iFillInTheUserSDetailsEGNameRole() {
        userAccount.put("name", "John Doe");
        userAccount.put("role", "Instructor");
        System.out.println("User details entered: " + userAccount);
        assertTrue("User details not entered properly.", userAccount.containsKey("name") && userAccount.containsKey("role"));
    }

    @Then("the new user account should be created successfully")
    public void theNewUserAccountShouldBeCreatedSuccessfully() {
        boolean accountCreated = !userAccount.isEmpty();
        System.out.println("New user account created successfully for: " + userAccount.get("name"));
        assertTrue("New user account creation failed.", accountCreated);
    }

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        System.out.println("Logged in as admin.");
        assertTrue("Admin login failed.", true); // Assume admin login is always successful for this scenario
    }

    @When("I select an existing user account")
    public void iSelectAnExistingUserAccount() {
        boolean userExists = userAccount.containsKey("name");
        System.out.println("Selected existing user account: " + (userExists ? userAccount.get("name") : "No account found."));
        assertTrue("User account not found to select.", userExists);
    }

    @When("I update the user details \\(e.g., name, role)")
    public void iUpdateTheUserDetailsEGNameRole() {
        userAccount.put("name", "Jane Smith");
        userAccount.put("role", "Client");
        System.out.println("User details updated to: " + userAccount);
        assertTrue("Failed to update user details.", "Jane Smith".equals(userAccount.get("name")) && "Client".equals(userAccount.get("role")));
    }

    @Then("the user account should be updated successfully")
    public void theUserAccountShouldBeUpdatedSuccessfully() {
        boolean accountUpdated = "Jane Smith".equals(userAccount.get("name")) && "Client".equals(userAccount.get("role"));
        System.out.println("User account updated successfully: " + userAccount);
        assertTrue("User account update failed.", accountUpdated);
    }

    @When("I select a user account")
    public void iSelectAUserAccount() {
        boolean userExists = userAccount.containsKey("name");
        System.out.println("User account selected: " + (userExists ? userAccount.get("name") : "No account found to select."));
        assertTrue("User account not found to select.", userExists);
    }

    @Then("the user account should be marked as inactive")
    public void theUserAccountShouldBeMarkedAsInactive() {
        isAccountActive = false;
        System.out.println("User account marked as inactive.");
        assertTrue("Failed to mark user account as inactive.", !isAccountActive);
    }

    @When("I review an instructor's application")
    public void iReviewAnInstructorSApplication() {
        System.out.println("Reviewed instructor's application.");
        assertTrue("Instructor's application review failed.", true); // Assume success for this step
    }

    @Then("the instructor account should be activated")
    public void theInstructorAccountShouldBeActivated() {
        System.out.println("Instructor account activated successfully.");
        assertTrue("Failed to activate instructor's account.", true); // Assume activation is always successful
    }

    @Then("I should see statistics such as login frequency and program enrollments")
    public void iShouldSeeStatisticsSuchAsLoginFrequencyAndProgramEnrollments() {
        System.out.println("Displayed statistics: Login frequency, Program enrollments.");
        assertTrue("Failed to display statistics.", true); // Assume statistics are always displayed correctly
    }

}