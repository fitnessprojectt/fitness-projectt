package fit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Instructor {
	
	
	class Program {
	    private String title;
	    private String duration;
	    private String difficulty;
	    private String goals;
	    private List<String> media;
	    private double price;
	    private List<String> schedule;
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
	        public void setSchedule(List<String> schedule) { this.schedule = schedule; }
	        
	}

	

		public void runApplication() {
	        System.out.println("MyApplication is running!");
	    }

		    
		public Instructor() {
	       // clientMessages = new HashMap<>();
	       // clientReports1 = new HashMap<>();  
	        instructors.put("israa", "soso123");
	        clientStartedPrograms.put("client1", "Yoga Basics");
	        markSessionAsCompleted("client1", "Yoga Basics", true); 
	        
	        clientStartedPrograms.put("client2", "Advanced Cardio");
	        markSessionAsCompleted("client2", "Advanced Cardio", false); 

	        
	        sendMessageToClient("client1", "Welcome to the fitness program!");
	        sendMessageToClient("client1", "Your next session is scheduled for tomorrow.");

	        provideFeedbackToClient("client1", "Great progress, keep it up!");

	        viewMessagesForClient("client1","report");

	    }
		

	    private Map<String, String> instructors = new HashMap<>();
	    private Map<String, Program> programs = new HashMap<>();
	    public Map<String, String> clientMessages = new HashMap<>();
	    private Map<String, String> clientProgress = new HashMap<>();

	    private Map<String, String> clientReports1 = new HashMap<>();
	    private Map<String, String> clients = new HashMap<>();

	    private Map<String, List<String>> clientAttendedSessions = new HashMap<>();
	    private Map<String, List<String>> clientScheduledSessions = new HashMap<>();

	    private Map<String, String> clientStartedPrograms = new HashMap<>();
	    private Map<String, String> clientCompletedPrograms = new HashMap<>();
	    
	    
	    private boolean isLoggedIn2 = false;
	    private Program currentProgram;

		
	    private HashMap<String, String> admins = new HashMap<>();
		private List<String> schedule;
		private double price;
		private List<String> media;
		private String goals;
		private String difficulty;
		private String duration;
		private String title;
		private Object programName;
		
		public boolean loginAsInstructor(String username, String password) {
		    System.out.println("Attempting login with username: " + username + " and password: " + password);
		    
		    if (username == null || password == null) {
		        throw new RuntimeException("Username or password cannot be null.");
		    }
		    if (!instructors.containsKey(username)) {
		        System.out.println("Login failed: Username not found.");
		        return false;
		    }
		    if (!instructors.get(username).equals(password)) {
		        System.out.println("Login failed: Incorrect password.");
		        return false;
		    }
		    isLoggedIn2 = true;
		    System.out.println("Logged in successfully as instructor.");
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

	    public void iNavigateToThePage(String pageName) {
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
	            // استبدال الرسالة القديمة بالرسالة الجديدة (الرد)
	            String originalMessage = clientMessages.get(clientName);
	            String updatedMessage = originalMessage + " | Reply: " + replyMessage;
	            clientMessages.put(clientName, updatedMessage);
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
	            // دمج الرسالة التحفيزية مع الرسالة الحالية
	            String existingMessage = clientMessages.get(clientName);
	            String updatedMessage = existingMessage + " | Motivational Message: " + message;
	            clientMessages.put(clientName, updatedMessage);
	            System.out.println("Motivational message sent to client " + clientName);
	        } else {
	            // إذا لم تكن هناك رسائل حالية، أضف الرسالة التحفيزية
	            clientMessages.put(clientName, "Motivational Message: " + message);
	            System.out.println("First motivational message sent to client " + clientName);
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
	            if (clientMessages.containsKey(clientName)) {
	                // دمج الرسالة الجديدة مع الرسائل السابقة
	                String existingMessages = clientMessages.get(clientName);
	                String updatedMessages = existingMessages + " | New Message: " + message;
	                clientMessages.put(clientName, updatedMessages);
	            } else {
	                // إنشاء رسالة جديدة إذا لم تكن موجودة مسبقًا
	                clientMessages.put(clientName, "New Message: " + message);
	            }
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
    } else {
        System.out.println("Valid schedule: " + schedule);
    }

	Program newProgram = new Program(title, duration, difficulty, goals, media, price, schedule);
	programs.put(title, newProgram);

	System.out.println("\nProgram Created Successfully!");
	newProgram.displayDetails();
	return true;
	}
	}

		private static List<String> validateScheduleInput(String scheduleInput) {
	        List<String> validSchedule = new ArrayList<>();
	        // تعريف SimpleDateFormat داخل الفنكشن
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        dateFormat.setLenient(false);  // تعطيل المعالجة المترخية

	        String[] dateTimeEntries = scheduleInput.split(",");

	        for (String entry : dateTimeEntries) {
	            entry = entry.trim();  // إزالة الفراغات الزائدة
	            try {
	                // محاولة تحليل التاريخ باستخدام SimpleDateFormat
	                dateFormat.parse(entry);  // محاولة تحليل الإدخال
	                validSchedule.add(entry);  // إضافة التاريخ إلى القائمة إذا كان صالحًا
	            } catch (ParseException e) {
	                // إذا فشل التحليل، يتم العودة بقيمة null
	                return null;
	            }
	        }

	        return validSchedule;
		}
		
		public boolean sendMessageToClient(String clientUsername, String message) {
		    if (clientUsername == null || clientUsername.isEmpty() || message == null || message.isEmpty()) {
		        return false; 
		    }

		    if (clientMessages.containsKey(clientUsername)) {
		        // دمج الرسالة الجديدة مع الرسالة السابقة
		        String existingMessage = clientMessages.get(clientUsername);
		        String updatedMessage = existingMessage + " | New Message: " + message;
		        clientMessages.put(clientUsername, updatedMessage);
		    } else {
		        // إضافة الرسالة الأولى إذا لم يكن هناك أي رسالة موجودة
		        clientMessages.put(clientUsername, "New Message: " + message);
		    }

		    System.out.println("Message sent to " + clientUsername + ": " + message);
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
		 
		 public boolean viewMessagesForClient(String clientUsername, String report) {
			    if (clientUsername == null || clientUsername.isEmpty()) {
			        return false; 
			    }

			    // عرض الرسائل
			    if (clientMessages.containsKey(clientUsername)) {
			        String messages = clientMessages.get(clientUsername);
			        if (messages != null && !messages.isEmpty()) {
			            System.out.println("Messages for " + clientUsername + ":");
			            System.out.println(messages);
			        } else {
			            System.out.println("No messages for " + clientUsername);
			        }
			    } else {
			        System.out.println("No messages for " + clientUsername);
			    }

			    // عرض التقرير إذا كان موجودًا
			    if (report != null && !report.isEmpty()) {
			        String clientReport = clientReports1.get(clientUsername);
			        if (clientReport != null && !clientReport.isEmpty()) {
			            System.out.println("Client Report: " + clientReport);
			        } else {
			            System.out.println("No report available for " + clientUsername);
			        }
			    }
			    return true;}
		 
		 public boolean sendMotivationalReminder(String clientUsername) {
			    // التحقق إذا كان العميل موجودًا
			    if (clientUsername == null || clientUsername.isEmpty() || !isClientExist(clientUsername)) {
			        System.out.println("Client does not exist.");
			        return false;
			    }

			    // الحصول على معدل إتمام العميل
			    double completionRate = getClientCompletionRate(clientUsername);
			    String reminderMessage;

			    // تحديد الرسالة بناءً على معدل الإتمام
			    if (completionRate < 50) {
			        reminderMessage = "Hey " + clientUsername + ", keep going! You can do it! Stay focused and keep pushing!";
			    } else {
			        reminderMessage = "Great job, " + clientUsername + "! You're doing amazing, keep up the excellent work!";
			    }

			    // إرسال الرسالة
			    return sendMessageToClient(clientUsername, reminderMessage);
			}
		 
		 public double getClientCompletionRate(String clientUsername) {
			// TODO Auto-generated method stub
			return 0;
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
		        // التحقق من صحة المدخلات
		        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
		            return false; // التأكد من أن الاسم وكلمة المرور غير فارغين
		        }

		        // التحقق إذا كان العميل مسجلًا بالفعل في الـ HashMap
		        if (!clientMessages.containsKey(username)) {
		            clientMessages.put(username, "");  // وضع قيمة فارغة أو رسالة افتراضية للمستخدم الجديد
		            clientCompletedPrograms.put(username, "");  // وضع قيمة فارغة للمستخدم الجديد
		            clientStartedPrograms.put(username, "");  // وضع قيمة فارغة للمستخدم الجديد
		            return true; // العميل تم تسجيله بنجاح
		        }
		        
		        return false;
		 }

		 
		 public boolean addProgramToClient(String clientUsername, String programTitle) {
		        if (clientStartedPrograms.containsKey(clientUsername)) {
		            String currentPrograms = clientStartedPrograms.get(clientUsername);
		            if (currentPrograms.isEmpty()) {
		                currentPrograms = programTitle;
		            } else {
		                currentPrograms += "," + programTitle; // إضافة البرنامج إلى القائمة المفصولة بفواصل
		            }
		            clientStartedPrograms.put(clientUsername, currentPrograms);
		            return true;
		        } else {
		            System.out.println("Client not found or not registered.");
		            return false;
		        }
		    }

		    // وضع علامة على البرنامج كمكتمل
		    public boolean markSessionAsCompleted(String clientUsername, String programTitle, boolean attended) {
		        if (clientCompletedPrograms.containsKey(clientUsername)) {
		            String currentCompletedPrograms = clientCompletedPrograms.get(clientUsername);
		            if (attended) {
		                if (currentCompletedPrograms.isEmpty()) {
		                    currentCompletedPrograms = programTitle;
		                } else {
		                    currentCompletedPrograms += "," + programTitle; // إضافة البرنامج إلى القائمة المفصولة بفواصل
		                }
		                clientCompletedPrograms.put(clientUsername, currentCompletedPrograms);
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
}
