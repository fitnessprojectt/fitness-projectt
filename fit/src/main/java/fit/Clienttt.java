package fit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;   

public class Clienttt { 
	private ClientProfile clientProfile;
	    private boolean profileCreated;
	    private boolean dietaryPreferencesUpdated;
	    private String errorMessage = "";
	    private String profileCreationConfirmation = "";
	    private String profileUpdateConfirmation = "";
	    private Scanner scanner;
	    private String username;
	    private String password;
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
	    
	    private String selectedProgram;
	    private boolean isProgramEnrolled = false;
	    private String programSchedule;
	    private Client currentClient;
	    private boolean isLoggedIn = false;
	    private String programReview = "";
	    private String previousFeedback = "";
	    private String programImprovementSuggestion = "";
	    private int programRating = 0;
	    private boolean profileUpdated;
	    private String dietaryUpdateConfirmation;
	    
	    
	    
	  
	      
	    
	    public Clienttt() {
	    	
	        this.clientProfile = new ClientProfile();
	        this.scanner = new Scanner(System.in);
	  
	    }
	    
	   
	       
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
	    	//if (this.currentClient == null) {
	    	  //  throw new IllegalStateException("No client is currently logged in.");
	    	//}
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

	    
	    private List<String> dietaryPreferences;
		private String weight;
		private String bmi;
		private String attendance;
		private Object authenticatedUser; 

	    public void addDietaryPreference(String dietaryPreference) {
	        
	        if (dietaryPreferences == null) {
	            dietaryPreferences = new ArrayList<String>();
	        }
	        
	        
	        dietaryPreferences.add(dietaryPreference);

	       
	        System.out.println("Dietary Preference added: " + dietaryPreference);
	        
	        
	        dietaryPreferencesUpdated = true;
	    }

		public String getProfileDetails() {
			return null;
		}
		private static Map<String, String> accounts= new HashMap<>();

		
		public void loginClient(String username, String password) {
		    if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
		        throw new RuntimeException("Username or password cannot be null or empty.");
		    }

		    // Simulate login validation
		    if ("validUsername".equals(username) && "validPassword".equals(password)) {
		        this.isLoggedIn = true;
		    } else {
		        this.isLoggedIn = false;
		        throw new RuntimeException("Invalid credentials.");
		    }
		}
		public String viewProgress() {
	        return "Weight: " + weight + ", BMI: " + bmi + ", Attendance: " + attendance;
		}
		
		public boolean isLoggedIn() {
			// TODO Auto-generated method stub
			return authenticatedUser !=null;
		}
}
