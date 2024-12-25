package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.*;

import java.util.List;

public class Account_Management_steps {

    private MyApplication app;

    public Account_Management_steps() {
        app = new MyApplication(); // Initialize your application logic here
    }

    @Given("the client opens the system")
    public void theClientOpensTheSystem() {
        app.initializeSystem(); // Simulate opening the system
    }

    @When("the client enters personal details such as age and fitness goals")
    public void theClientEntersPersonalDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        int age = Integer.parseInt(data.get(1).get(0)); // Get age from the first row
        String fitnessGoals = data.get(1).get(1); // Get fitness goals from the first row
        app.enterClientDetails(age, fitnessGoals); // Simulate entering details
    }

    @When("the client adds dietary preferences")
    public void theClientAddsDietaryPreferences(DataTable dataTable) {
        List<String> preferences = dataTable.asList(String.class); // Get dietary preferences
        app.addDietaryPreferences(preferences); // Simulate adding dietary preferences
    }

    @When("the client submits the profile creation form")
    public void theClientSubmitsTheProfileCreationForm() {
        app.submitProfileCreationForm(); // Simulate form submission
    }

    @When("the client submits the dietary preferences form")
    public void theClientSubmitsTheDietaryPreferencesForm() {
        app.submitDietaryPreferencesForm(); // Simulate dietary preferences submission
    }

    @Then("the system saves the client profile and confirms the profile creation")
    public void theSystemSavesTheClientProfileAndConfirmsTheProfileCreation() {
        assertTrue(app.isProfileCreated()); // Check if the profile is created
        assertEquals("Profile successfully created!", app.getProfileCreationConfirmation());
    }

    @Then("the system updates the client profile with dietary preferences and confirms the update")
    public void theSystemUpdatesTheClientProfileWithDietaryPreferencesAndConfirmsTheUpdate() {
        assertTrue(app.isDietaryPreferencesUpdated()); // Check if preferences are updated
        assertEquals("Dietary preferences successfully updated!", app.getDietaryUpdateConfirmation());
    }

    @Then("the system updates the profile and confirms the changes")
    public void theSystemUpdatesTheProfileAndConfirmsTheChanges() {
        assertTrue(app.isProfileUpdated()); // Check if the profile is updated
        assertEquals("Profile successfully updated!", app.getProfileUpdateConfirmation());
    }

    @Then("the system displays an error message indicating that all fields are required")
    public void theSystemDisplaysAnErrorMessage() {
        assertEquals("All fields are required!", app.getErrorMessage());
    }
    
    @Given("the client has an existing profile")
    public void theClientHasAnExistingProfile() {
        app.createProfile(25, "Weight Loss"); // Simulate creating a profile with default values
    }

    @When("the client updates their personal details")
    public void theClientUpdatesTheirPersonalDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        int age = Integer.parseInt(data.get(1).get(0)); // Get updated age
        String fitnessGoals = data.get(1).get(1); // Get updated fitness goals
        app.updateClientDetails(age, fitnessGoals); // Simulate updating details
    }

    @When("the client submits the profile creation form without entering personal details")
    public void theClientSubmitsTheProfileCreationFormWithoutEnteringPersonalDetails() {
        app.submitProfileCreationForm(); // Submit without setting required fields
    }
    
    @When("the client submits the changes")
    public void theClientSubmitsTheChanges() {
        app.submitProfileUpdate(); // Simulate submitting the profile update
    }



}