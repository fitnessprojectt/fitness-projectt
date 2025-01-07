package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProgramMonitoringstepss {

    private Admin app1;

    public ProgramMonitoringstepss() {
        app1 = new Admin(); 
    }

    // تسجيل الدخول بنجاح
    @Given("I am logged into the Program Monitoring System")
    public void i_am_logged_into_the_program_monitoring_system() {
        app1.loginAsAdmin("adminUsername", "adminPassword"); 
    }

    // محاولة تسجيل الدخول مع بيانات غير صحيحة
    @Given("I am not logged in")
    public void i_am_not_logged_in() {
        System.out.println("User is not logged in.");
    }

    @When("I try to login with invalid credentials")
    public void i_try_to_login_with_invalid_credentials() {
        app1.loginAsAdmin("invalidUsername", "invalidPassword");
    }

    @Then("I should receive an error message indicating invalid credentials")
    public void i_should_receive_an_error_message_indicating_invalid_credentials() {
        System.out.println("Received error message for invalid login.");
    }

    // الانتقال إلى قسم معين
    @When("I navigate to the {string} section")
    public void i_navigate_to_the_section(String section) {
        app1.navigateToPage(section); 
    }

    // التحقق من الوصول إلى قسم غير مصرح به
    @Given("I am not authorized to access the {string} section")
    public void i_am_not_authorized_to_access_the_section(String section) {
        System.out.println("User does not have access to " + section + " section.");
    }

    @When("I try to navigate to the {string} section")
    public void i_try_to_navigate_to_the_section(String section) {
        app1.navigateToPage(section);
    }

    @Then("I should see an error message about unauthorized access")
    public void i_should_see_an_error_message_about_unauthorized_access() {
        System.out.println("Received error message about unauthorized access.");
    }

    // التفاعل مع التقارير والفلاتر
    @Then("I should see a bar chart representing the enrollment numbers")
    public void i_should_see_a_bar_chart_representing_the_enrollment_numbers() {
        System.out.println("Displaying bar chart for enrollment numbers.");
    }

    @Then("I should be able to filter by different time periods")
    public void i_should_be_able_to_filter_by_different_time_periods() {
        System.out.println("Filter applied for different time periods.");
    }

    @When("I select a filter for {string} and specify a range from {int} to {int}")
    public void i_select_a_filter_for_and_specify_a_range(String filterType, Integer min, Integer max) {
        app1.selectFilter(filterType, min, max);
    }

    @Then("I should see the results filtered by {string} from {int} to {int}")
    public void i_should_see_the_results_filtered_by_from_to(String filterType, Integer min, Integer max) {
        System.out.println("Results filtered by " + filterType + " from " + min + " to " + max);
    }

    // التفاعل مع التقارير والفترات الزمنية
    @When("I specify a time range from {string} to {string}")
    public void i_specify_a_time_range_from_to(String startDate, String endDate) {
        app1.setDateRange(startDate, endDate);
    }

    @Then("I should see the data filtered by the specified date range")
    public void i_should_see_the_data_filtered_by_the_specified_date_range() {
        System.out.println("Data filtered by date range.");
    }

    // التعامل مع الجداول
    @When("I search for a program with the name {string}")
    public void i_search_for_a_program_with_the_name(String programName) {
        app1.searchForProgram(programName);
    }

    @Then("I should see the program {string} listed in the results")
    public void i_should_see_the_program_listed_in_the_results(String programName) {
        System.out.println("Program " + programName + " displayed in search results.");
    }

    // استقبال إشعارات
    @Then("I should receive a notification about the upcoming session")
    public void i_should_receive_a_notification_about_the_upcoming_session() {
        System.out.println("Receiving notification about the upcoming session.");
    }

    @Then("I should receive a reminder for any tasks or assessments that need to be completed")
    public void i_should_receive_a_reminder_for_any_tasks_or_assessments_that_need_to_be_completed() {
        System.out.println("Receiving reminder for tasks or assessments.");
    }

    // إتمام المهام والمراحل
    @When("I complete a milestone or reach {int}% completion")
    public void i_complete_a_milestone_or_reach_completion(Integer completionPercentage) {
        System.out.println("Completing milestone or reaching " + completionPercentage + "% completion.");
    }

    @Then("I should receive an alert about my progress and achievements")
    public void i_should_receive_an_alert_about_my_progress_and_achievements() {
        System.out.println("Receiving alert about progress and achievements.");
    }

    // تصدير التقرير
    @Given("I am viewing a revenue report")
    public void i_am_viewing_a_revenue_report() {
        System.out.println("Viewing revenue report.");
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonName) {
        System.out.println("Clicked on the " + buttonName + " button.");
    }

    @Then("I should be able to select PDF or Excel format")
    public void i_should_be_able_to_select_pdf_or_excel_format() {
        System.out.println("Selecting PDF or Excel format.");
    }

    @Then("I should receive the report in the selected format")
    public void i_should_receive_the_report_in_the_selected_format() {
        System.out.println("Received report in selected format.");
    }

    // إدارة البرامج
    @Then("I should see a list of active programs with the number of enrollees")
    public void i_should_see_a_list_of_active_programs_with_the_number_of_enrollees() {
        System.out.println("Displaying active programs with enrollees count.");
    }

    @Then("I should see the program start and end dates")
    public void i_should_see_the_program_start_and_end_dates() {
        System.out.println("Displaying program start and end dates.");
    }

    @Then("I should see the remaining capacity for each active program")
    public void i_should_see_the_remaining_capacity_for_each_active_program() {
        System.out.println("Displaying remaining capacity for each active program.");
    }

    @Then("I should see a list of completed programs with total revenue and attendance statistics")
    public void i_should_see_a_list_of_completed_programs_with_total_revenue_and_attendance_statistics() {
        System.out.println("Displaying completed programs with total revenue and attendance statistics.");
    }

    @Then("I should be able to archive or deactivate completed programs")
    public void i_should_be_able_to_archive_or_deactivate_completed_programs() {
        System.out.println("Archiving or deactivating completed programs.");
    }

    // لوحة بيانات العميل
    @Given("I am on the client dashboard")
    public void i_am_on_the_client_dashboard() {
        System.out.println("Navigating to the client dashboard.");
    }

    @When("I view my enrolled programs")
    public void i_view_my_enrolled_programs() {
        System.out.println("Viewing enrolled programs.");
    }

    @Then("I should see a progress bar indicating my completion status")
    public void i_should_see_a_progress_bar_indicating_my_completion_status() {
        System.out.println("Displaying progress bar for completion status.");
    }

    @Then("I should see the milestones and key achievements I’ve completed")
    public void i_should_see_the_milestones_and_key_achievements_i_ve_completed() {
        System.out.println("Displaying completed milestones and key achievements.");
    }

    // تنبيهات في حال اقتراب جلسة
    @Given("I am a client enrolled in a program")
    public void i_am_a_client_enrolled_in_a_program() {
        System.out.println("Client is enrolled in a program.");
    }

    @When("a program session is approaching")
    public void a_program_session_is_approaching() {
        System.out.println("Program session is approaching.");
    }

    @Then("I should receive a notification about the upcoming session")
    public void i_should_receive_a_notification_about_the_upcoming_session1() {
        System.out.println("Receiving notification about the upcoming session.");
    }

    @Then("I should receive a reminder for any tasks or assessments that need to be completed")
    public void i_should_receive_a_reminder_for_any_tasks_or_assessments_that_need_to_be_completed1() {
        System.out.println("Receiving reminder for tasks or assessments.");
    }
}
