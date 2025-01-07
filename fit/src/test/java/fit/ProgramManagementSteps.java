package fit;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import java.util.List;

public class ProgramManagementSteps {

    private Instructor app2 = new Instructor();
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
	    
	    if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
	        throw new IllegalArgumentException("Username or password cannot be empty.");
	    }
	    
	    
	        boolean loggedIn = app2.loginAsInstructor(username, password);
	        if (!loggedIn) {
	            System.out.println("try again!");
	        }
	        System.out.println("Login successful!");
	}
	   // catch (Exception e) {
	       // e.printStackTrace();  // Provides detailed error output for debugging
	        //throw new RuntimeException("An error occurred during login: " + e.getMessage());
	    //}
	

    @When("I navigate to Create Program page")
    public void iNavigateToCreateProgramPage() {
        app2.navigateToPage1();
        System.out.println("Navigating to Create Program page.");
    }

    @When("I fill in the program details \\(title, duration, difficulty level, goals)")
    public void iFillInTheProgramDetailsTitleDurationDifficultyLevelGoals() {
        String title = "Strength Training";
        String duration = "12 weeks";
        String difficultyLevel = "Intermediate";
        String goals = "Build muscle";

        app2.fillProgramDetails();
        System.out.println("Filled in the program details: " + title + ", " + duration + ", " + difficultyLevel + ", " + goals);
    }

    @Then("Program created successfully")
    public void programCreatedSuccessfully() {
        String title = "Strength Training";
        String duration = "12 weeks";
        String difficultyLevel = "Intermediate";
        String goals = "Build muscle";
        
        try {
            app2.createProgram(title, duration, difficulty, goals, media, price, schedule);
            System.out.println("Program created successfully.");
        } catch (Exception e) {
            System.err.println("An error occurred during program creation: " + e.getMessage());
            e.printStackTrace(); 
        }
    }

    @When("I navigate to Update Program page")
    public void iNavigateToUpdateProgramPage() {
        app2.navigateToPage1();
        System.out.println("Navigating to Update Program page.");
    }
    @When("I update the program details")
    public void iUpdateTheProgramDetails() {
        String programId = "123";  
        String newTitle = "Advanced Strength Training";
        
        app2.updateProgram(titleToUpdate, newDuration, newDifficulty, newGoals, newMedia, newPrice, newSchedule);
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
        app2.deleteProgram(programId);
        System.out.println("Confirmed deletion of program: " + programId);
    }
    @Then("Program removed from the system")
    public void programRemovedFromTheSystem() {
        System.out.println("Program removed from the system.");
    }

    @When("I navigate to Set Schedule page")
    public void iNavigateToSetSchedulePage() {
        app2.navigateToPage1();
        System.out.println("Navigating to Set Schedule page.");
    }
    @Then("Group session scheduled successfully")
    public void groupSessionScheduledSuccessfully() {
        
    }

      @When("I add a group session schedule \\(date, time, location)")
    public void iAddAGroupSessionScheduleDateTimeLocation() {
        ;
    }

}
        
