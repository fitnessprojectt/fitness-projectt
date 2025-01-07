package fit;
import io.cucumber.java.en.Given;
import fit.Admin;
import fit.Clienttt;
import fit.Instructor;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Ignore;

import io.cucumber.java.Before;

public class SubscriptionManagementstepss {

    private Admin app1;
    private String userId;
    private String newPlanId;

   
    @Before
    public void setUp() {
        app1 = new Admin(); 
        userId = "user123"; 
        newPlanId = "planA";
    }
    @When("they access the subscription management dashboard")
    public void theyAccessTheSubscriptionManagementDashboard() {
      
        System.out.println("Admin accesses the subscription management dashboard");
        app1.viewActiveSubscriptions(); 
    }
    @Given("the admin wants to view all active subscriptions")
    public void theAdminWantsToViewAllActiveSubscriptions() {
        System.out.println("Admin wants to view all active subscriptions");
    }
    @Given("an admin wants to create a new subscription plan")
    public void anAdminWantsToCreateANewSubscriptionPlan() {
      
        System.out.println("Admin wants to create a new subscription plan");
    }
    @When("they provide the required plan details")
    public void theyProvideTheRequiredPlanDetails() {
      
        System.out.println("Admin provides the required plan details");
        
        app1.createNewSubscriptionPlan("Basic Plan", "A brief description", 10.99);
    }
    @Given("a user needs to be assigned a subscription plan")
    public void aUserNeedsToBeAssignedASubscriptionPlan() {
      
        System.out.println("A user needs a subscription plan");
        userId = "user123"; 
    }
    @Given("a user wants to upgrade their current subscription")
    public void aUserWantsToUpgradeTheirCurrentSubscription() {
       
        System.out.println("User wants to upgrade their subscription");
        userId = "user123";
        newPlanId = "planB"; 
    }
    @When("they initiate an upgrade request")
    public void theyInitiateAnUpgradeRequest() {
       
        System.out.println("User initiates an upgrade request");
        app1.upgradeUserSubscription(userId, newPlanId); 
    }

    @Then("the new plan should be saved and made available for assignment")
    public void the_new_plan_should_be_saved_and_made_available_for_assignment() {
        app1.saveNewSubscriptionPlan(userId, newPlanId);
        
        boolean isSaved = app1.checkIfPlanIsSaved(newPlanId);
        assert isSaved : "Plan was not saved correctly!";
    }
    @When("the admin assigns the plan to the user")
    public void theAdminAssignsThePlanToTheUser() {
        System.out.println("Admin assigns the plan to the user");
        app1.assignSubscriptionPlanToUser(userId, newPlanId);  
    }

    @Then("the user should gain access to the features of the assigned plan")
    public void the_user_should_gain_access_to_the_features_of_the_assigned_plan() {
       
    }

    @Then("a list of active subscriptions with relevant details should be displayed")
    public void a_list_of_active_subscriptions_with_relevant_details_should_be_displayed() {
   
    }

@Then("the system should process the upgrade and activate the new plan")
public void theSystemShouldProcessTheUpgradeAndActivateTheNewPlan() {
}

}
