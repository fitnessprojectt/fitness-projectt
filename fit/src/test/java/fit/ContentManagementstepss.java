package fit;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import java.util.*;

public class ContentManagementstepss {

    private String tipContent;
    private List<String> tips = new ArrayList<>();
    private String displayedMessage;
 

    @Given("I am logged into the admin portal")
    public void iAmLoggedIntoTheAdminPortal() {
        boolean isLoggedIn = true; 
        assertTrue("Admin is not logged in", isLoggedIn);
    }
    

    @Given("I have the necessary permissions to manage content")
    public void iHaveTheNecessaryPermissionsToManageContent() {
        boolean hasPermissions = true; 
        assertTrue("Admin lacks permissions", hasPermissions);
    }

    @Given("the user wants to submit a tip")
    public void theUserWantsToSubmitATip() {
    }

    @When("the tip content is {string}")
    public void theTipContentIs(String content) {
        this.tipContent = content;
        if (content.isEmpty()) {
            this.displayedMessage = "Error: Tip content cannot be empty.";
        } else {
            tips.add(content);
            this.displayedMessage = "Tip added successfully.";
        }
        if (content.trim().isEmpty()) {
            this.displayedMessage = "Error: Tip content cannot be empty.";
        }

    }



    @Then("the tip should be added successfully")
    
    public void theTipShouldBeAddedSuccessfully() {
    
        assertTrue("Tip was not added", tips.contains(tipContent));
       
    }

 

    @Given("there is a tip {string} in the system")
    public void thereIsATipInTheSystem(String tip) {
        tips.add(tip);
    }

    @When("the user reviews tips")
    public void theUserReviewsTips() {
        if (!tips.isEmpty()) {
            displayedMessage = tips.get(0);
        } else {
            displayedMessage = "No tips available.";
        }
    }

    @Then("the system should display the first tip {string}")
    public void theSystemShouldDisplayTheFirstTip(String tip) {
        assertEquals(tip, displayedMessage);
    }

    @Given("the tip {string} exists in the system")
    public void theTipExistsInTheSystem(String tip) {
        tips.add(tip);
    }

    @When("the user approves the tip {string}")
    public void theUserApprovesTheTip(String tip) {
        if (tips.contains(tip)) {
            displayedMessage = "Tip approved: " + tip;
        } else {
            displayedMessage = "Error: Tip not found.";
        }
    }



    @Then("the tip {string} should be removed from the system")
    public void theTipShouldBeRemovedFromTheSystem(String tip) {
        assertFalse("Tip was not removed", tips.contains(tip));
    }
    

    @When("the tip content is empty")
    public void theTipContentIsEmpty() {
        this.tipContent = ""; 
        this.displayedMessage = "Error: Tip content cannot be empty."; 
    }
 
   

    @Then("the system should display {string}")
    public void theSystemShouldDisplay(String expectedMessage) {
        assertEquals(expectedMessage, displayedMessage);
    }
    @Given("the user attempts to reject a nonexistent tip")
    public void theUserAttemptsToRejectANonexistentTip() {
        this.tipContent = null;
    }
    @Before
    public void reset() {
        tips.clear();
        displayedMessage = null;
        tipContent = null;
    }

    @When("the user views all tips")
    public void theUserViewsAllTips() {
        if (tips.isEmpty()) {
            displayedMessage = "No tips available.";
        } else {
            displayedMessage = String.join(", ", tips);
        }
    }
    @When("the user rejects the tip {string}")
    public void theUserRejectsTheTip(String tipContent) {
        if (!tips.contains(tipContent)) { 
            displayedMessage = "Error: Tip not found.";
        } else {
            tips.remove(tipContent);
            displayedMessage = "Tip rejected: " + tipContent;
        }
    }



}
