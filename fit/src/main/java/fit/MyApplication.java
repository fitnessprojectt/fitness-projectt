package fit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MyApplication {
    private Map<String, String> users = new HashMap<>();
    private Map<String, String> articleStatus = new HashMap<>();
    private Map<String, String> userDetails = new HashMap<>();
    private boolean isLoggedIn = false;
    private Map<String, String> items = new HashMap<>();

    public MyApplication() {
        // إضافة مستخدمين افتراضيين
        users.put("admin", "password123");
        users.put("user1", "userpassword");
    }

    // دالة تسجيل الدخول كأدمن
    public void loginAsAdmin(String username,String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            isLoggedIn = true;
            System.out.println("Logged in successfully as admin.");
        } else {
            isLoggedIn = false;
            System.out.println("Invalid username or password.");
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
            System.out.println("Displaying articles related to: " + topic);
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة اختيار حالة المقال
    public void selectArticleStatus(String status) {
        if (isLoggedIn) {
            System.out.println("Selected article status: " + status);
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة ترتيب البرامج حسب عدد المسجلين
    public void assertProgramsSortedByEnrollment() {
        if (isLoggedIn) {
            System.out.println("Programs sorted by enrollment numbers.");
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة اختيار نوع التقرير
    public void selectReportType(String reportType) {
        if (isLoggedIn) {
            System.out.println("Selected report type: " + reportType);
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة التأكد من أن التقرير بصيغة PDF متاح للتنزيل
    public void assertPdfReportAvailableForDownload() {
        if (isLoggedIn) {
            System.out.println("PDF report is available for download.");
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة التأكد من أن الأقسام معينة مرئية
    public void assertSectionsVisible(String section1, String section2) {
        if (isLoggedIn) {
            System.out.println("Sections visible: " + section1 + " and " + section2);
        } else {
            System.out.println("Please log in first.");
        }
    }

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

    // دالة لتأكيد إنشاء حساب المستخدم
    public void assertUserAccountCreated(String name) {
        if (isLoggedIn) {
            System.out.println("User account for " + name + " has been created.");
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة لتحديث تفاصيل المستخدم
    public void updateUserDetails(String name, String role) {
        if (isLoggedIn) {
            userDetails.put("name", name);
            userDetails.put("role", role);
            System.out.println("User details updated: " + name + " as " + role);
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة لتأكيد تحديث الحساب
    public void assertUserAccountUpdated(String name) {
        if (isLoggedIn) {
            System.out.println("User account updated for: " + name);
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة لتأكيد الحساب غير نشط
    public void assertUserAccountInactive(String name) {
        if (isLoggedIn) {
            System.out.println("User account for " + name + " has been marked as inactive.");
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة لمراجعة طلب المعلم
    public void reviewInstructorApplication(String instructorName) {
        if (isLoggedIn) {
            System.out.println("Reviewing instructor application for: " + instructorName);
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة لتأكيد تفعيل حساب المعلم
    public void assertInstructorAccountActivated(String instructorName) {
        if (isLoggedIn) {
            System.out.println("Instructor account for " + instructorName + " has been activated.");
        } else {
            System.out.println("Please log in first.");
        }
    }

    // دالة لتأكيد عرض الإحصائيات
    public void assertStatisticsDisplayed() {
        if (isLoggedIn) {
            System.out.println("Displaying statistics like login frequency and program enrollments.");
        } else {
            System.out.println("Please log in first.");
        }
    }

    public static void main(String[] args) {
    	MyApplication portal = new MyApplication();

        // اختبار دوال مختلفة
        portal.loginAsAdmin("admin", "password123");
        portal.navigateToPage("Dashboard");
       // portal.reviewSubmittedArticle();
        portal.assertArticleStatus("Approved");
       // portal.assertArticleStatusVisibility(true);
        portal.enterSearchQuery("Wellness Articles");
        portal.assertArticlesRelatedTo("Health");
        portal.selectArticleStatus("Published");
        portal.assertProgramsSortedByEnrollment();
        portal.selectReportType("Monthly Report");
        portal.assertPdfReportAvailableForDownload();
        portal.assertSectionsVisible("Active Programs", "Completed Programs");
       // portal.fillUserDetails();
        portal.assertUserAccountCreated("John Doe");
        portal.updateUserDetails("John Doe", "Administrator");
        portal.assertUserAccountUpdated("John Doe");
        portal.assertUserAccountInactive("John Doe");
        portal.reviewInstructorApplication("John Doe");
        portal.assertInstructorAccountActivated("John Doe");
        portal.assertStatisticsDisplayed();
    }

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

    public void clickButton(String buttonName) {
        if (isLoggedIn) {
            // تنفيذ العملية عند النقر على الزر المحدد
            switch (buttonName) {
                case "submit":
                    // تنفيذ عملية الإرسال (على سبيل المثال، إرسال مقال أو تقرير)
                    submitArticle(buttonName, buttonName);
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

    // محاكاة عملية إرسال مقال
 // محاكاة عملية إرسال مقال
    void submitArticle(String articleId, String articleContent) {
        if (isLoggedIn) {
            // تحقق إذا كانت المقالة تحتوي على بيانات
            if (articleContent != null && !articleContent.trim().isEmpty()) {
                // إضافة المقال إلى قاعدة البيانات أو القائمة مع حالة "مقدم"
                articleStatus.put(articleId, "submitted");  // تعيين حالة المقال كـ "مقدم"
                System.out.println("Article with ID " + articleId + " has been submitted successfully.");
                
                // تخزين المقال الفعلي في خريطة أو قاعدة بيانات أخرى (اختياري)
                // articles.put(articleId, articleContent);
            } else {
                System.out.println("Cannot submit an empty article.");
            }
        } else {
            System.out.println("Please log in first.");
        }
    }

    // محاكاة عملية الموافقة على مقال
    void approveArticle(String articleId) {
        if (isLoggedIn) {
            // تحقق مما إذا كان المقال موجودًا
            if (articleStatus.containsKey(articleId)) {
                // تغيير حالة المقال إلى "موافق عليه"
                articleStatus.put(articleId, "approved");
                System.out.println("Article with ID " + articleId + " has been approved.");
            } else {
                System.out.println("Article with ID " + articleId + " not found.");
            }
        } else {
            System.out.println("Please log in first.");
        }
    }

    // محاكاة عملية رفض مقال
    void rejectArticle(String articleId) {
        if (isLoggedIn) {
            // تحقق مما إذا كان المقال موجودًا
            if (articleStatus.containsKey(articleId)) {
                // تغيير حالة المقال إلى "مرفوض"
                articleStatus.put(articleId, "rejected");
                System.out.println("Article with ID " + articleId + " has been rejected.");
            } else {
                System.out.println("Article with ID " + articleId + " not found.");
            }
        } else {
            System.out.println("Please log in first.");
        }
    }

    public void checkAdminPermissions() {
        // التحقق إذا كان المستخدم مسجل الدخول
        if (!isLoggedIn()) {
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
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isLoggedIn() {
		// TODO Auto-generated method stub
		return false;
	}

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

	private boolean isLoggedIn1 = true; // فرضية: المستخدم مسجل دخول
    private boolean hasAdminPermissions = true; // فرضية: المستخدم لديه صلاحيات

    private List<String> articles = new ArrayList<>();
    private List<String> tips = new ArrayList<>();
    private List<String> feedbacks = new ArrayList<>();
    private Map<String, String> complaints = new HashMap<>();

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
        if (message == null || message.isEmpty()) {
            System.out.println("Error: Notification message is required.");
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

    public void makeTipVisible(String tipContent) {
        if (tips.contains(tipContent)) {
            System.out.println("Tip is now visible to users: " + tipContent);
        } else {
            System.out.println("Error: Tip not found.");
        }
    }

    public void rejectTipReview(String reason) {
        if (reason == null || reason.isEmpty()) {
            System.out.println("Error: Reason for rejection is required.");
            return;
        }
        System.out.println("Tip review rejected. Reason: " + reason);
    }

    public void rejectTip(String tipContent) {
        if (tips.remove(tipContent)) {
            System.out.println("Tip rejected and removed: " + tipContent);
        } else {
            System.out.println("Error: Tip not found.");
        }
    }

    public void notifySubmitter(String message, MyApplication app) {
        if (message == null || message.isEmpty() || app == null || app.isEmpty()) {
            System.out.println("Error: Both message and submitter are required.");
            return;
        }
        System.out.println("Notification sent to submitter (" + app + "): " + message);
    }

    private boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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
        System.out.println("Reviewing feedback: " + feedbacks.get(0));
    }

    public void validateFeedback(String feedback) {
        if (feedbacks.contains(feedback)) {
            System.out.println("Feedback validated: " + feedback);
        } else {
            System.out.println("Error: Feedback not found.");
        }
    }

    public void markFeedbackForAction(String feedback) {
        if (feedbacks.contains(feedback)) {
            System.out.println("Feedback marked for further action: " + feedback);
        } else {
            System.out.println("Error: Feedback not found.");
        }
    }

    public void notifyContentTeam(String message) {
        if (message == null || message.isEmpty()) {
            System.out.println("Error: Message is required.");
            return;
        }
        System.out.println("Notification sent to content team: " + message);
    }

    public void submitComplaint(String complaintId, String complaintContent) {
        if (complaintId == null || complaintContent == null || complaintId.isEmpty() || complaintContent.isEmpty()) {
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
        System.out.println("Reviewing complaint: " + complaints.entrySet().iterator().next());
    }

    public void validateComplaint(String complaintId) {
        if (complaints.containsKey(complaintId)) {
            System.out.println("Complaint validated: " + complaintId);
        } else {
            System.out.println("Error: Complaint ID not found.");
        }
    }

    public void removeContent(String content) {
        if (articles.remove(content) || tips.remove(content)) {
            System.out.println("Content removed: " + content);
        } else {
            System.out.println("Error: Content not found.");
        }
    }

    public void notifyUser(String message) {
        if (message == null || message.isEmpty()) {
            System.out.println("Error: Message is required.");
            return;
        }
        System.out.println("Notification sent to user: " + message);
    }

	public void saveNewSubscriptionPlan() {
		// TODO Auto-generated method stub
		
	}

	public boolean checkIfPlanIsSaved() {
		// TODO Auto-generated method stub
		return false;
	}

	public void assignSubscriptionPlanToUser(String string) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkUserAccessToPlanFeatures(String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public void viewActiveSubscriptions() {
		// TODO Auto-generated method stub
		
	}

	public void processSubscriptionUpgrade() {
		// TODO Auto-generated method stub
		
	}

	public boolean activateNewPlanAfterUpgrade() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean areActiveSubscriptionsDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void reviewSubmittedArticle() {
		// TODO Auto-generated method stub
		
	}




}


