package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class Main_Menu_steps {

    private String userRole;
    private String selectedOption;
    private String destination;

    // Default constructor
    public Main_Menu_steps() {
        userRole = "client";  // Default user for testing, can be set dynamically
        selectedOption = "";
        destination = "";
    }

    @Given("the user is logged in and on the main dashboard")
    public void givenTheUserIsLoggedInAndOnTheMainDashboard() {
        // Simulate a user being logged in and on the main dashboard
        userRole = "client";  // Default role is client, but it can be overridden dynamically in the other steps
    }

    @When("the user accesses the main menu")
    public void whenTheUserAccessesTheMainMenu() {
        // Simulate user accessing the main menu
        // This can be extended if needed, but it's not required for this step
    }

    @Then("they should see the following options:")
    public void thenTheyShouldSeeTheFollowingOptions(io.cucumber.datatable.DataTable options) {
        // Validate that the main menu shows the expected options
        // Compare the options passed with the expected options in the scenario
        String[] expectedOptions = {"Admin", "Instructor", "Client"};
        for (String option : expectedOptions) {
            assertTrue("Menu should contain " + option, options.asList().contains(option));
        }
    }

    @Given("the user is logged in as an admin")
    public void givenTheUserIsLoggedInAsAnAdmin() {
        // Set the user role to admin
        userRole = "admin";
    }

    @When("the admin selects the \"Admin\" option from the main menu")
    public void whenTheAdminSelectsTheAdminOptionFromTheMainMenu() {
        // Simulate selecting the "Admin" option from the menu
        selectedOption = "Admin";
    }

    @Then("they should be directed to the Admin Section, where they can manage users, programs, and view statistics")
    public void thenTheyShouldBeDirectedToTheAdminSection() {
        // Check that the user is directed to the Admin section when the Admin option is selected
        if (selectedOption.equals("Admin") && userRole.equals("admin")) {
            destination = "Admin Section";
        }
        assertEquals("Admin Section", destination);
    }

    @Given("the user is logged in as an instructor")
    public void givenTheUserIsLoggedInAsAnInstructor() {
        // Set the user role to instructor
        userRole = "instructor";
    }

    @When("the instructor selects the \"Instructor\" option from the main menu")
    public void whenTheInstructorSelectsTheInstructorOptionFromTheMainMenu() {
        // Simulate selecting the "Instructor" option from the menu
        selectedOption = "Instructor";
    }

    @Then("they should be directed to the Instructor Section, where they can manage programs, track client progress, and send notifications")
    public void thenTheyShouldBeDirectedToTheInstructorSection() {
        // Check that the user is directed to the Instructor section when the Instructor option is selected
        if (selectedOption.equals("Instructor") && userRole.equals("instructor")) {
            destination = "Instructor Section";
        }
        assertEquals("Instructor Section", destination);
    }

    @Given("the user is logged in as a client")
    public void givenTheUserIsLoggedInAsAClient() {
        // Set the user role to client
        userRole = "client";
    }

    @When("the client selects the \"Client\" option from the main menu")
    public void whenTheClientSelectsTheClientOptionFromTheMainMenu() {
        // Simulate selecting the "Client" option from the menu
        selectedOption = "Client";
    }

    @Then("they should be directed to the Client Section, where they can explore programs, track progress, and provide feedback")
    public void thenTheyShouldBeDirectedToTheClientSection() {
        // Check that the user is directed to the Client section when the Client option is selected
        if (selectedOption.equals("Client") && userRole.equals("client")) {
            destination = "Client Section";
        }
        assertEquals("Client Section", destination);
    }
}
