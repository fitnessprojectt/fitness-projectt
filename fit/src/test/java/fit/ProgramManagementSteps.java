package fit;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import java.util.List;

public class ProgramManagementSteps {

    private MyApplication app = new MyApplication();
	private String name;
	private String type;
	private String start_date;
	private int end;
	private String end_date;
	private Object difficulty;
	private Object media;
	private Object price;
	private Object schedule;
	private Object titleToUpdate;
	private Object newDuration;
	private Object newDifficulty;
	private Object newGoals;
	private Object newMedia;
	private Object newPrice;
	private Object newSchedule;
	private String programTitle;
	private String sessionType;
	private List<String> sessionSchedule;

    @Given("I am logged in as an instructor")
    public void iAmLoggedInAsAnInstructor() {
        String username = "instructor";
        String password = "password123";
        
        boolean loggedIn = app.loginAsInstructor(username, password);
        if (!loggedIn) {
            throw new RuntimeException("Login failed");
        }
        System.out.println("Login successful!");
    }

    @When("I navigate to Create Program page")
    public void iNavigateToCreateProgramPage() {
        app.navigateToPage1("Create Program");
        System.out.println("Navigating to Create Program page.");
    }

    @When("I fill in the program details \\(title, duration, difficulty level, goals)")
    public void iFillInTheProgramDetailsTitleDurationDifficultyLevelGoals() {
        String title = "Strength Training";
        String duration = "12 weeks";
        String difficultyLevel = "Intermediate";
        String goals = "Build muscle";

        app.fillProgramDetails();
        System.out.println("Filled in the program details: " + title + ", " + duration + ", " + difficultyLevel + ", " + goals);
    }

    @Then("Program created successfully")
    public void programCreatedSuccessfully() {
        String title = "Strength Training";
        String duration = "12 weeks";
        String difficultyLevel = "Intermediate";
        String goals = "Build muscle";
        
        try {
            app.createProgram(title, duration, difficulty, goals, media, price, schedule);
            System.out.println("Program created successfully.");
        } catch (Exception e) {
            System.err.println("An error occurred during program creation: " + e.getMessage());
            e.printStackTrace(); 
        }
    }

    @When("I navigate to Update Program page")
    public void iNavigateToUpdateProgramPage() {
        app.navigateToPage1("Update Program");
        System.out.println("Navigating to Update Program page.");
    }
    @When("I update the program details")
    public void iUpdateTheProgramDetails() {
        String programId = "123";  
        String newTitle = "Advanced Strength Training";
        
        app.updateProgram(titleToUpdate, newDuration, newDifficulty, newGoals, newMedia, newPrice, newSchedule);
        System.out.println("Program updated: " + programId + " -> " + newTitle);
    }

    @Then("Program updated successfully")
    public void programUpdatedSuccessfully() {
        System.out.println("Program updated successfully.");
    }
    @When("I select a program to delete")
    public void iSelectAProgramToDelete() {
        String programId = "123";  
        System.out.println("Selected program to delete: " + programId);
    }
    @When("I confirm the deletion")
    public void iConfirmTheDeletion() {
        String programId = "123"; 
        app.deleteProgram(programId);
        System.out.println("Confirmed deletion of program: " + programId);
    }
    @Then("Program removed from the system")
    public void programRemovedFromTheSystem() {
        System.out.println("Program removed from the system.");
    }

    @When("I navigate to Set Schedule page")
    public void iNavigateToSetSchedulePage() {
        app.navigateToPage1("Set Schedule");
        System.out.println("Navigating to Set Schedule page.");
    }

    @When("I add a group session schedule \\(date, time, location)")
    public void iAddAGroupSessionScheduleDateTimeLocation() {
        String programName = "Strength Training"; 
        List<String> schedule = List.of("2024-12-10", "10:00 AM", "Room A"); 

        app.setGroupSessionSchedules( programTitle,  sessionType, sessionSchedule); 
        System.out.println("Group session scheduled on " + schedule.get(0) + " at " + schedule.get(1) + " in " + schedule.get(2));
    }

    @Then("Group session scheduled successfully")
    public void groupSessionScheduledSuccessfully() {
        System.out.println("Group session scheduled successfully.");
    }
}
        
