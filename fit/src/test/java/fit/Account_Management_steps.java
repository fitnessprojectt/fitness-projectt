package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

public class Account_Management_steps {

    private Clienttt app3;

    public Account_Management_steps() {
        app3 = new Clienttt(); 
    }

    @Given("the client opens the system")
    public void theClientOpensTheSystem() {
        app3.initializeSystem(); 
    }

    @When("the client enters personal details such as age and fitness goals")
    public void theClientEntersPersonalDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        int age = Integer.parseInt(data.get(1).get(0)); 
        String fitnessGoals = data.get(1).get(1); 
        app3.enterClientDetails(age, fitnessGoals); 
    }

    @When("the client submits the profile creation form")
    public void theClientSubmitsTheProfileCreationForm() {
        app3.submitProfileCreationForm(); 
    }

    @When("the client submits the dietary preferences form")
    public void theClientSubmitsTheDietaryPreferencesForm() {
    
    }

    @Then("the system saves the client profile and confirms the profile creation")
    public void theSystemSavesTheClientProfileAndConfirmsTheProfileCreation() {
        assertTrue(app3.isProfileCreated()); 
        assertEquals("Profile successfully created!", app3.getProfileCreationConfirmation());
    }

    @Then("the system updates the client profile with dietary preferences and confirms the update")
    public void theSystemUpdatesTheClientProfileWithDietaryPreferencesAndConfirmsTheUpdate() {
   
    }

    @Then("the system updates the profile and confirms the changes")
    public void theSystemUpdatesTheProfileAndConfirmsTheChanges() {
        
    }

    @Then("the system displays an error message indicating that all fields are required")
    public void theSystemDisplaysAnErrorMessage() {
        assertEquals("All fields are required!", app3.getErrorMessage());
    }
    
    @Given("the client has an existing profile")
    public void theClientHasAnExistingProfile() {
      
    }

    @When("the client updates their personal details")
    public void theClientUpdatesTheirPersonalDetails(DataTable dataTable) {
       
    }

    @When("the client submits the profile creation form without entering personal details")
    public void theClientSubmitsTheProfileCreationFormWithoutEnteringPersonalDetails() {
        app3.submitProfileCreationForm(); 
    }
    
    @When("the client submits the changes")
    public void theClientSubmitsTheChanges() {
   
    }
    @When("the client adds dietary preferences")
    public void theClientAddsDietaryPreferences(io.cucumber.datatable.DataTable dataTable) {
        
        }
    }



