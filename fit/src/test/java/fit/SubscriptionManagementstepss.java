package fit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubscriptionManagementstepss {

    private MyApplication app;

    public SubscriptionManagementstepss() {
        app = new MyApplication(); // تهيئة MyApplication
    }

    // 1. **Creating a Subscription Plan** - استدعاء الفنكشن للتحقق من حفظ الخطة
    @Then("the new plan should be saved and made available for assignment")
    public void the_new_plan_should_be_saved_and_made_available_for_assignment() {
        // استدعاء الدالة لحفظ الخطة الجديدة
        app.saveNewSubscriptionPlan();
        
        // التحقق من حفظ الخطة بشكل صحيح
        boolean isSaved = app.checkIfPlanIsSaved(); 
        assert isSaved : "Plan was not saved correctly!";  // التحقق من حالة الحفظ
    }

    // 2. **Assigning a Subscription Plan** - استدعاء الفنكشن للتحقق من تخصيص الخطة للمستخدم
    @Then("the user should gain access to the features of the assigned plan")
    public void the_user_should_gain_access_to_the_features_of_the_assigned_plan() {
        // تخصيص الخطة للمستخدم
        app.assignSubscriptionPlanToUser("user123");
        
        // التحقق من وصول المستخدم إلى ميزات الخطة
        boolean hasAccess = app.checkUserAccessToPlanFeatures("user123");
        assert hasAccess : "User does not have access to the plan's features!";
    }

    // 3. **Viewing Active Subscriptions** - استدعاء الفنكشن للتحقق من عرض الاشتراكات النشطة
    @Then("a list of active subscriptions with relevant details should be displayed")
    public void a_list_of_active_subscriptions_with_relevant_details_should_be_displayed() {
        // استدعاء الدالة لعرض الاشتراكات النشطة
        app.viewActiveSubscriptions();
        
        // التحقق من عرض الاشتراكات بشكل صحيح
        boolean subscriptionsDisplayed = app.areActiveSubscriptionsDisplayed();
        assert subscriptionsDisplayed : "No active subscriptions displayed!";
    }

    // 4. **Upgrading a Subscription** - استدعاء الفنكشن للتحقق من معالجة الترقية
    @Then("the system should process the upgrade and activate the new plan")
    public void the_system_should_process_the_upgrade_and_activate_the_new_plan() {
        // استدعاء الدالة لمعالجة الترقية
        app.processSubscriptionUpgrade();
        
        // التحقق من تفعيل الخطة الجديدة بعد الترقية
        boolean isUpgraded = app.activateNewPlanAfterUpgrade();
        assert isUpgraded : "Upgrade was not processed correctly!";
    }
 
    @Given("an admin wants to create a new subscription plan")
    public void anAdminWantsToCreateANewSubscriptionPlan() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("they provide the required plan details")
    public void theyProvideTheRequiredPlanDetails() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
