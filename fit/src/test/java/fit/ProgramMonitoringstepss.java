package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ProgramMonitoringstepss {

    private MyApplication app;

    public ProgramMonitoringstepss() {
        app = new MyApplication(); // تهيئة MyApplication
    }

    @Given("I am logged into the Program Monitoring System")
    public void i_am_logged_into_the_program_monitoring_system() {
        app.loginAsAdmin("adminUsername", "adminPassword"); // تسجيل الدخول كأدمن باستخدام بيانات افتراضية
    }

    @When("I navigate to the {string} section")
    public void i_navigate_to_the_section(String section) {
        app.navigateToPage(section);  // التوجيه إلى القسم المطلوب
    }

    @Then("I should see a bar chart representing the enrollment numbers")
    public void i_should_see_a_bar_chart_representing_the_enrollment_numbers() {
        System.out.println("Displaying bar chart for enrollment numbers.");
    }

    @Then("I should be able to filter by different time periods")
    public void i_should_be_able_to_filter_by_different_time_periods() {
        System.out.println("Filter applied for different time periods.");
    }

    @Given("I am on the {string} section")
    public void i_am_on_the_section(String section) {
        app.navigateToPage(section);  // التوجيه إلى القسم المطلوب
    }

    @When("I select {string} and specify a date range")
    public void i_select_and_specify_a_date_range(String reportType) {
        app.selectReportType(reportType); // تحديد نوع التقرير
    }

    @Then("I should see a report with total revenue for each program")
    public void i_should_see_a_report_with_total_revenue_for_each_program() {
        System.out.println("Displaying total revenue report for each program.");
    }

    @Then("I should see the amount paid by each client for the program")
    public void i_should_see_the_amount_paid_by_each_client_for_the_program() {
        System.out.println("Displaying amount paid by each client for the program.");
    }

    @Then("I should be able to export the report in PDF or Excel format")
    public void i_should_be_able_to_export_the_report_in_pdf_or_excel_format() {
        System.out.println("Exporting report in selected format.");
    }

    @When("I select {string}")
    public void i_select(String filterType) {
        app.selectReportType(filterType); // تحديد نوع التقرير بناءً على الخيار المحدد
    }

    @When("I specify a program or client")
    public void i_specify_a_program_or_client() {
        app.selectUserAccount("client");  // تحديد حساب البرنامج أو العميل
    }

    @Then("I should see attendance statistics with the number of sessions attended")
    public void i_should_see_attendance_statistics_with_the_number_of_sessions_attended() {
        System.out.println("Displaying attendance statistics with sessions attended.");
    }

    @Then("I should see the number of sessions missed by each client")
    public void i_should_see_the_number_of_sessions_missed_by_each_client() {
        System.out.println("Displaying number of sessions missed by each client.");
    }

    @When("I specify a client or program")
    public void i_specify_a_client_or_program() {
        app.selectUserAccount("client");  // تحديد حساب العميل أو البرنامج
    }

    @Then("I should see the client's progress through the program")
    public void i_should_see_the_client_s_progress_through_the_program() {
        System.out.println("Displaying client progress through the program.");
    }

    @Then("I should see milestones and achievements reached by the client")
    public void i_should_see_milestones_and_achievements_reached_by_the_client() {
        System.out.println("Displaying client milestones and achievements.");
    }

    @When("I select the {string} tab")
    public void i_select_the_tab(String tab) {
        System.out.println("Navigating to the " + tab + " tab.");
    }

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

    @Given("I am a client enrolled in a program")
    public void i_am_a_client_enrolled_in_a_program() {
        System.out.println("Client is enrolled in a program.");
    }

    @When("a program session is approaching")
    public void a_program_session_is_approaching() {
        System.out.println("Program session is approaching.");
    }

    @Then("I should receive a notification about the upcoming session")
    public void i_should_receive_a_notification_about_the_upcoming_session() {
        System.out.println("Receiving notification about the upcoming session.");
    }

    @Then("I should receive a reminder for any tasks or assessments that need to be completed")
    public void i_should_receive_a_reminder_for_any_tasks_or_assessments_that_need_to_be_completed() {
        System.out.println("Receiving reminder for tasks or assessments.");
    }

    @When("I complete a milestone or reach {int}% completion")
    public void i_complete_a_milestone_or_reach_completion(Integer completionPercentage) {
        System.out.println("Completing milestone or reaching " + completionPercentage + "% completion.");
    }

    @Then("I should receive an alert about my progress and achievements")
    public void i_should_receive_an_alert_about_my_progress_and_achievements() {
        System.out.println("Receiving alert about progress and achievements.");
    }

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
      
    }
}
