package fit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import java.util.List;

public class Program_Exploration_and_Enrollment_steps {

    private MyApplication app;
    private List<String> filteredPrograms;
    private String enrollmentConfirmation;
    private String programSchedule;

    public Program_Exploration_and_Enrollment_steps() {
        app = new MyApplication(); // Initialize MyApplication
    }

    // Scenario 1: Browse programs by difficulty level
    @Given("the client is on the program browsing page")
    public void the_client_is_on_the_program_browsing_page() {
        app.navigateToProgramBrowsingPage(); // Navigate to the program browsing page
    }

    @When("the client filters programs by difficulty level {string}")
    public void the_client_filters_programs_by_difficulty_level(String difficulty) {
        filteredPrograms = app.filterProgramsByDifficulty(difficulty); // Filter programs by difficulty
    }

    @Then("the system displays all available programs with difficulty level {string}")
    public void the_system_displays_all_available_programs_with_difficulty_level(String difficulty) {
        assertNotNull(filteredPrograms);
        assertFalse(filteredPrograms.isEmpty());
        for (String program : filteredPrograms) {
            assertTrue(program.contains(difficulty));
        }
    }

    // Scenario 2: Browse programs by focus area
    @When("the client filters programs by focus area {string}")
    public void the_client_filters_programs_by_focus_area(String focusArea) {
        filteredPrograms = app.filterProgramsByFocusArea(focusArea); // Filter programs by focus area
    }

    @Then("the system displays all available programs with focus area {string}")
    public void the_system_displays_all_available_programs_with_focus_area(String focusArea) {
        assertNotNull(filteredPrograms);
        assertFalse(filteredPrograms.isEmpty());
        for (String program : filteredPrograms) {
            assertTrue(program.contains(focusArea));
        }
    }

    // Scenario 3: Browse programs by both difficulty level and focus area
    @When("the client filters programs by difficulty level {string} and focus area {string}")
    public void the_client_filters_programs_by_difficulty_level_and_focus_area(String difficulty, String focusArea) {
        filteredPrograms = app.filterProgramsByDifficultyAndFocusArea(difficulty, focusArea);
    }

    @Then("the system displays all available programs with difficulty level {string} and focus area {string}")
    public void the_system_displays_all_available_programs_with_difficulty_level_and_focus_area(String difficulty, String focusArea) {
        assertNotNull(filteredPrograms);
        assertFalse(filteredPrograms.isEmpty());
        for (String program : filteredPrograms) {
            assertTrue(program.toLowerCase().contains(difficulty.toLowerCase()));
            assertTrue(program.toLowerCase().contains(focusArea.toLowerCase()));
        }
    }



    // Scenario 4: Enroll in a program
    @Given("the client has selected a program")
    public void the_client_has_selected_a_program() {
        app.selectProgram("Beginner Yoga Program"); // Select a program (example: Beginner Yoga Program)
    }

    @When("the client clicks \"Enroll\"")
    public void the_client_clicks_enroll() {
        enrollmentConfirmation = app.enrollInSelectedProgram(); // Enroll in the selected program
    }

    @Then("the system adds the selected program to the client’s profile and confirms enrollment")
    public void the_system_adds_the_selected_program_to_the_client_s_profile_and_confirms_enrollment() {
        assertNotNull(enrollmentConfirmation);
        assertEquals("Enrollment Successful!", enrollmentConfirmation);
        assertTrue(app.isProgramEnrolled());
    }

    // Scenario 5: View program schedule
    @Given("the client is enrolled in a program")
    public void the_client_is_enrolled_in_a_program() {
        app.selectProgram("Intermediate Muscle Building Mastery");
        app.enrollInSelectedProgram();
    }

    @When("the client requests to view the schedule for the program")
    public void the_client_requests_to_view_the_schedule_for_the_program() {
        programSchedule = app.getProgramSchedule();
    }

    @Then("the system displays the start and end date, and time for the program")
    public void the_system_displays_the_start_and_end_date_and_time_for_the_program() {
        assertNotNull(programSchedule);
        assertTrue(programSchedule.contains("Start Date"));
        assertTrue(programSchedule.contains("End Date"));
        assertTrue(programSchedule.contains("Time"));
    }


}

