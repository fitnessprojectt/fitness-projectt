package fit;

import static org.junit.Assert.*;
import io.cucumber.java.en.*;

public class MainMenuSteps {

    private String currentScreen;
    private String selectedOption;

    @Given("the user is on the main menu")
    public void the_user_is_on_the_main_menu() {
        currentScreen = "Main Menu";
        System.out.println("User is on the Main Menu.");
    }

    @When("the user selects option {int}")
    public void the_user_selects_option(Integer option) {
        selectedOption = String.valueOf(option);
        System.out.println("User selects option: " + option);
    }

    @Then("the user should be taken to the Admin login screen")
    public void the_user_should_be_taken_to_the_Admin_login_screen() {
        if (selectedOption.equals("1")) {
            currentScreen = "Admin Login Screen";
            System.out.println("Navigating to Admin Login Screen.");
        }
        assertEquals("Admin Login Screen", currentScreen);
    }

    @Then("the user should be taken to the Instructor login screen")
    public void the_user_should_be_taken_to_the_Instructor_login_screen() {
        if (selectedOption.equals("2")) {
            currentScreen = "Instructor Login Screen";
            System.out.println("Navigating to Instructor Login Screen.");
        }
        assertEquals("Instructor Login Screen", currentScreen);
    }

    @Then("the user should be taken to the Client login screen")
    public void the_user_should_be_taken_to_the_Client_login_screen() {
        if (selectedOption.equals("3")) {
            currentScreen = "Client Login Screen";
            System.out.println("Navigating to Client Login Screen.");
        }
        assertEquals("Client Login Screen", currentScreen);
    }

    @Then("the system should exit")
    public void the_system_should_exit() {
        if (selectedOption.equals("4")) {
            System.out.println("Exiting the system...");
            currentScreen = "System Exited";
        }
        assertEquals("System Exited", currentScreen);
    }
}