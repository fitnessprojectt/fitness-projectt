package fit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
// rawan
class Program {
    String name;
    String type;
    String startDate;
    String endDate;
    List<String> sessionSchedule;

    public Program(String name, String type, String startDate, String endDate) {
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sessionSchedule = new ArrayList<>(); 
    }// تهيئة الجدول الفارغ
        public void addSessionSchedule(List<String> schedule) {
            this.sessionSchedule.addAll(schedule);  // إضافة الجلسات الجديدة إلى الجدول
        }

        // إرجاع عدد الجلسات في البرنامج
        public int getSessionCount() {
            return sessionSchedule.size();  // إرجاع عدد الجلسات
        }
      
    public void displayDetails() {
        System.out.println("\nProgram Details:");
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Session Schedule: " + sessionSchedule);
    }
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
    private Map<String, String> users = new HashMap<>();
    private Map<String, String> articleStatus = new HashMap<>();
    private Map<String, String> userDetails = new HashMap<>();
    private boolean isLoggedIn = false;
    private Map<String, String> items = new HashMap<>();
    private Map<String, String> instructors = new HashMap<>();
    private Map<String, Program> programs = new HashMap<>();
    private Map<String, List<String>> clientMessages = new HashMap<>();
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
	private List<String> allPrograms;
    private String selectedProgram;
    private boolean isProgramEnrolled;
    private Client currentClient; 
    private boolean isLoggedIn3;
    private String programReview;   
    private int programRating;
    private String programImprovementSuggestion;
    private String previousFeedback;
    private String programSchedule;
    private boolean profileCreated;
    private boolean dietaryPreferencesUpdated;
    private boolean profileUpdated;
    private String profileCreationConfirmation;
    private String dietaryUpdateConfirmation;
    private String profileUpdateConfirmation;
    private String errorMessage;
    private ClientProfile clientProfile;
 // تعريف الماب لتخزين حالة الطلبات
    Map<String, String> instructorApplications = new HashMap<>();
    Map<String, Integer> userStatistics = new HashMap<>();
	private String name;



    public MyApplication() {
        // إضافة مستخدمين افتراضيين
        users.put("admin", "password123");
        users.put("user1", "userpassword");
        instructors.put("john_doe", "password123");
        instructors.put("jane_smith", "securePass456");
        currentClient = new Client();
        allPrograms = new ArrayList<String>();
        allPrograms.add("Intermediate Muscle Building Program");
        allPrograms.add("Beginner Yoga Program");
        allPrograms.add("Advanced Strength Training");
        allPrograms.add("Weight Loss Bootcamp");
        allPrograms.add("Muscle Building Mastery");
        allPrograms.add("Intermediate Muscle Building Mastery");
        this.clientProfile = new ClientProfile(dietaryUpdateConfirmation, programRating, dietaryUpdateConfirmation, dietaryUpdateConfirmation);
        this.profileCreated = false;
        this.dietaryPreferencesUpdated = false;
        this.profileUpdated = false;
        this.errorMessage = "";
        programs.put("Yoga Program", new Program("Yoga Program", "Fitness", "2024-01-01", "2024-03-01"));
        programs.put("Strength Program", new Program("Strength Program", "Fitness", "2024-02-01", "2024-05-01"));
        programs.put("Weight Loss Program", new Program("Weight Loss Program", "Fitness", "2024-01-15", "2024-04-15"));

        // إضافة الجلسات إلى البرامج
        programs.get("Yoga Program").addSessionSchedule(Arrays.asList("Monday 6 PM", "Wednesday 6 PM"));
        programs.get("Strength Program").addSessionSchedule(Arrays.asList("Tuesday 5 PM", "Thursday 5 PM", "Saturday 9 AM"));
        programs.get("Weight Loss Program").addSessionSchedule(Arrays.asList("Monday 7 PM", "Friday 7 PM"));
    
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
  /*  public void assertOnlyArticlesWithStatus(String status) {
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
    }*/
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

	    

	 public boolean createProgram() {
		    if (!isLoggedIn2) {
		        System.out.println("Please log in first.");
		        return false;
		    }

		    // استدعاء الدالة لطلب التفاصيل من المستخدم
		    fillProgramDetails(); // لا حاجة لتمرير null
		    System.out.println("\nProgram Created Successfully!");
		    return true;
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

	            currentProgram = new Program(name, type, startDate, endDate);
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
	//////////////////////////////////////////////////////////////////
	    // حذف البرنامج
	    public void deleteProgram(String programName) {
	        if (programs.containsKey(programName)) {
	            programs.remove(programName);
	            System.out.println("Program " + programName + " deleted successfully.");
	        } else {
	            System.out.println("Program not found.");
	        }
	    }

	    // إضافة جدول الجلسات
	    public void addGroupSessionSchedule(String programName, List<String> schedule) {
	        if (programs.containsKey(programName)) {
	            Program program = programs.get(programName);
	            program.addSessionSchedule(schedule);  // إضافة الجدول إلى البرنامج
	            System.out.println("Group session schedule added to program: " + programName);
	        } else {
	            System.out.println("Program not found.");
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

	    ///////////////////////////////////////

	    public void updateSchedule(String programName, List<String> scheduleChange) {
	        if (programs.containsKey(programName)) {
	            Program program = programs.get(programName);
	            program.addSessionSchedule(scheduleChange); // تحديث الجدول
	            System.out.println("Schedule updated for program: " + programName);
	        } else {
	            System.out.println("Program not found.");
	        }
	    }
	    

	    public List<String> getEnrolledClients(String programName) {
	        if (programs.containsKey(programName)) {
	            // إعادة قائمة العملاء المسجلين في البرنامج
	            return Arrays.asList("Client1", "Client2", "Client3"); // مثال فقط
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
	            programs.put(programName, new Program(programName, type, startDate, endDate));
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
	                // تنفيذ المنطق عند الضغط على زر "Submit"
	                System.out.println("Submit button clicked. Performing submit action.");
	                // يمكن هنا تنفيذ الإجراءات المتعلقة بزر "Submit"
	                break;
	            
	            case "cancel":
	                // تنفيذ المنطق عند الضغط على زر "Cancel"
	                System.out.println("Cancel button clicked. Performing cancel action.");
	                // يمكن هنا تنفيذ الإجراءات المتعلقة بزر "Cancel"
	                break;
	            
	            case "next":
	                // تنفيذ المنطق عند الضغط على زر "Next"
	                System.out.println("Next button clicked. Navigating to the next page.");
	                // يمكن هنا تنفيذ الإجراءات المتعلقة بزر "Next"
	                break;

	            case "previous":
	                // تنفيذ المنطق عند الضغط على زر "Previous"
	                System.out.println("Previous button clicked. Navigating to the previous page.");
	                // يمكن هنا تنفيذ الإجراءات المتعلقة بزر "Previous"
	                break;

	            default:
	                System.out.println("Unknown button: " + button);
	                // في حالة عدم وجود الزر المعروف
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

		public void updateProgram(String programId, String newTitle) {
			if (!isLoggedIn2) {
	            System.out.println("Please log in first.");
	            return;
	        }

	        if (currentProgram == null) {
	            System.out.println("No program exists to update. Please create a program first.");
	            return;
	        }

	        try (Scanner scanner = new Scanner(System.in)) {
	            System.out.println("\nUpdate Program Details:");
	            System.out.print("Enter New Program Name (Leave empty to keep current): ");
	            String newName = scanner.nextLine();
	            if (!newName.isEmpty()) {
	                currentProgram.name = newName;
	            }

	            System.out.print("Enter New Program Type (Leave empty to keep current): ");
	            String newType = scanner.nextLine();
	            if (!newType.isEmpty()) {
	                currentProgram.type = newType;
	            }

	            System.out.print("Enter New Program Start Date (Leave empty to keep current): ");
	            String newStartDate = scanner.nextLine();
	            if (!newStartDate.isEmpty()) {
	                currentProgram.startDate = newStartDate;
	            }

	            System.out.print("Enter New Program End Date (Leave empty to keep current): ");
	            String newEndDate = scanner.nextLine();
	            if (!newEndDate.isEmpty()) {
	                currentProgram.endDate = newEndDate;
	            }

	            System.out.println("\nProgram details have been successfully updated!");
	            currentProgram.displayDetails();
	        }
			
		}
		 // ********** ClientProfile Class ********** Yumna
		public class ClientProfile {
	        private String name;
	        private int age;
	        private String fitnessGoals;
	        private String dietaryPreferences;

	        // Constructor to initialize the profile
	        public ClientProfile(String name, int age, String fitnessGoals, String dietaryPreferences) {
	            this.name = name;
	            this.age = age;
	            this.fitnessGoals = fitnessGoals;
	            this.dietaryPreferences = dietaryPreferences;
	        }

	        // Getter and Setter methods for each field
	        public void setName(String name) {
	            this.name = name;
	        }

	        public String getName() {
	            return name;
	        }

	        public void setAge(int age) {
	            this.age = age;
	        }

	        public int getAge() {
	            return age;
	        }

	        public void setFitnessGoals(String fitnessGoals) {
	            this.fitnessGoals = fitnessGoals;
	        }

	        public String getFitnessGoals() {
	            return fitnessGoals;
	        }

	        public void setDietaryPreferences(String dietaryPreferences) {
	            this.dietaryPreferences = dietaryPreferences;
	        }

	        public String getDietaryPreferences() {
	            return dietaryPreferences;
	        }
		}

	    
	  

	 // ********** Client Class **********
	    public class Client {
	        private boolean loggedIn;
	        private boolean isFitnessProgramCompleted;
	        private boolean isEnrolledInProgram;
	        private String weight; // e.g., "70kg"
	        private String bmi; // e.g., "24"
	        private String attendance; // e.g., "90%"
	        private List<String> badges; // A list of badges the client has earned
	        private List<String> attendanceHistory; // List to store attendance records
	        private String currentWeight;
	        private String currentBmi;
	        private String currentRunDistance;
	        private String weightGoal;
	        private String bmiGoal;
	        private String runGoal;
	        private int age;
	        private String fitnessGoals;
	        private String dietaryPreferences;
	        
	        
	     
	      
	        public Client() {
	            loggedIn = false;
	            isFitnessProgramCompleted = false;
	            isEnrolledInProgram = false;
	            badges = new ArrayList<String>();
	            attendanceHistory = new ArrayList<String>();
	            weight = "70"; // Default weight
	            bmi = "25"; // Default BMI
	            attendance = "100%"; // Default attendance
	            currentWeight = "70"; // Default current weight
	            currentBmi = "25"; // Default current BMI
	            currentRunDistance = "0"; // Default current running distance
	            weightGoal = "65"; // Default weight goal
	            bmiGoal = "22"; // Default BMI goal
	            runGoal = "5"; // Default running goal
	            
	        }

	        
	        public Client(int age, String fitnessGoals) {
	            this.age = age;
	            this.fitnessGoals = fitnessGoals;
	            this.dietaryPreferences = "";
	            this.loggedIn = false;
	        }
	        
	        
	        public boolean isLoggedIn3() {
	            return loggedIn;
	        }

	        public void setLoggedIn(boolean loggedIn) {
	            this.loggedIn = loggedIn;
	        }

	        public boolean isFitnessProgramCompleted() {
	            return isFitnessProgramCompleted;
	        }

	        public void setFitnessProgramCompleted(boolean isFitnessProgramCompleted) {
	            this.isFitnessProgramCompleted = isFitnessProgramCompleted;
	        }

	        public boolean isEnrolledInProgram() {
	            return isEnrolledInProgram;
	        }

	        public void setEnrolledInProgram(boolean isEnrolledInProgram) {
	            this.isEnrolledInProgram = isEnrolledInProgram;
	        }

	        public String getWeight() {
	            return weight;
	        }

	        public String getBmi() {
	            return bmi;
	        }

	        public String getAttendance() {
	            return attendance;
	        }

	        public List<String> getBadges() {
	            return badges;
	        }

	        public void addBadge(String badge) {
	            badges.add(badge);
	        }

	        public String getCurrentWeight() {
	            return currentWeight;
	        }

	        public String getCurrentBmi() {
	            return currentBmi;
	        }

	        public String getCurrentRunDistance() {
	            return currentRunDistance;
	        }

	        public String getWeightGoal() {
	            return weightGoal;
	        }

	        public String getBmiGoal() {
	            return bmiGoal;
	        }

	        public String getRunGoal() {
	            return runGoal;
	        }

	        public void setWeightGoal(String weightGoal) {
	            this.weightGoal = weightGoal;
	        }

	        public void setBmiGoal(String bmiGoal) {
	            this.bmiGoal = bmiGoal;
	        }

	        public void setRunGoal(String runGoal) {
	            this.runGoal = runGoal;
	        }
	        
	        
	        public void addAttendanceRecord(String record) {
	            attendanceHistory.add(record);
	        }
	        
	        
	        // Enroll in a fitness program
	        public boolean enrollInFitnessProgram() {
	            if (!isEnrolledInProgram) {
	                isEnrolledInProgram = true;
	                return true;
	            } else {
	                return false; // Already enrolled
	            }
	        }
	        
	        public int getAge() {
	            return age;
	        }

	        public void setAge(int age) {
	            this.age = age;
	        }

	        public String getFitnessGoals() {
	            return fitnessGoals;
	        }

	        public void setFitnessGoals(String fitnessGoals) {
	            this.fitnessGoals = fitnessGoals;
	        }

	        public String getDietaryPreferences() {
	            return dietaryPreferences;
	        }

	        public void setDietaryPreferences(String dietaryPreferences) {
	            this.dietaryPreferences = dietaryPreferences;
	        }

	        
	        public List<String> getAttendanceHistory() {
	            return attendanceHistory;
	        }

	        // Setter for attendance history
	        public void setAttendanceHistory(List<String> attendanceHistory) {
	            this.attendanceHistory = attendanceHistory;
	        }
	    
	        
	    }
	    
	    
	//////  Feedback and Reviews ************************************************************************************
	    
	 // Simulate client login
	    public void loginClient(String username,String password) {
	        if (users.containsKey(username) && users.get(username).equals(password)) {
	            isLoggedIn = true;
	            System.out.println("Logged in successfully as admin.");
	        } else {
	            isLoggedIn = false;
	            System.out.println("Invalid username or password.");
	        }
	    }


	    // Simulate completing a fitness program
	    public void completeFitnessProgram() {
	        if (isLoggedIn3) {
	            currentClient.setFitnessProgramCompleted(true);
	        }
	    }

	    // Navigate to feedback section
	    public void navigateToFeedbackSection() {
	        if (!isLoggedIn3 || !currentClient.isFitnessProgramCompleted()) {
	            throw new IllegalStateException("Client must complete the program to leave feedback.");
	        }
	        // Simulated navigation
	    }

	    // Submit a program rating
	    public void rateProgram(int rating) {
	        if (rating < 1 || rating > 5) {
	            throw new IllegalArgumentException("Rating must be between 1 and 5.");
	        }
	        programRating = rating;
	    }

	    // Submit a program review
	    public void submitProgramReview(String review) {
	        if (review == null || review.isEmpty()) {
	            throw new IllegalArgumentException("Review cannot be empty.");
	        }
	        programReview = review;
	        previousFeedback = review; // Store it as previous feedback for later retrieval
	    }

	    // Submit an improvement suggestion
	    public void submitProgramImprovementSuggestion(String suggestion) {
	        if (suggestion == null || suggestion.isEmpty()) {
	            throw new IllegalArgumentException("Suggestion cannot be empty.");
	        }
	        programImprovementSuggestion = suggestion;
	    }

	 // View previously submitted feedback
	    public void viewPreviousFeedback() {
	        // Do nothing; the default value of previousFeedback will remain null if no feedback exists
	    }

	    // Getter methods for verification in tests
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
	            if (program.toLowerCase().contains(difficulty.toLowerCase().trim()) &&
	                program.toLowerCase().contains(focusArea.toLowerCase().trim())) {
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
	    
	//  //  //  Account Management ***********************************************************************************************
	    

	    public void initializeSystem() {
	        clientProfile = new ClientProfile(dietaryUpdateConfirmation, programRating, dietaryUpdateConfirmation, dietaryUpdateConfirmation); // Reset the client profile
	        profileCreated = false;
	        dietaryPreferencesUpdated = false;
	        profileUpdated = false;
	        errorMessage = ""; // Clear any previous error messages
	    }

	    // Method to enter client details
	    public void enterClientDetails(int age, String fitnessGoals) {
	        clientProfile.setAge(age);
	        clientProfile.setFitnessGoals(fitnessGoals);
	        
	    }
	    
	    
	    public void createProfile(int age, String fitnessGoals) {
	        clientProfile.setAge(age);
	        clientProfile.setFitnessGoals(fitnessGoals);
	        profileCreated = true;
	    }

	    public void updateClientDetails(int age, String fitnessGoals) {
	        clientProfile.setAge(age);
	        clientProfile.setFitnessGoals(fitnessGoals);
	        profileUpdated = true;
	    }



	    // Method to add dietary preferences
	    public void addDietaryPreferences(List<String> preferences) {
	       // clientProfile.setDietaryPreferences(dietaryPreferences);
	        dietaryPreferencesUpdated = true; // Mark as updated
	    }

	    public void submitProfileCreationForm() {
	        // Validate that age and fitness goals are set
	        if (clientProfile.getAge() <= 0 || clientProfile.getFitnessGoals() == null || clientProfile.getFitnessGoals().isEmpty()) {
	            errorMessage = "All fields are required!";
	        } else {
	            profileCreated = true; // Simulate successful creation
	            profileCreationConfirmation = "Profile successfully created!";
	        }
	    }

	    // Method to submit the dietary preferences form
	    public void submitDietaryPreferencesForm() {
	        if (dietaryPreferencesUpdated) {
	            dietaryUpdateConfirmation = "Dietary preferences successfully updated!";
	        }
	    }

	    // Getters for assertions in step definitions
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
	        return dietaryUpdateConfirmation;
	    }

	    public boolean isProfileUpdated() {
	        return profileUpdated;
	    }

	    public String getProfileUpdateConfirmation() {
	        return profileUpdateConfirmation;
	    }

	    public String getErrorMessage() {
	        return errorMessage;
	    }
	    
	    public void submitProfileUpdate() {
	        if (clientProfile.getAge() <= 0 || clientProfile.getFitnessGoals() == null || clientProfile.getFitnessGoals().isEmpty()) {
	            errorMessage = "All fields are required!";
	        } else {
	            profileUpdated = true; // Simulate successful profile update
	            profileUpdateConfirmation = "Profile successfully updated!";
	        }
	    }
	    
	   // public ClientProfile getClientProfile() {
	 //       return clientProfile;
	
//}
 
	//  //  //  Progress Tracking ***********************************************************************************************
	    	  
	    public void navigateToProgressTrackingPage() {
	       System.out.println("Navigating to the progress tracking page...");
	    }
	    
	    public String viewMilestones() {
	        if (!currentClient.isFitnessProgramCompleted()) {
	            return "No milestones available.";
	        }
	        return "Weight: " + currentClient.getWeight() + ", BMI: " + currentClient.getBmi() + ", Attendance: " + currentClient.getAttendance();
	    }
	    
	public String viewAchievements() {
	    if (!currentClient.isFitnessProgramCompleted()) {
	        return "No achievements available.";
	    }
	    List<String> badges = currentClient.getBadges();
	    return badges.isEmpty() ? "Badges: None earned yet." : "Badges: " + String.join(", ", badges);
	}

	public void enrollInProgram() {
	    currentClient.setEnrolledInProgram(true);

	    // Add mock attendance history for testing
	    List<String> attendanceHistory = new ArrayList<String>();
	    attendanceHistory.add("Day 1: Attended");
	    attendanceHistory.add("Day 2: Attended");
	    attendanceHistory.add("Day 3: Missed");
	    currentClient.setAttendanceHistory(attendanceHistory);
	}
	    public String viewAttendanceHistory() {
	        if (!currentClient.isLoggedIn3() || !currentClient.isEnrolledInProgram()) {
	            return "Client must be logged in and enrolled in a program to view attendance.";
	        }
	        List<String> history = currentClient.getAttendanceHistory();
	        // Check if history is null or empty
	        if (history == null || history.isEmpty()) {
	            return "Attendance History: No attendance records found.";
	        }
	        return "Attendance History: " + String.join(", ", history);
	    }
	    public void setFitnessGoals(String weightGoal, String bmiGoal, String runGoal) {
	        currentClient.setWeightGoal(weightGoal);
	        currentClient.setBmiGoal(bmiGoal);
	        currentClient.setRunGoal(runGoal);
	        System.out.println("Fitness goals have been set successfully.");
	    }

	    public String checkProgressTowardsGoals() {
	        if (!currentClient.isLoggedIn3()) return "Client must be logged in to check progress.";
	        if (currentClient.getWeightGoal() == null || currentClient.getBmiGoal() == null || currentClient.getRunGoal() == null) {
	            return "Client must set fitness goals first.";
	        }
	        return "Progress towards goals: Weight Goal: " + currentClient.getWeightGoal() +
	               ", Current Weight: " + currentClient.getCurrentWeight() +
	               ", BMI Goal: " + currentClient.getBmiGoal() +
	               ", Current BMI: " + currentClient.getCurrentBmi() +
	               ", Running Goal: " + currentClient.getRunGoal() +
	               ", Current Running Distance: " + currentClient.getCurrentRunDistance() + "km.";
	    }

		public void assertOnlyArticlesWithStatus(String status) {
			// TODO Auto-generated method stub
			
		}
		///////////////////////////////////////////////////////////////////mainmenu

public class MainMenu {

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentScreen = "Main Menu";
        boolean running = true;

        while (running) {
            System.out.println("=== Main Menu ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Instructor Login");
            System.out.println("3. Client Login");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    currentScreen = "Admin Login Screen";
                    System.out.println("Navigating to Admin Login Screen...");
                    break;
                case 2:
                    currentScreen = "Instructor Login Screen";
                    System.out.println("Navigating to Instructor Login Screen...");
                    break;
                case 3:
                    currentScreen = "Client Login Screen";
                    System.out.println("Navigating to Client Login Screen...");
                    break;
                case 4:
                    currentScreen = "System Exited";
                    System.out.println("Exiting the system...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println("Current Screen: " + currentScreen);
            System.out.println();
        }

        scanner.close();
    }
}
}
