package fit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
// rawan
class Program {
    private String title;
    private String duration;
    private String difficulty;
    private String goals;
    private List<String> media;
    private double price;
    private List<String> schedule;
	private Object sessionSchedule;
    private List<String> sessionSchedule1; 

    public Program(String title, String duration, String difficulty, String goals, List<String> media, double price, List<String> schedule) {
        this.title = title;
        this.duration = duration;
        this.difficulty = difficulty;
        this.goals = goals;
        this.media = media;
        this.price = price;
        this.schedule = schedule;
        this.sessionSchedule1 = new ArrayList<>(); 
    }
    public void addSessionSchedule(List<String> schedule) {
        if (schedule != null) { 
            sessionSchedule1.addAll(schedule);
        } else {
            System.out.println("Schedule cannot be null.");
        }
    }

    public int getSessionCount() {
        return sessionSchedule1.size(); 
    }
        public void displayDetails() {
            System.out.println("Title: " + title);
            System.out.println("Duration: " + duration);
            System.out.println("Difficulty: " + difficulty);
            System.out.println("Goals: " + goals);
            System.out.println("Media: " + String.join(", ", media));
            System.out.println("Price: " + price);
            System.out.println("Schedule: " + String.join(", ", schedule));
        }
        
        public void setTitle(String title) { this.title = title; }
        public void setDuration(String duration) { this.duration = duration; }
        public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
        public void setGoals(String goals) { this.goals = goals; }
        public void setMedia(List<String> media) { this.media = media; }
        public void setPrice(double price) { this.price = price; }
        public void setSchedule(List<String> schedule) { this.schedule = schedule;}
}
///////////////////////////////

public class MyApplication {
 

	public class User {
	    private String username;
	    private boolean isAdmin;

	    // Constructor to initialize User
	    public User(String username, boolean isAdmin) {
	        this.username = username;
	        this.isAdmin = isAdmin;
	    }

	    // Getter for isAdmin
	    public boolean isAdmin() {
	        return isAdmin;
	    }

	    // Getter for username
	    public String getUsername() {
	        return username;
	    }

	    // Setter for username (if needed)
	    public void setUsername(String username) {
	        this.username = username;
	    }
	}

	   public void runApplication() {
	        System.out.println("MyApplication is running!");
	   }
	private static Map<String, String> accounts = new HashMap<>();  
    private Map<String, String> users = new HashMap<>();
    private Map<String, String> articleStatus = new HashMap<>();
    private Map<String, String> userDetails = new HashMap<>();
 
    private Map<String, String> items = new HashMap<>();
    public static Map<String, String> instructors = new HashMap<>();
    private Map<String, Program> programs = new HashMap<>();
    public Map<String, List<String>> clientMessages = new HashMap<>();
    private Map<String, String> clientProgress = new HashMap<>();
    private Map<String, String> userPlans;
    private Map<String, Boolean> activeSubscriptions;
    private Map<String, String> submittedArticles;


    
    
    private List<String> articles = new ArrayList<>();
    private List<String> tips = new ArrayList<>();
    private List<String> feedbacks = new ArrayList<>();
    private Map<String, String> complaints = new HashMap<>();
    private Map<String, String> subscriptionPlans;
    // تخزين المستخدمين مع خططهم
    
    private boolean isLoggedIn2 = false;
    private Program currentProgram;
	
    private boolean isLoggedIn3;
   
 // تعريف الماب لتخزين حالة الطلبات
    Map<String, String> instructorApplications = new HashMap<>();
    Map<String, Integer> userStatistics = new HashMap<>();
	private String name;
	private ClientProfile clientProfile;
    private boolean profileCreated;
    private boolean dietaryPreferencesUpdated;
    private String errorMessage = "";
    private String profileCreationConfirmation = "";
    private String profileUpdateConfirmation = "";
    private Scanner scanner;
    private String username;
    private String password;
    @SuppressWarnings("serial")
	private List<String> allPrograms = new ArrayList<String>() {{
        add("Beginner Weight Loss Program");
        add("Intermediate Weight Loss Program");
        add("Advanced Weight Loss Program");
        
        add("Beginner Flexibility Program");
        add("Intermediate Flexibility Program");
        add("Advanced Flexibility Program");
        
        add("Beginner Muscle Building Program");
        add("Intermediate Muscle Building Program");
        add("Advanced Muscle Building Program");
        
        add("Beginner Yoga Program");
        add("Intermediate Yoga Program");
        add("Advanced Yoga Program");
        
        add("Beginner Strength Training");
        add("Intermediate Strength Training");
        add("Advanced Strength Training");
        
        add("Weight Loss Bootcamp");
        add("Muscle Building Mastery");
        add("Intermediate Muscle Building Mastery");
        add("7-Day Weight Loss Challenge");
    }};
    
    @SuppressWarnings("serial")
	private List<String> milestones = new ArrayList<String>(){{
    	add("Lost 2 kg");
        add("Reduced BMI by 1 point");
        add("Attended 10 sessions");
    }};
    
    private List<String> achievements = new ArrayList<String>(){{
    	add("First Workout Badge");
        add("10 Days Streak Badge");
        add("Marathon Completion Badge");
    }};
    
    private List<String> attendanceHistory = new ArrayList<String>(){{
    	add("01/01/2025: Attended Yoga Session");
        add("05/01/2025: Attended Cardio Session");
        add("10/01/2025: Attended Weightlifting Session");
    }};
    
    private List<String> badges = new ArrayList<String>(){{
    	add("Beginner Badge");
        add("Consistency Badge");
        add("Motivation Star");
    }};
 
    private Client currentClient;  
    public MyApplication(Client client) {
        this.currentClient = client;
    }
    //////////////////////////////////////

	private LocalDateTime clientReports;
    /////////////////////
    private HashMap<String, String> admins = new HashMap<>();
	private List<String> schedule;
	private double price;
	private List<String> media;
	private String goals;
	private String difficulty;
	private String duration;
	private String title;
	private Object programName;
    private boolean isLoggedIn = false;
    private Map<String, String> clientReports1;
    private Map<String, String> clients = new HashMap<>();

    private Map<String, List<String>> clientAttendedSessions = new HashMap<>();
    private Map<String, List<String>> clientScheduledSessions = new HashMap<>();
    //private Map<String, List<String>> clientFeedback = new HashMap<>();

    
    private Map<String, List<String>> clientStartedPrograms = new HashMap<>();
    private Map<String, List<String>> clientCompletedPrograms = new HashMap<>();
   
    private List<String> clientFeedback = new ArrayList<>();
  
    private String selectedProgram;
    private boolean isProgramEnrolled;
    private String programReview;   
    private int programRating;
    private String programImprovementSuggestion;
    private String previousFeedback;
    private String programSchedule;
    private boolean profileUpdated;
    private String dietaryUpdateConfirmation;
   
    
   ////////////////////////////////////////////
    public MyApplication() {
    	
    	clientMessages = new HashMap<>();
        clientReports1 = new HashMap<>();
        
	  this.clientProfile = new ClientProfile();
      this.scanner = new Scanner(System.in);
        // إضافة مستخدمين افتراضيين
        users.put("admin", "password123");
        users.put("user1", "userpassword");
        currentClient = new Client();
        this.profileCreated = false;
        this.dietaryPreferencesUpdated = false;
        this.profileUpdated = false;
        this.errorMessage = "";
       
    
    }

    // دالة تسجيل الدخول كأدمن
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
///////////////////////////////////////
    // دالة الانتقال إلى صفحة معينة
    public void navigateToPage(String pageName) {
        if (isLoggedIn) {
            System.out.println("Navigating to page: " + pageName);
        } else {
            System.out.println("Please log in first.");
        }
    }/////////////////////////////////////////

    // دالة مراجعة مقال تم تقديمه
    public String reviewClientProgress(String clientName, double progressPercentage, String clientStatus) {
        // تحديد الرسالة بناءً على نسبة التقدم
        String progressMessage;

        if (progressPercentage == 100) {
            progressMessage = "Client has completed all tasks. Great work!";
        } else if (progressPercentage >= 50) {
            progressMessage = "Client is making good progress. Keep it up!";
        } else {
            progressMessage = "Client needs more focus to achieve goals.";
        }

        // إرجاع البيانات كرسالة واحدة
        return "Reviewing progress for client: " + clientName + "\n" +
               "Progress Percentage: " + progressPercentage + "%\n" +
               "Client Status: " + clientStatus + "\n" +
               "Progress Feedback: " + progressMessage;
    }

    /////////////////////////////////
    public void assertArticleStatus(String articleKey) {
        if (isLoggedIn) {
            Scanner scanner = new Scanner(System.in);

            
            // Ask the user for the article's status
            
            System.out.print("Enter the status for " + articleKey + " (e.g., Published, Pending, etc.): ");
            String status = scanner.nextLine();

            // Set the article's status in the map using the provided articleKey
            articleStatus.put(articleKey, status);

            // Print the status
            System.out.println(articleKey + " status set to: " + status);
        } else {
            System.out.println("Please log in first.");
        }
    }

//////////////////////////////////////

    // دالة تحديد مرئية المقال
    public void assertArticleStatusVisibility() {
        boolean isAdmin=true;
		if (isLoggedIn && isAdmin) {
            Scanner scanner = new Scanner(System.in);

            // طلب من المسؤول تحديد إذا كان المقال مرئيًا أم مخفيًا
            System.out.print("Enter visibility status for the article (true for visible, false for hidden): ");
            boolean visibility = scanner.nextBoolean(); // قراءة القيمة من المسؤول

            // إظهار حالة المقال بناءً على الإدخال
            if (visibility) {
                System.out.println("Article is now visible on the platform.");
            } else {
                System.out.println("Article is now hidden from the platform.");
            }
        } else {
            System.out.println("Only admins can modify visibility status. Please log in as an admin first.");
        }
    }
///////////////////////////////////////////////////////
    // دالة إدخال استعلام البحث
    public void enterSearchQuery(String query) {
        if (isLoggedIn) {
            // تحقق إذا كان الاستعلام فارغًا
            if (query == null || query.isEmpty()) {
                System.out.println("Please enter a valid search query.");
            } else {
                System.out.println("Searching for: " + query);
                boolean found = false;
                
                // البحث في الـ HashMap
                for (Map.Entry<String, String> entry : items.entrySet()) {
                    if (entry.getValue().toLowerCase().contains(query.toLowerCase())) {
                        // إذا كانت القيمة تحتوي على الاستعلام
                        System.out.println("Found: " + entry.getKey() + " - " + entry.getValue());
                        found = true;
                    }
                }

                // إذا لم يتم العثور على أي نتيجة
                if (!found) {
                    System.out.println("No results found for: " + query);
                }
            }
        } else {
            System.out.println("Please log in first.");
        }
    }

    // إضافة بعض العناصر إلى HashMap للتجربة
    public void addItemsToSearch() {
        items.put("1", "Wellness Program");
        items.put("2", "Fitness Article");
        items.put("3", "Healthy Recipes");
        items.put("4", "Weight Loss Guide");
        items.put("5", "Yoga Classes");
    }
    private String password1;

    // Getter لكلمة المرور (اختياري)
    public String getPassword() {
        return password;
    }

    // Setter لكلمة المرور
    public void setPassword(String password) {
        this.password = password1;
    }
    
    ////////////////////////////////////////////
  
    

    // دالة عرض المقالات المتعلقة بالاستعلام
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
    ////////////////////////////////////////////////////////////////
    // دالة اختيار حالة المقال
    public void selectArticleStatus(String articleKey, String status) {
        if (isLoggedIn) {
            if (status == null || status.isEmpty()) {
                System.out.println("Invalid status. Please provide a valid article status.");
            } else {
                // Store the selected status in the articleStatus map
                articleStatus.put(articleKey, status);
                System.out.println("Selected status for article \"" + articleKey + "\": " + status);
            }
        } else {
            System.out.println("Please log in first.");
        }
    }
//////////////////////////////////////////////////////////////////////////

    // دالة ترتيب البرامج حسب عدد المسجلين
    public void assertProgramsSortedByEnrollment() {
        if (isLoggedIn) {
            if (programs.isEmpty()) {
                System.out.println("No programs available to sort.");
            } else {
                // إنشاء قائمة من البرامج وفرزها حسب عدد الجلسات
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

///////////////////////////////////////////////////////////////////////////////////
    // دالة اختيار نوع التقرير
    public void selectReportType(String reportType) {
        if (isLoggedIn) {
            if (reportType != null && !reportType.isEmpty()) {
                System.out.println("Selected report type: " + reportType);
            } else {
                System.out.println("Please provide a valid report type.");
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////

    // دالة التأكد من أن التقرير بصيغة PDF متاح للتنزيل
    public void assertPdfReportAvailableForDownload() {
        if (isLoggedIn) {
            System.out.println("PDF report is available for download.");
        } else {
            System.out.println("Please log in first.");
        }
    }
    //////////////////////////////////////////////////////

    // دالة التأكد من أن الأقسام معينة مرئية
    public void assertSectionsVisible(String section1, String section2) {
        if (isLoggedIn) {
            if (section1 != null && !section1.isEmpty() && section2 != null && !section2.isEmpty()) {
                System.out.println("Sections visible: " + section1 + " and " + section2);
            } else {
                System.out.println("Please provide valid sections.");
            }
        }
    }
    ////////////////////////////////////////////////////////////////////
   // دالة لملء تفاصيل المستخدم
    public void fillUserDetails() {
        if (isLoggedIn) {
            // إنشاء كائن من Scanner لقراءة المدخلات من المستخدم
            Scanner scanner = new Scanner(System.in);

            // طلب الاسم والدور من المستخدم
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your role: ");
            String role = scanner.nextLine();

            // تخزين البيانات في HashMap
            userDetails.put("name", name);
            userDetails.put("role", role);

            // طباعة التفاصيل التي تم إدخالها
            System.out.println("User details filled: " + name + " as " + role);
        } else {
            System.out.println("Please log in first.");
        }
    }
    //////////////////////////////////////////////////////////////////////////

    // دالة لتأكيد إنشاء حساب المستخدم
    public void assertUserAccountCreated(String name) {
        if (isLoggedIn) {
            System.out.println("User account for " + name + " has been created.");
        } else {
            System.out.println("Please log in first.");
        }
    }
    /////////////////////////////////////////////////////////////////////////////

    // دالة لتحديث تفاصيل المستخدم
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
/////////////////////////////////////////////////////////////////////////////
 // دالة لتأكيد تحديث الحساب
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
///////////////////////////////////////////////////////////////////
 // دالة لتأكيد إذا كان الحساب غير نشط
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
/////////////////////////////////////////////////////////////////////
    // دالة لمراجعة طلب المعلم
 // دالة لمراجعة طلب المعلم
    public void reviewInstructorApplication(String instructorName) {
        if (isLoggedIn) {
            // افتراض وجود قائمة الطلبات مع حالتها
            String applicationStatus = instructorApplications.get(instructorName);

            if (applicationStatus != null) {
                switch (applicationStatus.toLowerCase()) {
                    case "pending":
                        System.out.println("Reviewing instructor application for: " + instructorName);
                        // تحديث الحالة عند البدء بالمراجعة
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
//////////////////////////////////////////////////////////////////////////////////////////////

    // دالة لتأكيد تفعيل حساب المعلم
 // دالة لتأكيد تفعيل حساب المعلم
    public void assertInstructorAccountActivated(String instructorName) {
        if (isLoggedIn) {
            // التحقق من حالة الحساب
            String accountStatus = instructorApplications.get(instructorName);

            if (accountStatus != null) {
                if (accountStatus.equalsIgnoreCase("active")) {
                    System.out.println("Instructor account for " + instructorName + " is already activated.");
                } else {
                    // تحديث الحالة إلى "active"
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
///////////////////////////////////////////////////////////////////////////////////
    // دالة لتأكيد عرض الإحصائيات
 // دالة لتأكيد عرض الإحصائيات
    public void assertStatisticsDisplayed() {
        if (isLoggedIn) {
            // افتراض وجود إحصائيات مخزنة
            int loginFrequency = userStatistics.getOrDefault("loginFrequency", 0);
            int programEnrollments = userStatistics.getOrDefault("programEnrollments", 0);

            // عرض الإحصائيات
            System.out.println("Statistics:");
            System.out.println(" - Login frequency: " + loginFrequency);
            System.out.println(" - Program enrollments: " + programEnrollments);
        } else {
            System.out.println("Please log in first.");
        }
    }
////////////////////////////////////////////////////////////////////////////////////////
    public void selectUserAccount(String name) {
        if (isLoggedIn) {
            // تحقق من وجود الحساب في تفاصيل المستخدم
            if (userDetails.containsKey("name") && userDetails.get("name").equals(name)) {
                // إذا تم العثور على الحساب
                System.out.println("User account selected: " + name);
            } else {
                // إذا لم يكن الحساب موجودًا
                System.out.println("User account " + name + " does not exist.");
            }
        } else {
            System.out.println("Please log in first.");
        }
    }
    ////////////////////////////////////////////////////////////////////////

    public void clickButton1(String buttonName) {
        if (isLoggedIn) {
            // تنفيذ العملية عند النقر على الزر المحدد
            switch (buttonName) {
                case "submit":
                    // تنفيذ عملية الإرسال (على سبيل المثال، إرسال مقال أو تقرير)
                    submitArticle(buttonName, buttonName); // هنا يجب تمرير البيانات المناسبة للمقال
                    break;
                case "approve":
                    // تنفيذ عملية الموافقة
                    approveArticle(buttonName);
                    break;
                case "reject":
                    // تنفيذ عملية الرفض
                    rejectArticle(buttonName);
                    break;
                default:
                    System.out.println("Unknown button action.");
            }
        } else {
            System.out.println("Please log in first.");
        }
    }

//////////////////////////////////////////////////////////////////////
    public void assertOnlyArticlesWithStatus(String status) {
        if (isLoggedIn) {
            boolean found = false;
            // تحقق من وجود مقالات بالحالة المحددة
            for (Map.Entry<String, String> entry : articleStatus.entrySet()) {
                if (entry.getValue().equals(status)) {
                    // إذا كانت المقالة لها الحالة المحددة، أضفها للعرض
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
/////////////////////////////////////////////////////////// 
    public void assertSearchResultsContain(String word) {
        if (isLoggedIn) {
            boolean found = false;
            // تحقق من وجود الكلمة في نتائج البحث
            for (String articleId : articleStatus.keySet()) {
                if (articleId.contains(word)) {
                    // إذا كان المقال يحتوي على الكلمة، عرض المقال
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
    /////////////////////////////////////////////////////////////

    public void assertArticleStatus(boolean visibility) {
        if (isLoggedIn) {
            // تحقق من حالة مقالات معينة إذا كانت مرئية
            for (Map.Entry<String, String> entry : articleStatus.entrySet()) {
                if (visibility && entry.getValue().equals("approved")) {
                    // إذا كانت المقالة مرئية وعليها حالة "approved"
                    System.out.println("Article with ID " + entry.getKey() + " is visible.");
                } else if (!visibility && !entry.getValue().equals("approved")) {
                    // إذا كانت المقالة غير مرئية
                    System.out.println("Article with ID " + entry.getKey() + " is not visible.");
                }
            }
        } else {
            System.out.println("Please log in first.");
        }
    }
    //////////////////////////////////////////////////////

    public void assertArticleStatuss(String status) {
        if (isLoggedIn) {
            boolean found = false;
            // تحقق من المقالات التي تحتوي على الحالة المحددة
            for (Map.Entry<String, String> entry : articleStatus.entrySet()) {
                if (entry.getValue().equals(status)) {
                    // إذا كانت المقالة تحتوي على الحالة المحددة، عرضها
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
///////////////////////////////////////////////////////////////////
    // محاكاة عملية إرسال مقال
    void submitArticle(String articleId, String articleContent) {
        if (isLoggedIn) {
            // التحقق من صحة معرّف المقال والمحتوى
            if (articleId == null || articleId.trim().isEmpty()) {
                System.out.println("Article ID cannot be null or empty.");
                return;
            }

            if (articleContent == null || articleContent.trim().isEmpty()) {
                System.out.println("Cannot submit an empty article.");
                return;
            }

            // تحقق إذا كان المقال قد تم تقديمه مسبقًا
            if (articleStatus.containsKey(articleId)) {
                System.out.println("Article with ID " + articleId + " has already been submitted.");
            } else {
                // تعيين حالة المقال كـ "submitted"
                articleStatus.put(articleId, "submitted");
                System.out.println("Article with ID " + articleId + " has been submitted successfully.");
            }
        } else {
            System.out.println("Please log in first.");
        }
    }

//////////////////////////////////////////////////////////////////////
    // محاكاة عملية الموافقة على مقال
    void approveArticle(String articleId) {
        if (isLoggedIn) {
            // تحقق مما إذا كان المقال موجودًا في قاعدة البيانات أو القائمة
            if (articleStatus.containsKey(articleId)) {
                String currentStatus = articleStatus.get(articleId);
                
                // تحقق إذا كان المقال قد تم تقديمه
                if (currentStatus.equalsIgnoreCase("submitted")) {
                    // تغيير حالة المقال إلى "موافق عليه"
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


    //////////////////////////////////////////////////////////////

    // محاكاة عملية رفض مقال
    void rejectArticle(String articleId) {
        if (isLoggedIn) {
            // تحقق مما إذا كان المقال موجودًا في القائمة
            if (articleStatus.containsKey(articleId)) {
                String currentStatus = articleStatus.get(articleId);
                
                // تحقق إذا كان المقال في حالة صالحة للرفض (مثل "submitted")
                if (currentStatus.equalsIgnoreCase("submitted")) {
                    // تغيير حالة المقال إلى "مرفوض"
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

///////////////////////////////////////////////////////////////
    public void checkAdminPermissions() {
        // التحقق إذا كان المستخدم مسجل الدخول
        if (!isLoggedIn) {
            System.out.println("Error: User is not logged in.");
            return; // إنهاء التنفيذ
        }

        // التحقق إذا كان المستخدم لديه صلاحيات المسؤول
        if (!hasAdminPermissions()) {
            System.out.println("Error: User does not have admin permissions.");
            return; // إنهاء التنفيذ
        }

        // إذا كان المستخدم لديه الصلاحيات اللازمة
        System.out.println("Success: User has the necessary admin permissions.");
    }

    private boolean hasAdminPermissions() {
        // هنا نفترض أن هناك متغيرًا يحتوي على صلاحيات المستخدم (مثل role)
        String userRole = userDetails.get("role");  // يفترض أن userDetails يحتوي على معلومات المستخدم
        return userRole != null && userRole.equalsIgnoreCase("admin");
    }
///////////////////////////////////////////////////////////////////////
	public void reviewContent(String content) {
	    // التحقق من أن المحتوى ليس فارغًا
	    if (content == null || content.trim().isEmpty()) {
	        System.out.println("Error: Content cannot be null or empty.");
	        return; // إنهاء التنفيذ
	    }

	    // تنفيذ المراجعة الأولية للمحتوى
	    System.out.println("Reviewing content: " + content);

	    // مثال على التحقق من طول المحتوى
	    if (content.length() < 50) {
	        System.out.println("Error: Content is too short. Must be at least 50 characters.");
	        return;
	    }

	    // مثال على التحقق من وجود كلمات محظورة
	    if (containsProhibitedWords(content)) {
	        System.out.println("Error: Content contains prohibited words.");
	        return;
	    }

	    // إذا كان المحتوى متوافقًا مع المعايير
	    System.out.println("Content review completed successfully. Content meets all requirements.");
	}
/////////////////////////////////////////////////////////////////////////////////

	private boolean containsProhibitedWords(String content) {
	    // قائمة بالكلمات المحظورة
	    String[] prohibitedWords = {"spam", "offensive", "inappropriate"};
	    
	    // التحقق من وجود الكلمات المحظورة في النص
	    for (String word : prohibitedWords) {
	        if (content.toLowerCase().contains(word)) {
	            return true; // الكلمة المحظورة موجودة
	        }
	    }
	    return false; // لا توجد كلمات محظورة
	}
///////////////////////////////////////////////////////////////////////////

	public void verifyContentQuality(String content) {
	    // التحقق من أن المحتوى ليس فارغًا
	    if (content == null || content.trim().isEmpty()) {
	        System.out.println("Error: Content cannot be null or empty.");
	        return; // إنهاء التنفيذ
	    }

	    System.out.println("Verifying content quality...");

	    // التحقق من الطول الأدنى
	    if (content.length() < 100) {
	        System.out.println("Error: Content is too short. Minimum required length is 100 characters.");
	        return;
	    }

	    // التحقق من استخدام لغة مناسبة (مثال بسيط على التحقق من الكلمات)
	    if (containsPoorLanguage(content)) {
	        System.out.println("Error: Content contains poor or inappropriate language.");
	        return;
	    }

	    // التحقق من التوافق مع الكلمات المفتاحية المطلوبة
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
	            return true; // إذا تم العثور على كلمة مفتاحية مطلوبة
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

	/////////////////////////////////////////////////////////////////////


    public void publishArticle(String articleContent) {
        if (articleContent == null || articleContent.trim().isEmpty()) {
            System.out.println("Error: Article content cannot be empty.");
            return;
        }
        articles.add(articleContent);
        System.out.println("Article published successfully.");
    }
///////////////////////////////////////////////////
    public void rejectContentReview(String reason) {
        if (reason == null || reason.isEmpty()) {
            System.out.println("Error: Reason for rejection is required.");
            return;
        }
        System.out.println("Content review rejected. Reason: " + reason);
    }
//////////////////////////////////////////////////////////////
    public void notifyInstructor(String message) {
        if (message == null || message.trim().isEmpty()) {
            System.out.println("Error: Notification message is required.");
            return;
        }

        // التحقق من الحد الأدنى لطول الرسالة (مثال: 10 أحرف)
        if (message.length() < 10) {
            System.out.println("Error: Notification message must be at least 10 characters long.");
            return;
        }

        // إرسال الإشعار
        System.out.println("Notification sent to instructor: " + message);
    }
/////////////////////////////////////////////////////////////////
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
//////////////////////////////////////////////////////////////////////////////
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
/////////////////////////////////////////////////////////////////////////////
    public void approveTip(String tipContent) {
        if (tips.contains(tipContent)) {
            System.out.println("Tip approved: " + tipContent);
        } else {
            System.out.println("Error: Tip not found.");
        }
    }
//////////////////////////////////////////////////////////////////////////
   
    public void makeTipVisible(String tipContent, LocalDate tipDate, boolean isLoggedIn, boolean isAdmin) {
        // تحقق إذا كانت النصيحة موجودة
        if (getTipStatus(tipContent, tipDate,isLoggedIn, isAdmin).equals("not_found")) {
            System.out.println("Error: Tip not found.");
            return;
        }

        // تحقق من حالة النصيحة: يجب أن تكون "approved"
        String tipStatus = getTipStatus(tipContent, tipDate, isAdmin, isAdmin);
        if (!"approved".equalsIgnoreCase(tipStatus)) {
            System.out.println("Error: Tip is not approved yet.");
            return;
        }

        // تحقق من تاريخ النصيحة: يجب أن تكون حديثة (لم تتجاوز 3 أيام)
        if (!isTipRecent(tipDate)) {
            System.out.println("Error: Tip is outdated.");
            return;
        }

        // تحقق من صلاحيات المستخدم
        if (!isUserAuthorized(isLoggedIn, isAdmin)) {
            System.out.println("Error: User is not authorized to view tips.");
            return;
        }

        // إذا مرت جميع الشروط
        System.out.println("Tip is now visible to users: " + tipContent);
    }
    ///////////////////////////////////////////////

    public String getTipStatus(String tipContent, LocalDate tipDate, boolean isLoggedIn, boolean isAdmin) {
        // التحقق من حالة المستخدم
        if (!isUserAuthorized(isLoggedIn, isAdmin)) {
            return "Error: User is not authorized to view tips.";  // إذا لم يكن المستخدم مسجل دخول أو ليس لديه صلاحيات إدارية
        }

        // تحقق من كون النصيحة حديثة
        if (!isTipRecent(tipDate)) {
            return "Error: Tip is outdated.";  // إذا كانت النصيحة قديمة (أكثر من 3 أيام)
        }

        // تحديد الحالات للنصائح
        if ("Tip 1".equals(tipContent)) {
            return "approved";  // النصيحة معتمدة
        } else if ("Tip 2".equals(tipContent)) {
            return "pending";  // النصيحة في انتظار الموافقة
        } else if ("Tip 3".equals(tipContent)) {
            return "rejected";  // النصيحة مرفوضة
        } else {
            return "Error: Tip not found.";  // إذا لم تكن النصيحة موجودة
        }
    }

    // دالة للتحقق مما إذا كان المستخدم مسجلاً الدخول وله صلاحيات إدارية
    public boolean isUserAuthorized(boolean isLoggedIn, boolean isAdmin) {
        return isLoggedIn && isAdmin;  // التأكد من أن المستخدم مسجل دخول وله صلاحيات إدارية
    }

    // دالة للتحقق إذا كانت النصيحة قد أضيفت خلال الأيام الثلاثة الماضية
    public boolean isTipRecent(LocalDate tipDate) {
        return !tipDate.isBefore(LocalDate.now().minusDays(3));  // تحقق مما إذا كانت النصيحة حديثة (لم تتجاوز 3 أيام)
    }


////////////////////////////////////////////////////////////////////
    public void rejectTipReview(String reason) {
        if (reason == null || reason.isEmpty()) {
            System.out.println("Error: Reason for rejection is required.");
            return;
        }
        System.out.println("Tip review rejected. Reason: " + reason);
    }

    // دالة لرفض النصيحة وإزالتها من القائمة
    public void rejectTip(String tipContent) {
        if (tips != null && tips.remove(tipContent)) {
            System.out.println("Tip rejected and removed: " + tipContent);
        } else {
            System.out.println("Error: Tip not found.");
        }
    }   
///////////////////////////////////////////////////////////
    public void notifySubmitter(String message, MyApplication app) {
        if (message == null || message.isEmpty() || app == null || app.getName().isEmpty()) {
            System.out.println("Error: Both message and submitter are required.");
            return;
        }
        System.out.println("Notification sent to submitter (" + app.getName() + "): " + message);
    }


    private String getName() {
		// TODO Auto-generated method stub
    	return name;
	}

    ///////////////////////////////////////////////////////////////////


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
    /////////////////////////

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
    //////////////////////

    public void notifyContentTeam(String message) {
        if (message == null || message.trim().isEmpty()) {
            System.out.println("Error: Message is required.");
            return;
        }
        System.out.println("Notification sent to content team: " + message);
    }

    // Method to submit a complaint
    public void submitComplaint(String complaintId, String complaintContent) {
        if (complaintId == null || complaintContent == null || complaintId.trim().isEmpty() || complaintContent.trim().isEmpty()) {
            System.out.println("Error: Both complaint ID and content are required.");
            return;
        }
        complaints.put(complaintId, complaintContent);
        System.out.println("Complaint submitted with ID: " + complaintId);
    }
    /////////////////

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
    
    /////////////////////

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
    ////////

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
    /////////

    public void notifyUser(String message) {
        if (message == null || message.trim().isEmpty()) {
            System.out.println("Error: Message is required.");
            return;
        }
        System.out.println("Notification sent to user: " + message);
    }


    public void saveNewSubscriptionPlan(String planId, String planDetails) {
        if (planId == null || planDetails == null || planId.isEmpty() || planDetails.isEmpty()) {
            System.out.println("Error: Plan ID and details are required.");
            return;
        }
        subscriptionPlans.put(planId, planDetails);
        System.out.println("New subscription plan saved: " + planId);
    }
    
    public boolean checkIfPlanIsSaved(String planId) {
        // التحقق من أن planId ليس فارغًا أو null
        if (planId == null || planId.trim().isEmpty()) {
            System.out.println("Error: Plan ID is required.");
            return false;
        }
        
        // التحقق مما إذا كانت الخطة موجودة في الخريطة
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
        System.out.println("User " + userId + " assigned to plan: " + planId);
    }
///////////
    // التحقق من وصول المستخدم لميزات الخطة
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

        // التحقق من إمكانية الوصول إلى ميزات الخطة بناءً على الخطة
        if (activeSubscriptions.getOrDefault(planId, false)) {
            System.out.println("User " + userId + " has access to features of plan: " + planId);
            return true;
        } else {
            System.out.println("User " + userId + " does not have access to the plan features.");
            return false;
        }
    }

    public void viewActiveSubscriptions() {
        System.out.println("Active subscriptions:");
        for (Map.Entry<String, Boolean> entry : activeSubscriptions.entrySet()) {
            if (entry.getValue()) { // فقط الاشتراكات النشطة
                System.out.println("Plan ID: " + entry.getKey() + " is active.");
            }
        }
    }
    

    public void processSubscriptionUpgrade(String userId, String newPlanId) {
        if (userId == null || userId.trim().isEmpty() || newPlanId == null || newPlanId.trim().isEmpty()) {
            System.out.println("Error: User ID and New Plan ID are required.");
            return;
        }

        // التحقق من أن الخطة الجديدة موجودة
        if (!subscriptionPlans.containsKey(newPlanId)) {
            System.out.println("Error: New plan not found.");
            return;
        }

        // التحقق مما إذا كانت الخطة الحالية أقل من الخطة الجديدة
        String currentPlan = userPlans.get(userId);
        if (currentPlan == null) {
            System.out.println("Error: No plan assigned to the user.");
            return;
        }

        // من المفترض أن يتم الترقية فقط إذا كانت الخطة الجديدة أفضل
        System.out.println("Upgrading user " + userId + " from " + currentPlan + " to " + newPlanId);
        userPlans.put(userId, newPlanId);
        System.out.println("User " + userId + " has been upgraded to " + newPlanId);
    }
//////////
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

        // تفعيل الخطة الجديدة
        userPlans.put(userId, newPlanId);
        activeSubscriptions.put(newPlanId, true); // جعل الخطة الجديدة نشطة
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

        // عرض المقال
        System.out.println("Reviewing submitted article with ID: " + articleId);
        System.out.println("Article Content: " + articleContent);
    }
    
    
    
    
    
    
    
	///////////////////////////////////////israa code
    public boolean loginAsInstructor(String username, String password) {
        if (instructors.containsKey(username) && instructors.get(username).equals(password)) {
            isLoggedIn2 = true;
            System.out.println("Logged in successfully as instructor.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }


    public void addInstructor(String username, String password) {
        instructors.put(username, password);
    }
        		

    void fillProgramDetails() {
        if (!isLoggedIn2) {
            System.out.println("Please log in first.");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Program Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Program Type (e.g., Educational, Entertainment, etc.): ");
            String type = scanner.nextLine();

            System.out.print("Enter Program Start Date (e.g., 2024-12-01): ");
            String startDate = scanner.nextLine();

            System.out.print("Enter Program End Date (e.g., 2024-12-31): ");
            String endDate = scanner.nextLine();

            currentProgram = new Program(title, duration, difficulty, goals, media, price, schedule);
            programs.put(name, currentProgram);
            

            System.out.println("\nProgram Details have been filled successfully!");
            currentProgram.displayDetails();
        }		
	}

	public void displayProgramDetails() {
        if (currentProgram != null) {
            currentProgram.displayDetails();
        } else {
            System.out.println("No program details available. Please create or fill program details first.");
        }
    }


    public String reviewClientProgress1(String clientName, double progressPercentage, String clientStatus) {
        if (!isLoggedIn2) {
            return "Please log in first.";
        }

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

    public void navigateToPage1(String pageName) {
        if (isLoggedIn2) {
            System.out.println("Navigating to page: " + pageName);
        } else {
            System.out.println("Please log in first.");
        }
    }
    public void deleteProgram(String programName) {
        if (programs.containsKey(programName)) {
            programs.remove(programName);
            System.out.println("Program " + programName + " deleted successfully.");
        } else {
            System.out.println("Program not found.");
        }
    }

    public void setGroupSessionSchedules(String programTitle, String sessionType, List<String> sessionSchedule) {
        System.out.println("Setting schedules for " + programTitle + " (" + sessionType + "):");
        for (String session : sessionSchedule) {
            System.out.println("Session: " + session);
        }
    }
    
    public void navigateToPage1() {
        if (isLoggedIn2) {
            System.out.println("Navigating to Page 1...");
        } else {
            System.out.println("Please log in first.");
        }
    }
    

    public void selectClients(List<String> enrolledClients) {
        if (isLoggedIn2) {
            System.out.println("Clients selected.");
        } else {
            System.out.println("Please log in first.");
        }
    }

    public void sendMessage(List<String> enrolledClients, String clientName) {
        if (clientMessages.containsKey(clientName)) {
            System.out.println("Sending message to client " + clientName + ": " + clientMessages.get(clientName));
        } else {
            System.out.println("No messages to send to " + clientName);
        }
    }
    

    public void viewClientMessages(String clientName) {
        if (clientMessages.containsKey(clientName)) {
            System.out.println("Messages for " + clientName + ": " + clientMessages.get(clientName));
        } else {
            System.out.println("No messages for " + clientName);
        }
    }
    

    public void replyToMessage(String clientName, String replyMessage) {
        if (clientMessages.containsKey(clientName)) {
            clientMessages.get(clientName).add(replyMessage);
            System.out.println("Replied to message for client: " + clientName);
        } else {
            System.out.println("No messages to reply to for " + clientName);
        }
    }

    public void verifyForumResponse(String forumName, String response) {
        System.out.println("Verifying forum response for forum " + forumName + ": " + response);
    }

    public void writeProgressReport(String clientName, String progress) {
        if (isLoggedIn2) {
            clientProgress.put(clientName, progress);
            System.out.println("Progress report written for " + clientName + ": " + progress);
        } else {
            System.out.println("Please log in first.");
        }
    }

    public void sendProgressReport(String clientName) {
        if (clientProgress.containsKey(clientName)) {
            System.out.println("Sending progress report for " + clientName + ": " + clientProgress.get(clientName));
        } else {
            System.out.println("No progress report found for " + clientName);
        }
    }

    public void updateSchedule(String programName, List<String> scheduleChange) {
        if (programs.containsKey(programName)) {
            Program program = programs.get(programName);
            program.addSessionSchedule(scheduleChange);
            System.out.println("Schedule updated for program: " + programName);
        } else {
            System.out.println("Program not found.");
        }
    }
    

    public List<String> getEnrolledClients(String programName) {
        if (programs.containsKey(programName)) {
            return Arrays.asList("Client1", "Client2", "Client3"); 
        }
        return new ArrayList<>();
    }

    public void sendNotification(String notificationMessage, String notificationMessage2) {
        System.out.println("Sending notification: " + notificationMessage);
    }

    public void createNewProgram(String programName, String type, String startDate, String endDate) {
        if (programs.containsKey(programName)) {
            System.out.println("Program with this name already exists.");
        } else {
            programs.put(programName, new Program(title, duration, difficulty, goals, media, price, schedule));
            System.out.println("New program created: " + programName);
        }
    }

    public void createNewOffer(String offerDetails) {
        System.out.println("New offer created: " + offerDetails);
    }

    public List<String> getAllClients() {
        return Arrays.asList("Client1", "Client2", "Client3", "Client4");
    }

    public void selectClient(String clientName) {
        System.out.println("Client selected: " + clientName);
    }

    public String getClientProgress(String clientName) {
        return clientProgress.getOrDefault(clientName, "No progress report found for this client.");
    }

    public void sendMotivationalMessage(String clientName, String message) {
        if (clientMessages.containsKey(clientName)) {
            clientMessages.get(clientName).add(message);
            System.out.println("Motivational message sent to client " + clientName);
        } else {
            System.out.println("No messages found for client " + clientName);
        }
    }

    public void clickButton2(String button) {
        switch (button.toLowerCase()) {
            case "submit":
                System.out.println("Submit button clicked. Performing submit action.");
                break;
            
            case "cancel":
                System.out.println("Cancel button clicked. Performing cancel action.");
                break;
            
            case "next":
                System.out.println("Next button clicked. Navigating to the next page.");
                break;

            case "previous":
                System.out.println("Previous button clicked. Navigating to the previous page.");
                break;

            default:
                System.out.println("Unknown button: " + button);
                break;
        }
    }

       public void composeMessage(String clientName, String message) {
        if (isLoggedIn2) {
            if (!clientMessages.containsKey(clientName)) {
                clientMessages.put(clientName, new ArrayList<>());
            }
            clientMessages.get(clientName).add(message);
            System.out.println("Message composed for client: " + clientName);
        } else {
            System.out.println("Please log in first.");
        }
    }

	public void updateProgram(Object titleToUpdate, Object newDuration, Object newDifficulty, Object newGoals,
			Object newMedia, Object newPrice, Object newSchedule) {
		 if (!isLoggedIn2) {
	            System.out.println("Please log in first.");
	            return;
	        }

	        if (!programs.containsKey(programName)) {
	            System.out.println("Program not found.");
	            return;
	        }

	        Program programToUpdate = programs.get(programName);

	        try (Scanner scanner = new Scanner(System.in)) {
	            System.out.println("\nUpdate Program Details:");
	            System.out.print("Enter New Program Title (Leave empty to keep current): ");
	            String newTitle = scanner.nextLine();
	            if (!newTitle.isEmpty()) {
	                programToUpdate.setTitle(newTitle);
	            }

	            System.out.print("Enter New Program Duration (Leave empty to keep current): ");
	            String newDuration1 = scanner.nextLine();
	            if (!newDuration1.isEmpty()) {
	                programToUpdate.setDuration(newDuration1);
	            }

	            System.out.print("Enter New Difficulty Level (Leave empty to keep current): ");
	            String newDifficulty1 = scanner.nextLine();
	            if (!newDifficulty1.isEmpty()) {
	                programToUpdate.setDifficulty(newDifficulty1);
	            }

	            System.out.print("Enter New Goals (Leave empty to keep current): ");
	            String newGoals1 = scanner.nextLine();
	            if (!newGoals1.isEmpty()) {
	                programToUpdate.setGoals(newGoals1);
	            }

	            System.out.print("Enter New Price (Enter -1 to keep current): ");
	            double newPrice1 = scanner.nextDouble();
	            if (newPrice1 >= 0) {
	                programToUpdate.setPrice(newPrice1);
	            }
	            scanner.nextLine();

	            System.out.println("Enter New Media Files (Leave empty to keep current): ");
	            String newMediaInput = scanner.nextLine();
	            if (!newMediaInput.isEmpty()) {
	                List<String> newMedia1 = Arrays.asList(newMediaInput.split(","));
	                programToUpdate.setMedia(newMedia1);
	            }

	            System.out.println("Enter New Schedule (Leave empty to keep current): ");
	            String newScheduleInput = scanner.nextLine();
	            if (!newScheduleInput.isEmpty()) {
	                List<String> newSchedule1 = Arrays.asList(newScheduleInput.split(","));
	                programToUpdate.setSchedule(newSchedule1);
	            }

	            System.out.println("\nProgram details have been successfully updated!");
	            programToUpdate.displayDetails();
	        }
		
	}

	public boolean createProgram(String title2, String duration2, Object difficulty2, String goals2, Object media2,
            Object price2, Object schedule2) {
if (!isLoggedIn2) {
System.out.println("Please log in first.");
return false;
}

try (Scanner scanner = new Scanner(System.in)) {
System.out.print("Enter Program Title: ");
String title = scanner.nextLine();

System.out.print("Enter Program Duration (e.g., 4 weeks): ");
String duration = scanner.nextLine();

System.out.print("Enter Difficulty Level (e.g., Beginner, Intermediate, Advanced): ");
String difficulty = scanner.nextLine();

System.out.print("Enter Program Goals: ");
String goals = scanner.nextLine();

System.out.print("Enter Price (if applicable): ");
double price = scanner.nextDouble();
scanner.nextLine(); 

System.out.println("Enter Media Files (e.g., videos, images, documents), separated by commas: ");
String mediaInput = scanner.nextLine();
List<String> media = Arrays.asList(mediaInput.split(","));

System.out.println("Enter Group Session Schedule (dates/times) in format 'YYYY-MM-DD HH:mm', separated by commas:");
String scheduleInput = scanner.nextLine();
List<String> schedule = validateScheduleInput(scheduleInput);

if (schedule == null) {
System.out.println("Invalid date/time format. Please use 'YYYY-MM-DD HH:mm'.");
return false;
}

Program newProgram = new Program(title, duration, difficulty, goals, media, price, schedule);
programs.put(title, newProgram);

System.out.println("\nProgram Created Successfully!");
newProgram.displayDetails();
return true;
}
}

	private List<String> validateScheduleInput(String scheduleInput) {
	    List<String> validSchedule = new ArrayList<>();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	    for (String dateTimeStr : scheduleInput.split(",")) {
	        try {
	            LocalDateTime.parse(dateTimeStr.trim(), formatter);
	            validSchedule.add(dateTimeStr.trim());
	        } catch (DateTimeParseException e) {
	            System.out.println("Invalid format for: " + dateTimeStr.trim());
	            return null;
	        }
	    }
	    return validSchedule;
	}
	
	public boolean sendMessageToClient(String clientUsername, String message) {
        if (clientUsername == null || clientUsername.isEmpty() || message == null || message.isEmpty()) {
            return false; 
        }

        if (!clientMessages.containsKey(clientUsername)) {
            clientMessages.put(clientUsername, new ArrayList<>());
        }

        clientMessages.get(clientUsername).add(message);
        System.out.println("Message sent to " + clientUsername + ": " + message);
        return true;
    }



	public boolean viewMessagesForClient(String clientUsername, String report) {
	    if (clientUsername == null || clientUsername.isEmpty()) {
	        return false; 
	    }

	    if (clientMessages.containsKey(clientUsername)) {
	        List<String> messages = clientMessages.get(clientUsername);
	        if (messages != null && !messages.isEmpty()) {
	            System.out.println("Messages for " + clientUsername + ":");
	            for (String message : messages) {
	                System.out.println(message);
	            }
	        } else {
	            System.out.println("No messages for " + clientUsername);
	        }
	    } else {
	        System.out.println("No messages for " + clientUsername);
	    }

	    if (report != null && !report.isEmpty()) {
	        String clientReport = clientReports1.get(clientUsername);
	        if (clientReport != null && !clientReport.isEmpty()) {
	            System.out.println("Client Report: " + clientReport);
	        } else {
	            System.out.println("No report available for " + clientUsername);
	        }
	    }

	    return true;
	}

	 public boolean provideFeedbackToClient(String clientUsername, String feedback) {
	        if (clientUsername == null || clientUsername.isEmpty() || feedback == null || feedback.isEmpty()) {
	            return false; 
	        }

	        clientReports1.put(clientUsername, feedback);
	        System.out.println("Feedback provided to " + clientUsername + ": " + feedback);
	        return true;
	    }

	 public boolean isClientExist(String clientUsername) {
		    return clientMessages.containsKey(clientUsername);  
		}
	 
	 public double getClientCompletionRate(String clientUsername) {
		    if (!isClientExist(clientUsername)) {
		        System.out.println("Client does not exist.");
		        return 0.0;
		    }
		    
		    List<String> completedPrograms = clientCompletedPrograms.get(clientUsername);
		    List<String> totalPrograms = clientStartedPrograms.get(clientUsername);

		    if (completedPrograms == null || totalPrograms == null || totalPrograms.isEmpty()) {
		        System.out.println("No programs found for the client.");
		        return 0.0;
		    }
		    double completionRate = (completedPrograms.size() / (double) totalPrograms.size()) * 100;
		    return completionRate;
		}
	 
	 public boolean sendMotivationalReminder(String clientUsername) {
		    if (!isClientExist(clientUsername)) {
		        System.out.println("Client does not exist.");
		        return false;
		    }

		    double completionRate = getClientCompletionRate(clientUsername);
		    String reminderMessage;

		    if (completionRate < 50) {
		        reminderMessage = "Hey " + clientUsername + ", keep going! You can do it! Stay focused and keep pushing!";
		    } else {
		        reminderMessage = "Great job, " + clientUsername + "! You're doing amazing, keep up the excellent work!";
		    }

		    return sendMessageToClient(clientUsername, reminderMessage);
		}
	 
	 public double getClientAttendanceRate(String clientUsername) {
		    if (!isClientExist(clientUsername)) {
		        System.out.println("Client does not exist.");
		        return 0.0;
		    }

		    List<String> scheduledSessions = clientScheduledSessions.get(clientUsername);
		    List<String> attendedSessions = clientAttendedSessions.get(clientUsername);

		    if (scheduledSessions == null || attendedSessions == null || scheduledSessions.isEmpty()) {
		        System.out.println("No scheduled sessions or attendance data found for this client.");
		        return 0.0;
		    }

		    double attendanceRate = (attendedSessions.size() / (double) scheduledSessions.size()) * 100;

		    return attendanceRate;
		}
	 
	 public boolean registerClient(String username, String password) {
		    if (!clientMessages.containsKey(username)) {
		        clientMessages.put(username, new ArrayList<>()); 
		        clientCompletedPrograms.put(username, new ArrayList<>()); 
		        clientStartedPrograms.put(username, new ArrayList<>()); 
		        return true;
		    }
		    return false; 
		}
	 
	 public boolean addProgramToClient(String clientUsername, String programTitle) {
		    if (clientStartedPrograms.containsKey(clientUsername)) {
		        clientStartedPrograms.get(clientUsername).add(programTitle);
		        return true;
		    } else {
		        System.out.println("Client not found or not registered.");
		        return false;
		    }
		}
	 
	 public boolean markSessionAsCompleted(String clientUsername, String programTitle, boolean attended) {
		    if (clientCompletedPrograms.containsKey(clientUsername)) {
		        if (attended) {
		            clientCompletedPrograms.get(clientUsername).add(programTitle);
		        }
		        return true;
		    } else {
		        System.out.println("Client not found or not registered.");
		        return false;
		    }
		}
	 
	 
	 public boolean notifyClientsAboutSchedule(String programTitle, String updatedSchedule) {
		    if (programs.containsKey(programTitle)) {
		        for (String client : clientStartedPrograms.keySet()) {
		            if (clientStartedPrograms.get(client).contains(programTitle)) {
		                String message = "Schedule update for program '" + programTitle + "': " + updatedSchedule;
		                sendMessageToClient(client, message);
		            }
		        }
		        return true;
		    } else {
		        System.out.println("Program not found.");
		        return false;
		    }
		}
	 
	 public boolean announceNewProgramsOrOffers(String announcement) {
		    if (!clients.isEmpty()) {
		        for (String client : clients.keySet()) {
		            sendMessageToClient(client, "Announcement: " + announcement);
		        }
		        return true;
		    } else {
		        System.out.println("No registered clients to notify.");
		        return false;
		    }
	 }
	
	
	////////////// ********** ClientProfile Class ********** Yumna
		 //  ********** ClientProfile **********
	       
	    public class ClientProfile {
	        private String name;
	        private int age;
	        private String fitnessGoals;
	        private String dietaryPreferences;

	       
	        public void setName(String name) { this.name = name; }
	        public String getName() { return name; }

	        public void setAge(int age) { this.age = age; }
	        public int getAge() { return age; }

	        public void setFitnessGoals(String fitnessGoals) { this.fitnessGoals = fitnessGoals; }
	        public String getFitnessGoals() { return fitnessGoals; }

	        public void setDietaryPreferences(String dietaryPreferences) { this.dietaryPreferences = dietaryPreferences; }
	        public String getDietaryPreferences() { return dietaryPreferences; }
	    }
	    
	 // ********** Client Class **********
	    public class Client {
	        private boolean loggedIn;
	        private boolean enrolledInProgram;
	        private String weight;
	        private String bmi;
	        private String attendance;
	        private String weightGoal;
	        private String bmiGoal;
	        private String runGoal;
	        private double currentweight;
	        private double currentBmi;
	        private double currentRunDistance;
	        private boolean isLoggedIn = false;
	        private boolean isFitnessProgramCompleted = false;
	        
	        
	        public boolean isLoggedIn() { return loggedIn; }
	        public void setLoggedIn(boolean loggedIn) { this.loggedIn = loggedIn; }
	        public boolean isEnrolledInProgram() { return enrolledInProgram; }
	        public void setEnrolledInProgram(boolean enrolledInProgram) { this.enrolledInProgram = enrolledInProgram; }
	        public String getWeight() { return weight; }
	        public void setWeight(String weight) { this.weight = weight; }
	        public String getBmi() { return bmi; }
	        public void setBmi(String bmi) { this.bmi = bmi; }
	        public String getAttendance() { return attendance; }
	        public void setAttendance(String attendance) { this.attendance = attendance; }
	        public List<String> getAttendanceHistory() { return attendanceHistory; }
	        public List<String> getMilestones() { return milestones; }
	        public List<String> getBadges() { return badges; }
	        public String getWeightGoal() { return weightGoal; }
	        public void setWeightGoal(String weightGoal) { this.weightGoal = weightGoal; }
	        public String getBmiGoal() { return bmiGoal; }
	        public void setBmiGoal(String bmiGoal) { this.bmiGoal = bmiGoal; }
	        public String getRunGoal() { return runGoal; }
	        public void setRunGoal(String runGoal) { this.runGoal = runGoal; }
	        public String getCurrentWeight() { return "60"; }
	        public String getCurrentBmi() { return "25"; }
	        public String getCurrentRunDistance() { return "5"; } 
	        public boolean isFitnessProgramCompleted() { return true; } 
			private boolean fitnessProgramCompleted; 

			public void setFitnessProgramCompleted(boolean fitnessProgramCompleted) {
			    this.fitnessProgramCompleted = fitnessProgramCompleted;
			}
			
		    public List<String> getAchievements() {
		        return achievements;
		    }

		    public void setCurrentBmi(double currentBmi) {
		        this.currentBmi = currentBmi;
		    }

		    public void setCurrentRunDistance(double currentRunDistance) {
		        this.currentRunDistance = currentRunDistance;
		    }
		    
		    public void setCurrentWeight(double currentweight) {
		        this.currentweight = currentweight;
		    }
		}


	//////  Feedback and Reviews ************************************************************************************
	    
	    public void loginClient() {
	        currentClient.setLoggedIn(true);
	        isLoggedIn = true;
	    }
	    
	    public void completeFitnessProgram() {
	        if (isLoggedIn) {
	            currentClient.setFitnessProgramCompleted(true);
	        }
	    }

	    public void navigateToFeedbackSection() {
	        if (!isLoggedIn || !currentClient.isFitnessProgramCompleted()) {
	            throw new IllegalStateException("Client must complete the program to leave feedback.");
	        }
	        System.out.println("Navigating to feedback section...");
	    }

	    public void rateProgram(int rating) {
	        if (rating < 1 || rating > 5) {
	            throw new IllegalArgumentException("Rating must be between 1 and 5.");
	        }
	        programRating = rating;
	        System.out.println("Program rated: " + rating);
	    }

	    public void submitProgramReview(String review) {
	        if (review == null || review.isEmpty()) {
	            throw new IllegalArgumentException("Review cannot be empty.");
	        }
	        programReview = review;
	        previousFeedback = review; 
	        System.out.println("Review submitted: " + review);
	    }

	    public void submitProgramImprovementSuggestion(String suggestion) {
	        if (suggestion == null || suggestion.isEmpty()) {
	            throw new IllegalArgumentException("Suggestion cannot be empty.");
	        }
	        programImprovementSuggestion = suggestion;
	        System.out.println("Improvement suggestion submitted: " + suggestion);
	    }

	    public void viewPreviousFeedback() {
	        if (previousFeedback == null || previousFeedback.isEmpty()) {
	            System.out.println("No previous feedback found.");
	        } else {
	            System.out.println("Previous feedback: " + previousFeedback);
	        }
	    }

	    public int getProgramRating() {
	        return programRating;
	    }

	    public boolean isReviewVisible() {
	        return programReview != null && !programReview.isEmpty();
	    }

	    public String getReviewComments() {
	        return programReview;
	    }

	    public boolean isSuggestionStored() {
	        return programImprovementSuggestion != null && !programImprovementSuggestion.isEmpty();
	    }

	    public String getStoredSuggestion() {
	        return programImprovementSuggestion;
	    }

	    public String getPreviousFeedback() {
	        return previousFeedback;
	    }
	    
	//////  Program Exploration and Enrollment ************************************************************************************

	    public void navigateToProgramBrowsingPage() {
	        System.out.println("Navigating to the program browsing page...");
	    }

	    public List<String> filterProgramsByDifficulty(String difficulty) {
	        List<String> filteredPrograms = new ArrayList<String>();
	        for (String program : allPrograms) {
	            if (program.toLowerCase().contains(difficulty.toLowerCase())) {
	                filteredPrograms.add(program);
	            }
	        }
	        return filteredPrograms;
	    }
	    
		
	    public List<String> filterProgramsByFocusArea(String focusArea) {
	        List<String> filteredPrograms = new ArrayList<String>();
	        for (String program : allPrograms) {
	            if (program.toLowerCase().contains(focusArea.toLowerCase())) {
	                filteredPrograms.add(program);
	            }
	        }
	        return filteredPrograms;
	    }


	    public List<String> filterProgramsByDifficultyAndFocusArea(String difficulty, String focusArea) {
	        List<String> filteredPrograms = new ArrayList<String>();
	        for (String program : allPrograms) {
	            if (program.toLowerCase().contains(difficulty.toLowerCase()) &&
	                program.toLowerCase().contains(focusArea.toLowerCase())) {
	                filteredPrograms.add(program);
	            }
	        }
	        return filteredPrograms;
	    }

	    public void selectProgram(String programName) {
	        if (allPrograms.contains(programName)) {
	            selectedProgram = programName;
	        } else {
	            throw new IllegalArgumentException("Program not found: " + programName);
	        }
	    }

	    public String enrollInSelectedProgram() {
	        if (selectedProgram != null && !selectedProgram.isEmpty()) {
	            isProgramEnrolled = true;
	            return "Enrollment Successful!";
	        } else {
	            return "No program selected. Please select a program first.";
	        }
	    }

	    public boolean isProgramEnrolled() {
	        return isProgramEnrolled;
	    }

	    public String getProgramSchedule() {
	        if (isProgramEnrolled && selectedProgram != null) {
	            programSchedule = "Start Date: 2024-12-20\n" +
	                              "End Date: 2025-03-20\n" +
	                              "Time: 10:00 AM - 11:30 AM (Monday, Wednesday)";
	            return programSchedule;
	        } else {
	            return "No program selected or not enrolled.";
	        }
	    }
	    
	    
	//  //  //  Account Management ***********************************************************************************************
	        
	 
	    public void initializeSystem() {
	        clientProfile = new ClientProfile();
	        profileCreated = false;
	        dietaryPreferencesUpdated = false;
	        errorMessage = ""; // Clear any previous error messages
	    }
	    
	 
	    public void createProfile(int age, String fitnessGoals) {
	        clientProfile.setAge(age);
	        clientProfile.setFitnessGoals(fitnessGoals);
	        profileCreated = true;
	    }

	   
	    public void updateClientDetails(int age, String fitnessGoals) {
	        clientProfile.setAge(age);
	        clientProfile.setFitnessGoals(fitnessGoals);
	        profileUpdateConfirmation = "Profile successfully updated!";
	    }
	    
	 
	    public void addDietaryPreferences(ArrayList<String> preferences) {
	      
	        dietaryPreferencesUpdated = true;
	    }

	    
	    public void submitProfileCreationForm() {
	        if (clientProfile.getAge() <= 0 || clientProfile.getFitnessGoals() == null || clientProfile.getFitnessGoals().isEmpty()) {
	            errorMessage = "All fields are required!";
	        } else {
	            profileCreated = true;
	            profileCreationConfirmation = "Profile successfully created!";
	        }
	    }
	    
	 
	    public void submitProfileUpdate() {
	        if (clientProfile.getAge() <= 0 || clientProfile.getFitnessGoals() == null || clientProfile.getFitnessGoals().isEmpty()) {
	            errorMessage = "All fields are required!";
	        } else {
	            profileCreated = true;
	            profileUpdateConfirmation = "Profile successfully updated!";
	        }
	    }
	    
	 
	    public boolean isProfileCreated() {
	        return profileCreated;
	    }

	    public String getProfileCreationConfirmation() {
	        return profileCreationConfirmation;
	    }

	    public boolean isDietaryPreferencesUpdated() {
	        return dietaryPreferencesUpdated;
	    }

	    public String getDietaryUpdateConfirmation() {
	        return dietaryPreferencesUpdated ? "Dietary preferences successfully updated!" : "";
	    }

	    public String getErrorMessage() {
	        return errorMessage;
	    }

	    public void viewProfile() {
	        System.out.println("Profile Details:");
	        System.out.println("Age: " + clientProfile.getAge());
	        System.out.println("Fitness Goals: " + clientProfile.getFitnessGoals());
	        System.out.println("Dietary Preferences: " + clientProfile.getDietaryPreferences());
	    }

	    public ClientProfile getClientProfile() {
	        return clientProfile;
	    }
	    
	  
	    public void enterClientDetails(int age, String fitnessGoals) {
	        clientProfile.setAge(age);
	        clientProfile.setFitnessGoals(fitnessGoals);
	        
	    }
	    
	    public void submitDietaryPreferencesForm() {
	        if (dietaryPreferencesUpdated) {
	            dietaryUpdateConfirmation = "Dietary preferences successfully updated!";
	        }
	    }
	    
	    public boolean isProfileUpdated() {
	        return profileUpdated;
	    }
	    
	    public String getProfileUpdateConfirmation() {
	        return profileUpdateConfirmation;
	    }
	    
	  
	//  //  //  Progress Tracking ***********************************************************************************************
	    
	  
	    public void navigateToProgressTrackingPage() {
	        System.out.println("Navigating to the progress tracking page...");
	    }
	    
	    public void enrollInProgram() {
	        if (currentClient == null) {
	            System.out.println("No client logged in.");
	            return;
	        }
	        currentClient.setEnrolledInProgram(true);
	        System.out.println("Successfully enrolled in program and attendance history added.");
	    }
	    
	   public String viewMilestones() {
	    	List<String> list1 = currentClient.getMilestones();
	    	return "*** View Milestones ***\n" +
	    	              String.join(" ----- ", list1) ;         
	    	    }


	    public String viewAchievements() {
	    	List<String> list2 = currentClient.getAchievements();
	        return "*** View Achievements ***\n" +
	               "Badges: " + String.join(" ----- ", list2);
	    }

	    public String viewAttendanceHistory() {
	        List<String> list3 = currentClient.getAttendanceHistory();
	        return "*** View Attendance History ***\n" +
	               "Attendance History: " + String.join(" ----- ", list3);
	    }

	    public void setFitnessGoals(String weightGoal, String bmiGoal, String runGoal) {
	        currentClient.setWeightGoal(weightGoal);
	        currentClient.setBmiGoal(bmiGoal);
	        currentClient.setRunGoal(runGoal);
	        System.out.println("Fitness goals have been set successfully.");
	    }

	    public String checkProgressTowardsGoals() {
	        return "*** Check Progress Towards Goals ***\n" +
	               "Progress towards goals:\n" +
	               "Weight Goal: " + currentClient.getWeightGoal() + " -------- Current Weight: " + currentClient.getCurrentWeight() + "\n" +
	               "BMI Goal: " + currentClient.getBmiGoal() + " ----------- Current BMI: " + currentClient.getCurrentBmi() + "\n" +
	               "Running Goal: " + currentClient.getRunGoal() + " ------ Current Running Distance: " + currentClient.getCurrentRunDistance() + " km.";
	    }

	

		
	}
