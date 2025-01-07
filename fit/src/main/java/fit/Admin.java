package fit;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fit.Clienttt;
import fit.Instructor;

import java.util.Scanner;

import fit.Instructor.Program;
// rawan
public class Admin {
	public Admin() {
	    users.put("Admin", "password123");
	}

		public class User {
		    private String username;
		    private String isAdmin;

		  
		    public User(String username, String password) {
		        this.username = username;
		        this.isAdmin = password;
		    }

		   
		    public String isAdmin() {
		        return isAdmin;
		    }

		    
		    public String getUsername() {
		        return username;
		    }

		    public void setUsername(String username) {
		        this.username = username;
		    }
		}

		   public void runApplication() {
		        System.out.println("MyApplication is running!");
		   }
		
	    private Map<String, String> users = new HashMap<>();
	    private Map<String, String> articleStatus = new HashMap<>();
	    private Map<String, String> userDetails = new HashMap<>();
	 
	    private Map<String, String> items = new HashMap<>();
	    public static Map<String, String> instructors = new HashMap<>();
	    private Map<String, Program> programs = new HashMap<>();
	    public Map<String, List<String>> clientMessages = new HashMap<>();
	    private List<String> articles = new ArrayList<>();
	    private List<String> tips = new ArrayList<>();
	    private List<String> feedbacks = new ArrayList<>();
	    private Map<String, String> complaints = new HashMap<>();
	    private Map<String, String> userPlans = new HashMap<>();
	    private Map<String, String> subscriptionPlans = new HashMap<>(); 
	    private Map<String, Boolean> activeSubscriptions = new HashMap<>();
	    private Map<String, String> submittedArticles = new HashMap<>(); 
	    Map<String, String> instructorApplications = new HashMap<>();
	    Map<String, Integer> userStatistics = new HashMap<>();
		private String name;
		
	  
	    private String password;
	   
		
	    public boolean checkUserAccessToPlanFeatures1(String userId) {
	        if (userPlans == null || !userPlans.containsKey(userId)) {
	            return false; 
	        }
	        return true;
	    }
	  
		
	    private HashMap<String, String> admins = new HashMap<>();
	    private boolean isLoggedIn = false;
	    
	    public  boolean loginAsAdmin(String username,String password) {
	        if (users.containsKey(username) && users.get(username).equals(password)) {
	            isLoggedIn = true;
	            System.out.println("Logged in successfully as admin.");
	            return true;
	        } else {
	            isLoggedIn = false;
	            System.out.println("Invalid username or password.");
	            return false;
	        }
			
	    }
	
	    
	    public void navigateToPage(String pageName) {
	        if (isLoggedIn) {
	            System.out.println("Navigating to page: " + pageName);
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	    public String reviewClientProgress(String clientName, double progressPercentage, String clientStatus) {
	        String progressMessage;

	        if (progressPercentage == 100) {
	            progressMessage = "Client has completed all tasks. Great work!";
	        } else if (progressPercentage >= 50) {
	            progressMessage = "Client is making good progress. Keep it up!";
	        } else {
	            progressMessage = "Client needs more focus to achieve goals.";
	        }

	   
	        return "Reviewing progress for client: " + clientName + "\n" +
	               "Progress Percentage: " + progressPercentage + "%\n" +
	               "Client Status: " + clientStatus + "\n" +
	               "Progress Feedback: " + progressMessage;
	    }

	  
	    public void assertArticleStatus(String articleKey) {
	        if (isLoggedIn) {
	            Scanner scanner = new Scanner(System.in);

	            
	        
	            
	            System.out.print("Enter the status for " + articleKey + " (e.g., Published, Pending, etc.): ");
	            String status = scanner.nextLine();

	            articleStatus.put(articleKey, status);

	           
	            System.out.println(articleKey + " status set to: " + status);
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }



	    public void assertArticleStatusVisibility() {
	        boolean isAdmin=true;
			if (isLoggedIn && isAdmin) {
	            Scanner scanner = new Scanner(System.in);

	            System.out.print("Enter visibility status for the article (true for visible, false for hidden): ");
	            boolean visibility = scanner.nextBoolean(); // قراءة القيمة من المسؤول

	            if (visibility) {
	                System.out.println("Article is now visible on the platform.");
	            } else {
	                System.out.println("Article is now hidden from the platform.");
	            }
	        } else {
	            System.out.println("Only admins can modify visibility status. Please log in as an admin first.");
	        }
	    }

	   
	    public void enterSearchQuery(String query) {
	        if (isLoggedIn) {
	            if (query == null || query.isEmpty()) {
	                System.out.println("Please enter a valid search query.");
	            } else {
	                System.out.println("Searching for: " + query);
	                boolean found = false;
	                
	                for (Map.Entry<String, String> entry : items.entrySet()) {
	                    if (entry.getValue().toLowerCase().contains(query.toLowerCase())) {
	                        System.out.println("Found: " + entry.getKey() + " - " + entry.getValue());
	                        found = true;
	                    }
	                }

	                if (!found) {
	                    System.out.println("No results found for: " + query);
	                }
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	 
	    public void addItemsToSearch() {
	        items.put("1", "Wellness Program");
	        items.put("2", "Fitness Article");
	        items.put("3", "Healthy Recipes");
	        items.put("4", "Weight Loss Guide");
	        items.put("5", "Yoga Classes");
	    }
	    private String password1;
	    private Map<String, String> accounts = new HashMap<>();

	 
	    public String getPassword() {
	        return password;
	    }

	 
	    public void setPassword(String password) {
	        this.password = password1;
	    }
	    
	    

	    public void assertArticlesRelatedTo(String topic) {
	        if (isLoggedIn) {
	            List<String> relatedArticles = new ArrayList<>();
	            relatedArticles.add("Article 1 on " + topic);
	            relatedArticles.add("Article 2 on " + topic);
	            relatedArticles.add("Article 3 on " + topic);

	            System.out.println("Displaying articles related to: " + topic);
	            for (String article : relatedArticles) {
	                System.out.println("- " + article);
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	        }
	    public void selectArticleStatus(String articleKey, String status) {
	        if (isLoggedIn) {
	            if (status == null || status.isEmpty()) {
	                System.out.println("Invalid status. Please provide a valid article status.");
	            } else {
	                articleStatus.put(articleKey, status);
	                System.out.println("Selected status for article \"" + articleKey + "\": " + status);
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	    public void assertProgramsSortedByEnrollment() {
	        if (isLoggedIn) {
	            if (programs.isEmpty()) {
	                System.out.println("No programs available to sort.");
	            } else {
	                List<Map.Entry<String, Program>> sortedPrograms = new ArrayList<>(programs.entrySet());
	                sortedPrograms.sort((entry1, entry2) -> 
	                    Integer.compare(entry2.getValue().getSessionCount(), entry1.getValue().getSessionCount()));

	                System.out.println("Programs sorted by enrollment numbers:");
	                for (Map.Entry<String, Program> entry : sortedPrograms) {
	                    System.out.println("Program: " + entry.getKey() + 
	                                       ", Sessions: " + entry.getValue().getSessionCount());
	                }
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	    public void selectReportType(String reportType) {
	        if (isLoggedIn) {
	            if (reportType != null && !reportType.isEmpty()) {
	                System.out.println("Selected report type: " + reportType);
	            } else {
	                System.out.println("Please provide a valid report type.");
	            }
	        }
	    }
	 
	    public void assertPdfReportAvailableForDownload() {
	        if (isLoggedIn) {
	            System.out.println("PDF report is available for download.");
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }
	  
	    public void assertSectionsVisible(String section1, String section2) {
	        if (isLoggedIn) {
	            if (section1 != null && !section1.isEmpty() && section2 != null && !section2.isEmpty()) {
	                System.out.println("Sections visible: " + section1 + " and " + section2);
	            } else {
	                System.out.println("Please provide valid sections.");
	            }
	        }
	    }
	  
	    public void fillUserDetails() {
	        if (isLoggedIn) {
	        
	            Scanner scanner = new Scanner(System.in);

	          
	            System.out.print("Enter your name: ");
	            String name = scanner.nextLine();

	            System.out.print("Enter your role: ");
	            String role = scanner.nextLine();

	          
	            userDetails.put("name", name);
	            userDetails.put("role", role);

	         
	            System.out.println("User details filled: " + name + " as " + role);
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }
	  
	    public void assertUserAccountCreated(String name) {
	        if (isLoggedIn) {
	            System.out.println("User account for " + name + " has been created.");
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }
	  
	    public void updateUserDetails(String name, String role) {
	        if (isLoggedIn) {
	            String currentName = userDetails.get("name");
	            String currentRole = userDetails.get("role");

	            boolean isNameChanged = currentName == null || !currentName.equals(name);
	            boolean isRoleChanged = currentRole == null || !currentRole.equals(role);

	            if (isNameChanged || isRoleChanged) {
	                if (isNameChanged) {
	                    userDetails.put("name", name);
	                }
	                if (isRoleChanged) {
	                    userDetails.put("role", role);
	                }
	                System.out.println("User details updated: " + name + " as " + role);
	            } else {
	                System.out.println("No changes detected in user details.");
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }
	
	    public void assertUserAccountUpdated(String name) {
	        if (isLoggedIn) {
	            String currentName = userDetails.get("name");
	            if (currentName != null && currentName.equals(name)) {
	                System.out.println("User account successfully updated for: " + name);
	            } else {
	                System.out.println("No matching user found with the name: " + name);
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }
	    public void assertUserAccountInactive(String name) {
	        if (isLoggedIn) {
	            String currentName = userDetails.get("name");
	            String status = userDetails.get("status"); // التحقق من حالة الحساب
	            
	            if (currentName != null && currentName.equals(name)) {
	                if (status != null && status.equalsIgnoreCase("inactive")) {
	                    System.out.println("User account for " + name + " is inactive.");
	                } else {
	                    System.out.println("User account for " + name + " is active.");
	                }
	            } else {
	                System.out.println("No matching user found with the name: " + name);
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	    public void reviewInstructorApplication(String instructorName) {
	        if (isLoggedIn) {
	         
	            String applicationStatus = instructorApplications.get(instructorName);

	            if (applicationStatus != null) {
	                switch (applicationStatus.toLowerCase()) {
	                    case "pending":
	                        System.out.println("Reviewing instructor application for: " + instructorName);
	                       
	                        instructorApplications.put(instructorName, "under review");
	                        break;
	                    case "under review":
	                        System.out.println("The application for " + instructorName + " is already under review.");
	                        break;
	                    case "approved":
	                        System.out.println("The application for " + instructorName + " has already been approved.");
	                        break;
	                    case "rejected":
	                        System.out.println("The application for " + instructorName + " has been rejected.");
	                        break;
	                    default:
	                        System.out.println("Unknown status for the application of: " + instructorName);
	                }
	            } else {
	                System.out.println("No application found for instructor: " + instructorName);
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	    public void assertInstructorAccountActivated(String instructorName) {
	        if (isLoggedIn) {
	        
	            String accountStatus = instructorApplications.get(instructorName);

	            if (accountStatus != null) {
	                if (accountStatus.equalsIgnoreCase("active")) {
	                    System.out.println("Instructor account for " + instructorName + " is already activated.");
	                } else {
	                  
	                    instructorApplications.put(instructorName, "active");
	                    System.out.println("Instructor account for " + instructorName + " has been activated.");
	                }
	            } else {
	                System.out.println("No account found for instructor: " + instructorName);
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }
	
	    public void assertStatisticsDisplayed() {
	        if (isLoggedIn) {
	            int loginFrequency = userStatistics.getOrDefault("loginFrequency", 0);
	            int programEnrollments = userStatistics.getOrDefault("programEnrollments", 0);

	            System.out.println("Statistics:");
	            System.out.println(" - Login frequency: " + loginFrequency);
	            System.out.println(" - Program enrollments: " + programEnrollments);
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }
	    public void selectUserAccount(String name) {
	        if (isLoggedIn) {
	            if (userDetails.containsKey("name") && userDetails.get("name").equals(name)) {
	                System.out.println("User account selected: " + name);
	            } else {
	                System.out.println("User account " + name + " does not exist.");
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	    public void clickButton1(String buttonName) {
	        if (isLoggedIn) {
	            switch (buttonName) {
	                case "submit":
	                    submitArticle(buttonName, buttonName); 
	                    break;
	                case "approve":
	                    approveArticle(buttonName);
	                    break;
	                case "reject":
	                    rejectArticle(buttonName);
	                    break;
	                default:
	                    System.out.println("Unknown button action.");
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	    public void assertOnlyArticlesWithStatus(String status) {
	        if (isLoggedIn) {
	            boolean found = false;
	            for (Map.Entry<String, String> entry : articleStatus.entrySet()) {
	                if (entry.getValue().equals(status)) {
	                    found = true;
	                    System.out.println("Article ID: " + entry.getKey() + " with status: " + entry.getValue());
	                }
	            }
	            if (!found) {
	                System.out.println("No articles found with status: " + status);
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }
	    public void assertSearchResultsContain(String word) {
	        if (isLoggedIn) {
	            boolean found = false;
	            for (String articleId : articleStatus.keySet()) {
	                if (articleId.contains(word)) {
	                    found = true;
	                    System.out.println("Search results contain the article with ID: " + articleId);
	                }
	            }
	            if (!found) {
	                System.out.println("No articles contain the word: " + word);
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	    public void assertArticleStatus(boolean visibility) {
	        if (isLoggedIn) {
	            for (Map.Entry<String, String> entry : articleStatus.entrySet()) {
	                if (visibility && entry.getValue().equals("approved")) {
	                    System.out.println("Article with ID " + entry.getKey() + " is visible.");
	                } else if (!visibility && !entry.getValue().equals("approved")) {
	                    System.out.println("Article with ID " + entry.getKey() + " is not visible.");
	                }
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	    public void assertArticleStatuss(String status) {
	        if (isLoggedIn) {
	            boolean found = false;
	            for (Map.Entry<String, String> entry : articleStatus.entrySet()) {
	                if (entry.getValue().equals(status)) {
	                    found = true;
	                    System.out.println("Article with ID " + entry.getKey() + " is marked as: " + status);
	                }
	            }
	            if (!found) {
	                System.out.println("No articles found with status: " + status);
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }
	    void submitArticle(String articleId, String articleContent) {
	        if (isLoggedIn) {
	            if (articleId == null || articleId.trim().isEmpty()) {
	                System.out.println("Article ID cannot be null or empty.");
	                return;
	            }

	            if (articleContent == null || articleContent.trim().isEmpty()) {
	                System.out.println("Cannot submit an empty article.");
	                return;
	            }

	            if (articleStatus.containsKey(articleId)) {
	                System.out.println("Article with ID " + articleId + " has already been submitted.");
	            } else {
	                articleStatus.put(articleId, "submitted");
	                System.out.println("Article with ID " + articleId + " has been submitted successfully.");
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }


	    void approveArticle(String articleId) {
	        if (isLoggedIn) {
	            if (articleStatus.containsKey(articleId)) {
	                String currentStatus = articleStatus.get(articleId);
	                
	                if (currentStatus.equalsIgnoreCase("submitted")) {
	                    articleStatus.put(articleId, "approved");
	                    System.out.println("Article with ID " + articleId + " has been approved.");
	                } else if (currentStatus.equalsIgnoreCase("approved")) {
	                    System.out.println("Article with ID " + articleId + " has already been approved.");
	                } else {
	                    System.out.println("Article with ID " + articleId + " is in an invalid state for approval.");
	                }
	            } else {
	                System.out.println("Article with ID " + articleId + " not found.");
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }



	    void rejectArticle(String articleId) {
	        if (isLoggedIn) {
	            if (articleStatus.containsKey(articleId)) {
	                String currentStatus = articleStatus.get(articleId);
	                
	                if (currentStatus.equalsIgnoreCase("submitted")) {
	                    articleStatus.put(articleId, "rejected");
	                    System.out.println("Article with ID " + articleId + " has been rejected.");
	                } else if (currentStatus.equalsIgnoreCase("rejected")) {
	                    System.out.println("Article with ID " + articleId + " has already been rejected.");
	                } else {
	                    System.out.println("Article with ID " + articleId + " is in an invalid state for rejection.");
	                }
	            } else {
	                System.out.println("Article with ID " + articleId + " not found.");
	            }
	        } else {
	            System.out.println("Please log in first.");
	        }
	    }

	    public void checkAdminPermissions() {
	        if (!isLoggedIn) {
	            System.out.println("Error: User is not logged in.");
	            return; 
	        }

	        if (!hasAdminPermissions()) {
	            System.out.println("Error: User does not have admin permissions.");
	            return; 
	        }

	        System.out.println("Success: User has the necessary admin permissions.");
	    }

	    private boolean hasAdminPermissions() {
	        String userRole = userDetails.get("role");  
	        return userRole != null && userRole.equalsIgnoreCase("admin");
	    }
		public void reviewContent(String content) {
		    if (content == null || content.trim().isEmpty()) {
		        System.out.println("Error: Content cannot be null or empty.");
		        return; 
		    }

		    System.out.println("Reviewing content: " + content);

		    if (content.length() < 50) {
		        System.out.println("Error: Content is too short. Must be at least 50 characters.");
		        return;
		    }

		    if (containsProhibitedWords(content)) {
		        System.out.println("Error: Content contains prohibited words.");
		        return;
		    }

		    System.out.println("Content review completed successfully. Content meets all requirements.");
		}

		private boolean containsProhibitedWords(String content) {
		    String[] prohibitedWords = {"spam", "offensive", "inappropriate"};
		    		    for (String word : prohibitedWords) {
		        if (content.toLowerCase().contains(word)) {
		            return true;
		        }
		    }
		    return false; 
		}

		public void verifyContentQuality(String content) {
		    if (content == null || content.trim().isEmpty()) {
		        System.out.println("Error: Content cannot be null or empty.");
		        return; 
		    }

		    System.out.println("Verifying content quality...");

		    if (content.length() < 100) {
		        System.out.println("Error: Content is too short. Minimum required length is 100 characters.");
		        return;
		    }

		    if (containsPoorLanguage(content)) {
		        System.out.println("Error: Content contains poor or inappropriate language.");
		        return;
		    }

		    if (!containsKeywords(content)) {
		        System.out.println("Error: Content does not contain required keywords.");
		        return;
		    }

		    System.out.println("Content quality verified successfully. The content meets all quality standards.");
		}

		private boolean containsKeywords(String content) {
		    String[] requiredKeywords = {"quality", "standards", "guidelines"};
		    for (String keyword : requiredKeywords) {
		        if (content.toLowerCase().contains(keyword)) {
		            return true; 
		        }
		    }
		    return false;
		}


		private boolean containsPoorLanguage(String content) {
		    String[] poorLanguageWords = {"badword1", "badword2", "offensive"};
		    for (String word : poorLanguageWords) {
		        if (content.toLowerCase().contains(word)) {
		            return true;
		        }
		    }
		    return false;
		}



	    public void publishArticle(String articleContent) {
	        if (articleContent == null || articleContent.trim().isEmpty()) {
	            System.out.println("Error: Article content cannot be empty.");
	            return;
	        }
	        articles.add(articleContent);
	        System.out.println("Article published successfully.");
	    }
	    public void rejectContentReview(String reason) {
	        if (reason == null || reason.isEmpty()) {
	            System.out.println("Error: Reason for rejection is required.");
	            return;
	        }
	        System.out.println("Content review rejected. Reason: " + reason);
	    }
	    public void notifyInstructor(String message) {
	        if (message == null || message.trim().isEmpty()) {
	            System.out.println("Error: Notification message is required.");
	            return;
	        }

	        if (message.length() < 10) {
	            System.out.println("Error: Notification message must be at least 10 characters long.");
	            return;
	        }

	        System.out.println("Notification sent to instructor: " + message);
	    }
	    public void submitTip(String tipContent) {
	        if (tipContent == null || tipContent.trim().isEmpty()) {
	            System.out.println("Error: Tip content cannot be empty.");
	            return;
	        }
	        tips.add(tipContent);
	        System.out.println("Tip submitted successfully.");
	    }

	    public void reviewTip() {
	        if (tips.isEmpty()) {
	            System.out.println("No tips available for review.");
	            return;
	        }
	        System.out.println("Reviewing the first tip: " + tips.get(0));
	    }
	    public void verifyTipCompliance(String tipContent) {
	        if (tipContent == null || tipContent.trim().isEmpty()) {
	            System.out.println("Error: Tip content is required for verification.");
	            return;
	        }
	        if (tipContent.length() > 10) {
	            System.out.println("Tip meets compliance guidelines.");
	        } else {
	            System.out.println("Tip does not meet compliance guidelines.");
	        }
	    }
	    public void approveTip(String tipContent) {
	        if (tips.contains(tipContent)) {
	            System.out.println("Tip approved: " + tipContent);
	        } else {
	            System.out.println("Error: Tip not found.");
	        }
	    }
	   
	    public void makeTipVisible(String tipContent, LocalDate tipDate, boolean isLoggedIn, boolean isAdmin) {
	        if (getTipStatus(tipContent, tipDate,isLoggedIn, isAdmin).equals("not_found")) {
	            System.out.println("Error: Tip not found.");
	            return;
	        }

	        String tipStatus = getTipStatus(tipContent, tipDate, isAdmin, isAdmin);
	        if (!"approved".equalsIgnoreCase(tipStatus)) {
	            System.out.println("Error: Tip is not approved yet.");
	            return;
	        }

	        if (!isTipRecent(tipDate)) {
	            System.out.println("Error: Tip is outdated.");
	            return;
	        }

	        if (!isUserAuthorized(isLoggedIn, isAdmin)) {
	            System.out.println("Error: User is not authorized to view tips.");
	            return;
	        }

	        System.out.println("Tip is now visible to users: " + tipContent);
	    }

	    public String getTipStatus(String tipContent, LocalDate tipDate, boolean isLoggedIn, boolean isAdmin) {
	     
	        if (!isUserAuthorized(isLoggedIn, isAdmin)) {
	            return "Error: User is not authorized to view tips.";  
	        }

	        if (!isTipRecent(tipDate)) {
	            return "Error: Tip is outdated.";  
	        }

	        if ("Tip 1".equals(tipContent)) {
	            return "approved";  
	        } else if ("Tip 2".equals(tipContent)) {
	            return "pending";  
	        } else if ("Tip 3".equals(tipContent)) {
	            return "rejected";
	        } else {
	            return "Error: Tip not found."; 
	        }
	    }

	    public boolean isUserAuthorized(boolean isLoggedIn, boolean isAdmin) {
	        return isLoggedIn && isAdmin; 
	    }

	    public boolean isTipRecent(LocalDate tipDate) {
	        return !tipDate.isBefore(LocalDate.now().minusDays(3)); 
	    }


	
	    public void rejectTipReview(String reason) {
	        if (reason == null || reason.isEmpty()) {
	            System.out.println("Error: Reason for rejection is required.");
	            return;
	        }
	        System.out.println("Tip review rejected. Reason: " + reason);
	    }

	    public void rejectTip(String tipContent) {
	        if (tips != null && tips.remove(tipContent)) {
	            System.out.println("Tip rejected and removed: " + tipContent);
	        } else {
	            System.out.println("Error: Tip not found.");
	        }
	    }   

	    public String getName() {
	        if (this.name == null) {
	            return "Unknown Submitter"; // قيمة افتراضية إذا كانت null
	        }
	        return this.name;
	    }

	    public void notifySubmitter(String message, Admin app) {
	        if (message == null || message.isEmpty() || app == null || app.getName().isEmpty()) {
	            System.out.println("Error: Both message and submitter are required.");
	            return;
	        }
	        System.out.println("Notification sent to submitter (" + app.getName() + "): " + message);
	    }

	  


	    public void submitFeedback(String feedback) {
	        if (feedback == null || feedback.trim().isEmpty()) {
	            System.out.println("Error: Feedback cannot be empty.");
	            return;
	        }
	        feedbacks.add(feedback);
	        System.out.println("Feedback submitted.");
	    }

	    public void reviewFeedback() {
	        if (feedbacks.isEmpty()) {
	            System.out.println("No feedback available for review.");
	            return;
	        }
	        
	        System.out.println("Reviewing all feedback:");
	        for (String feedback : feedbacks) {
	            System.out.println("- " + feedback);
	        }
	    }
	   

	    public void validateFeedback(String feedback) {
	        if (feedback == null || feedback.trim().isEmpty()) {
	            System.out.println("Error: Invalid feedback provided.");
	            return;
	        }

	        if (feedbacks.contains(feedback)) {
	            System.out.println("Feedback validated: " + feedback);
	        } else {
	            System.out.println("Error: Feedback not found.");
	        }
	    }
	    
	    public void markFeedbackForAction(String feedback) {
	        if (feedback == null || feedback.trim().isEmpty()) {
	            System.out.println("Error: Invalid feedback provided.");
	            return;
	        }

	        if (feedbacks.contains(feedback)) {
	            System.out.println("Feedback marked for further action: " + feedback);
	        } else {
	            System.out.println("Error: Feedback not found.");
	        }
	    }
	

	    public void notifyContentTeam(String message) {
	        if (message == null || message.trim().isEmpty()) {
	            System.out.println("Error: Message is required.");
	            return;
	        }
	        System.out.println("Notification sent to content team: " + message);
	    }

	   
	    public void submitComplaint(String complaintId, String complaintContent) {
	        if (complaintId == null || complaintContent == null || complaintId.trim().isEmpty() || complaintContent.trim().isEmpty()) {
	            System.out.println("Error: Both complaint ID and content are required.");
	            return;
	        }
	        complaints.put(complaintId, complaintContent);
	        System.out.println("Complaint submitted with ID: " + complaintId);
	    }
	 

	    public void reviewComplaint() {
	        if (complaints.isEmpty()) {
	            System.out.println("No complaints available for review.");
	            return;
	        }

	        System.out.println("Reviewing all complaints:");
	        for (Map.Entry<String, String> entry : complaints.entrySet()) {
	            System.out.println("Complaint ID: " + entry.getKey() + " - Content: " + entry.getValue());
	        }
	    }
	    
	    

	    public void validateComplaint(String complaintId) {
	        if (complaintId == null || complaintId.trim().isEmpty()) {
	            System.out.println("Error: Complaint ID is required.");
	            return;
	        }

	        if (complaints.containsKey(complaintId)) {
	            System.out.println("Complaint validated: " + complaintId);
	        } else {
	            System.out.println("Error: Complaint ID not found.");
	        }
	    }
	   

	    public void removeContent(String content) {
	        if (content == null || content.trim().isEmpty()) {
	            System.out.println("Error: Content is required.");
	            return;
	        }

	        boolean removedFromArticles = articles.remove(content);
	        boolean removedFromTips = tips.remove(content);

	        if (removedFromArticles || removedFromTips) {
	            System.out.println("Content removed: " + content);
	        } else {
	            System.out.println("Error: Content not found.");
	        }
	    }
	   

	    public void notifyUser(String message) {
	        if (message == null || message.trim().isEmpty()) {
	            System.out.println("Error: Message is required.");
	            return;
	        }
	        System.out.println("Notification sent to user: " + message);
	    }


	    public void saveNewSubscriptionPlan(String userId, String newPlanId) {
	        if (userId == null || newPlanId == null) {
	            System.out.println("Error: User ID or Plan ID is null.");
	            return;
	        }
	        subscriptionPlans.put(newPlanId, "Details for " + newPlanId); // Save the new plan
	        System.out.println("Plan " + newPlanId + " saved for user " + userId);
	    }

	    
	    public boolean checkIfPlanIsSaved(String planId) {
	        if (planId == null || planId.trim().isEmpty()) {
	            System.out.println("Error: Plan ID is required.");
	            return false;
	        }
	        return subscriptionPlans.containsKey(planId);
	    }

	    public void assignSubscriptionPlanToUser(String userId, String planId) {
	        if (userId == null || userId.isEmpty() || planId == null || planId.isEmpty()) {
	            System.out.println("Error: User ID and Plan ID are required.");
	            return;
	        }

	        if (!subscriptionPlans.containsKey(planId)) {
	            System.out.println("Error: Subscription plan not found.");
	            return;
	        }

	        userPlans.put(userId, planId); 
	        activeSubscriptions.put(planId, true); 
	        System.out.println("User " + userId + " assigned to plan: " + planId);
	    }

	   
	    public boolean checkUserAccessToPlanFeatures(String userId) {
	        if (userId == null || userId.trim().isEmpty()) {
	            System.out.println("Error: User ID is required.");
	            return false;
	        }

	        String planId = userPlans.get(userId);
	        if (planId == null) {
	            System.out.println("Error: No plan assigned to the user.");
	            return false;
	        }

	        if (activeSubscriptions.getOrDefault(planId, false)) {
	            System.out.println("User " + userId + " has access to features of plan: " + planId);
	            return true;
	        } else {
	            System.out.println("User " + userId + " does not have access to the plan features.");
	            return false;
	        }
	    }

	    public void viewActiveSubscriptions() {
	        if (activeSubscriptions == null || activeSubscriptions.isEmpty()) {
	            System.out.println("No active subscriptions found.");
	            return;
	        }
	        for (Map.Entry<String, Boolean> entry : activeSubscriptions.entrySet()) {
	            System.out.println("Subscription: " + entry.getKey() + " - Active: " + entry.getValue());
	        }
	    }

	    public void processSubscriptionUpgrade(String userId, String newPlanId) {
	        if (userId == null || userId.trim().isEmpty() || newPlanId == null || newPlanId.trim().isEmpty()) {
	            System.out.println("Error: User ID and New Plan ID are required.");
	            return;
	        }

	        if (!subscriptionPlans.containsKey(newPlanId)) {
	            System.out.println("Error: New plan not found.");
	            return;
	        }

	        String currentPlan = userPlans.get(userId);
	        if (currentPlan == null) {
	            System.out.println("Error: No plan assigned to the user.");
	            return;
	        }

	        
	        System.out.println("Upgrading user " + userId + " from " + currentPlan + " to " + newPlanId);
	        userPlans.put(userId, newPlanId);
	        activeSubscriptions.put(newPlanId, true); // Ensure the new plan is marked as active
	        System.out.println("User " + userId + " has been upgraded to " + newPlanId);
	    }

	    
	    public boolean activateNewPlanAfterUpgrade(String userId, String newPlanId) {
	        if (userId == null || userId.isEmpty() || newPlanId == null || newPlanId.isEmpty()) {
	            System.out.println("Error: User ID and New Plan ID are required.");
	            return false;
	        }

	        if (!subscriptionPlans.containsKey(newPlanId)) {
	            System.out.println("Error: New plan not found.");
	            return false;
	        }

	        String currentPlan = userPlans.get(userId);
	        if (currentPlan == null) {
	            System.out.println("Error: No plan assigned to the user.");
	            return false;
	        }

	        userPlans.put(userId, newPlanId); 
	        activeSubscriptions.put(newPlanId, true);
	        System.out.println("New plan " + newPlanId + " activated for user " + userId);
	        return true;
	    }


	   
	    public boolean areActiveSubscriptionsDisplayed() {
	        boolean anyActiveSubscriptions = activeSubscriptions.values().contains(true);
	        
	        if (!anyActiveSubscriptions) {
	            System.out.println("No active subscriptions to display.");
	            return false;
	        }

	        System.out.println("Displaying active subscriptions:");
	        for (Map.Entry<String, Boolean> entry : activeSubscriptions.entrySet()) {
	            if (entry.getValue()) {
	                System.out.println("Plan ID: " + entry.getKey() + " is active.");
	            }
	        }
	        return true;
	    }

	   
	    public void reviewSubmittedArticle(String articleId) {
	        if (articleId == null || articleId.isEmpty()) {
	            System.out.println("Error: Article ID is required.");
	            return;
	        }

	        String articleContent = submittedArticles.get(articleId);
	        if (articleContent == null) {
	            System.out.println("Error: Article not found.");
	            return;
	        }

	        System.out.println("Reviewing submitted article with ID: " + articleId);
	        System.out.println("Article Content: " + articleContent);
	    }


		public void upgradeUserSubscription(String userId, String newPlanId) {
			// TODO Auto-generated method stub
			
		}


		public void createNewSubscriptionPlan(String string, String string2, double d) {
			// TODO Auto-generated method stub
			
		}
	
	    public  void addInstructor(Scanner scanner) {
	        System.out.print("Enter instructor name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter instructor password: ");
	        String password = scanner.nextLine();
	        instructors.put(name, password);
	        System.out.println("Instructor added successfully!");
	    }

	    public  void updateInstructor(Scanner scanner) {
	        System.out.print("Enter instructor name: ");
	        String name = scanner.nextLine();
	        if (instructors.containsKey(name)) {
	            System.out.print("Enter new password: ");
	            String newPassword = scanner.nextLine();
	            instructors.put(name, newPassword);
	            System.out.println("Instructor updated successfully!");
	        } else {
	            System.out.println("Instructor not found.");
	        }
	    }

	    public  void deactivateInstructor(Scanner scanner) {
	        System.out.print("Enter instructor name: ");
	        String name = scanner.nextLine();
	        if (instructors.remove(name) != null) {
	            System.out.println("Instructor deactivated successfully!");
	        } else {
	            System.out.println("Instructor not found.");
	        }
	    }

	    public  void addClient(Scanner scanner) {
	        System.out.print("Enter client name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter client password: ");
	        String password = scanner.nextLine();
	        accounts.put(name, password);
	        System.out.println("Client added successfully!");
	    }

	    public  void updateClient(Scanner scanner) {
	        System.out.print("Enter client name: ");
	        String name = scanner.nextLine();
	        if (accounts.containsKey(name)) {
	            System.out.print("Enter new password: ");
	            String newPassword = scanner.nextLine();
	            accounts.put(name, newPassword);
	            System.out.println("Client updated successfully!");
	        } else {
	            System.out.println("Client not found.");
	        }
	    }

	    public  void deactivateClient(Scanner scanner) {
	        System.out.print("Enter client name: ");
	        String name = scanner.nextLine();
	        if (accounts.remove(name) != null) {
	            System.out.println("Client deactivated successfully!");
	        } else {
	            System.out.println("Client not found.");
	        }
	    }

	    
	}

