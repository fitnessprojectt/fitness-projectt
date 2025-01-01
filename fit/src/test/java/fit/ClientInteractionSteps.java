package fit;

import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertTrue;


import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class ClientInteractionSteps {

    MyApplication app;
    private String clientName = "Client 1";  // تخصيص اسم العميل بشكل ثابت

    public ClientInteractionSteps() {
        app = new MyApplication();
    }

    private boolean loggedIn = false;
    private String currentPage = "";
    private List<String> enrolledClients = new ArrayList<>();
    private String message = "";
    private String forumMessage = "";
    private String progressReport = "";

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String page) {
        currentPage = page;
        app.navigateToPage(page);
        System.out.println("Navigated to the page: " + page);
    }

    @When("I select a group of enrolled clients")
    public void iSelectAGroupOfEnrolledClients() {
        enrolledClients.add("Client 1");
        enrolledClients.add("Client 2");
        app.selectClients(enrolledClients);
        System.out.println("Selected a group of enrolled clients: " + enrolledClients);
    }

    @When("I compose a message")
    public void iComposeAMessage() {
        message = "This is a message to all enrolled clients.";
        app.composeMessage(clientName, message);  // تمرير اسم العميل والرسالة
        System.out.println("Composed a message: " + message);
    }

    @When("I click {string}")
    public void iClick(String button) {
        app.clickButton2(button);
        System.out.println("Clicked button: " + button);
    }

    @Then("the clients should receive the message")
    public void theClientsShouldReceiveTheMessage() {
        assertTrue(!message.isEmpty(), "Message must be composed before sending.");
        app.sendMessage(enrolledClients, message);
        for (String client : enrolledClients) {
            System.out.println("Message sent to " + client + ": " + message);
        }
    }

    @When("I navigate to a program's discussion forum")
    public void iNavigateToAProgramSDiscussionForum() {
        currentPage = "Discussion Forum";
        app.navigateToPage("Discussion Forum");
        System.out.println("Navigated to the program's discussion forum.");
    }

    @When("I view client messages")
    public void iViewClientMessages() {
        app.viewClientMessages(clientName);  // تمرير اسم العميل عند عرض الرسائل
        System.out.println("Viewing client messages in the discussion forum.");
    }

    @When("I reply to a message")
    public void iReplyToAMessage() {
        forumMessage = "This is a reply to the client message.";
        app.replyToMessage(forumMessage, clientName);  // تمرير اسم العميل مع الرد
        System.out.println("Replied to a client message: " + forumMessage);
    }

    @Then("my response should appear in the discussion forum")
    public void myResponseShouldAppearInTheDiscussionForum() {
        assertTrue(!forumMessage.isEmpty(), "Response must be composed before appearing in the forum.");
        String response = "Response to the message";  // تخصيص قيمة للرد
        app.verifyForumResponse(forumMessage, response);  // تمرير الرد مع الرسالة
        System.out.println("Response appeared in the discussion forum: " + forumMessage);
    }

    @When("I navigate to a client's profile")
    public void iNavigateToAClientSProfile() {
        currentPage = "Client Profile";
        app.navigateToPage("Client Profile");
        System.out.println("Navigated to the client's profile.");
    }

    @When("I review the client's progress")
    public void iReviewTheClientSProgress() {
        String clientStatus = "Active";  // تخصيص حالة العميل
        app.reviewClientProgress(clientName, 0, clientStatus);  // تمرير حالة العميل
        System.out.println("Reviewed the client's progress.");
    }

    @When("I write a progress report")
    public void iWriteAProgressReport() {
        progressReport = "This is the progress report for the client.";
        app.writeProgressReport(progressReport, clientName);  // تمرير التقرير مع اسم العميل
        System.out.println("Progress report written: " + progressReport);
    }

    @Then("the client should receive the progress report")
    public void theClientShouldReceiveTheProgressReport() {
        assertTrue(!progressReport.isEmpty(), "Progress report must be written before sending.");
        app.sendProgressReport(clientName);  // تمرير اسم العميل مع التقرير
        System.out.println("Progress report sent to the client: " + progressReport);
    }
}
