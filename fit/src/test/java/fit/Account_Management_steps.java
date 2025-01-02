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
        app = new MyApplication(); 
    }

    @Given("the client opens the system")
    public void theClientOpensTheSystem() {
        app.initializeSystem(); 
    }

    @When("the client enters personal details such as age and fitness goals")
    public void theClientEntersPersonalDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        int age = Integer.parseInt(data.get(1).get(0)); 
        String fitnessGoals = data.get(1).get(1); 
        app.enterClientDetails(age, fitnessGoals); 
    }

    @When("the client submits the profile creation form")
    public void theClientSubmitsTheProfileCreationForm() {
        app.submitProfileCreationForm(); 
    }

    @When("the client submits the dietary preferences form")
    public void theClientSubmitsTheDietaryPreferencesForm() {
        app.submitDietaryPreferencesForm(); 
    }

    @Then("the system saves the client profile and confirms the profile creation")
    public void theSystemSavesTheClientProfileAndConfirmsTheProfileCreation() {
        assertTrue(app.isProfileCreated()); 
        assertEquals("Profile successfully created!", app.getProfileCreationConfirmation());
    }

    @Then("the system updates the client profile with dietary preferences and confirms the update")
    public void theSystemUpdatesTheClientProfileWithDietaryPreferencesAndConfirmsTheUpdate() {
        assertTrue(app.isDietaryPreferencesUpdated()); 
        assertEquals("Dietary preferences successfully updated!", app.getDietaryUpdateConfirmation());
    }

    @Then("the system updates the profile and confirms the changes")
    public void theSystemUpdatesTheProfileAndConfirmsTheChanges() {
        assertTrue(app.isProfileUpdated()); 
        assertEquals("Profile successfully updated!", app.getProfileUpdateConfirmation());
    }

    @Then("the system displays an error message indicating that all fields are required")
    public void theSystemDisplaysAnErrorMessage() {
        assertEquals("All fields are required!", app.getErrorMessage());
    }
    
    @Given("the client has an existing profile")
    public void theClientHasAnExistingProfile() {
        app.createProfile(25, "Weight Loss"); 
    }

    @When("the client updates their personal details")
    public void theClientUpdatesTheirPersonalDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        int age = Integer.parseInt(data.get(1).get(0)); 
        String fitnessGoals = data.get(1).get(1); 
        app.updateClientDetails(age, fitnessGoals); 
    }

    @When("the client submits the profile creation form without entering personal details")
    public void theClientSubmitsTheProfileCreationFormWithoutEnteringPersonalDetails() {
        app.submitProfileCreationForm(); 
    }
    
    @When("the client submits the changes")
    public void theClientSubmitsTheChanges() {
        app.submitProfileUpdate(); 
    }



}