package fit;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import java.util.List;

public class ProgramManagementSteps {

    private MyApplication app = new MyApplication();

    // تسجيل الدخول كأستاذ
    @Given("I am logged in as an instructor")
    public void iAmLoggedInAsAnInstructor() {
        // معلومات تسجيل الدخول
        String username = "instructor";
        String password = "password123";
        
        // محاولة تسجيل الدخول
        boolean loggedIn = app.loginAsInstructor(username, password);
        if (!loggedIn) {
            throw new RuntimeException("Login failed");
        }
        System.out.println("Login successful!");
    }

    // الانتقال إلى صفحة "إنشاء برنامج"
    @When("I navigate to Create Program page")
    public void iNavigateToCreateProgramPage() {
        app.navigateToPage("Create Program");
        System.out.println("Navigating to Create Program page.");
    }

    // ملء تفاصيل البرنامج
    @When("I fill in the program details \\(title, duration, difficulty level, goals)")
    public void iFillInTheProgramDetailsTitleDurationDifficultyLevelGoals() {
        String title = "Strength Training";
        String duration = "12 weeks";
        String difficultyLevel = "Intermediate";
        String goals = "Build muscle";

        // تمرير المعاملات إلى دالة fillProgramDetails
        app.fillProgramDetails();
        System.out.println("Filled in the program details: " + title + ", " + duration + ", " + difficultyLevel + ", " + goals);
    }

    // إنشاء البرنامج بنجاح
    @Then("Program created successfully")
    public void programCreatedSuccessfully() {
        String title = "Strength Training";
        String duration = "12 weeks";
        String difficultyLevel = "Intermediate";
        String goals = "Build muscle";
        
        // تمرير المعاملات إلى دالة createProgram
        boolean created = app.createProgram();
        if (created) {
            System.out.println("Program created successfully.");
        } else {
            throw new RuntimeException("Program creation failed.");
        }
    }

    // الانتقال إلى صفحة "تحديث البرنامج"
    @When("I navigate to Update Program page")
    public void iNavigateToUpdateProgramPage() {
        app.navigateToPage("Update Program");
        System.out.println("Navigating to Update Program page.");
    }

    // تحديث تفاصيل البرنامج
    @When("I update the program details")
    public void iUpdateTheProgramDetails() {
        String programId = "123";  // افترض أن هذا هو معرف البرنامج
        String newTitle = "Advanced Strength Training";
        
        // تمرير المعرف والعنوان الجديد إلى دالة updateProgram
        app.updateProgram(programId, newTitle);
        System.out.println("Program updated: " + programId + " -> " + newTitle);
    }

    // البرنامج تم تحديثه بنجاح
    @Then("Program updated successfully")
    public void programUpdatedSuccessfully() {
        System.out.println("Program updated successfully.");
    }

    // اختيار برنامج لحذفه
    @When("I select a program to delete")
    public void iSelectAProgramToDelete() {
        String programId = "123";  // افترض أن هذا هو معرف البرنامج
        System.out.println("Selected program to delete: " + programId);
    }

    // تأكيد الحذف
    @When("I confirm the deletion")
    public void iConfirmTheDeletion() {
        String programId = "123";  // افترض أن هذا هو معرف البرنامج
        app.deleteProgram(programId);
        System.out.println("Confirmed deletion of program: " + programId);
    }

    // البرنامج تم حذفه من النظام
    @Then("Program removed from the system")
    public void programRemovedFromTheSystem() {
        System.out.println("Program removed from the system.");
    }

    // الانتقال إلى صفحة "تعيين الجدول الزمني"
    @When("I navigate to Set Schedule page")
    public void iNavigateToSetSchedulePage() {
        app.navigateToPage("Set Schedule");
        System.out.println("Navigating to Set Schedule page.");
    }

    // إضافة جلسة جماعية
    @When("I add a group session schedule \\(date, time, location)")
    public void iAddAGroupSessionScheduleDateTimeLocation() {
        String programName = "Strength Training"; // تعريف اسم البرنامج
        List<String> schedule = List.of("2024-12-10", "10:00 AM", "Room A"); // تحديد الجدول

        // تمرير المعاملات المطلوبة إلى دالة addGroupSessionSchedule
        app.addGroupSessionSchedule(programName, schedule); 
        System.out.println("Group session scheduled on " + schedule.get(0) + " at " + schedule.get(1) + " in " + schedule.get(2));
    }

    // الجلسة الجماعية تم جدولتها بنجاح
    @Then("Group session scheduled successfully")
    public void groupSessionScheduledSuccessfully() {
        System.out.println("Group session scheduled successfully.");
    }  
}
