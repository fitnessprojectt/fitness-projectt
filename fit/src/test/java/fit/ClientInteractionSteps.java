package fit;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class ClientInteractionSteps {

    Instructor app2;
    private String clientName = "Client 1";  

    public ClientInteractionSteps() {
        app2 = new Instructor();
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
        app2.navigateToPage1();
        System.out.println("Navigated to the page: " + page);
    }
    @When("I select a group of enrolled clients")
    public void iSelectAGroupOfEnrolledClients() {
        enrolledClients.add("Client 1");
        enrolledClients.add("Client 2");
        app2.selectClients(enrolledClients);
        System.out.println("Selected a group of enrolled clients: " + enrolledClients);
    }

    @When("I compose a message")
    public void iComposeAMessage() {
        message = "This is a message to all enrolled clients.";
        app2.composeMessage(clientName, message);  
        System.out.println("Composed a message: " + message);
    }
    @When("I click {string}")
    public void iClick(String button) {
        app2.clickButton2(button);
        System.out.println("Clicked button: " + button);
    }
    @Then("the clients should receive the message")
    public void theClientsShouldReceiveTheMessage() {
        app2.sendMessage(enrolledClients, message);
        for (String client : enrolledClients) {
            System.out.println("Message sent to " + client + ": " + message);
        }
    }
    @When("I navigate to a program's discussion forum")
    public void iNavigateToAProgramSDiscussionForum() {
        currentPage = "Discussion Forum";
        app2.navigateToPage1();
        System.out.println("Navigated to the program's discussion forum.");
    }
    @When("I view client messages")
    public void iViewClientMessages() {
        app2.viewClientMessages(clientName);  
        System.out.println("Viewing client messages in the discussion forum.");
    }
    @When("I reply to a message")
    public void iReplyToAMessage() {
        forumMessage = "This is a reply to the client message.";
        app2.replyToMessage(forumMessage, clientName);  
        System.out.println("Replied to a client message: " + forumMessage);
    }
    @Then("my response should appear in the discussion forum")
    public void myResponseShouldAppearInTheDiscussionForum() {
        String response = "Response to the message";  
        app2.verifyForumResponse(forumMessage, response);  
        System.out.println("Response appeared in the discussion forum: " + forumMessage);
    }
    @When("I navigate to a client's profile")
    public void iNavigateToAClientSProfile() {
        currentPage = "Client Profile";
        app2.navigateToPage1();
        System.out.println("Navigated to the client's profile.");
    }
    @When("I review the client's progress")
    public void iReviewTheClientSProgress() {
        String clientStatus = "Active";  
        app2.reviewClientProgress1(clientName, 0, clientStatus);  
        System.out.println("Reviewed the client's progress.");
    }
    @When("I write a progress report")
    public void iWriteAProgressReport() {
        progressReport = "This is the progress report for the client.";
        app2.writeProgressReport(progressReport, clientName);  
        System.out.println("Progress report written: " + progressReport);
    }
    @Then("the client should receive the progress report")
    public void theClientShouldReceiveTheProgressReport() {
        app2.sendProgressReport(clientName);  
        System.out.println("Progress report sent to the client: " + progressReport);
    }
}
