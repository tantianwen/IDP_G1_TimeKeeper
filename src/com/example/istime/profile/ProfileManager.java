package com.example.istime.profile;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfileManager {

	public static HashMap<String, Profile> profileInfo = new HashMap<String, Profile>();
	
	static {
		loadProfileInfo();
	}
	
	public static void loadProfileInfo() {
		
		String email = "testuser@gmail.com";
		String profileName = "Test User";
		HashMap<String, Double> categoryDetail = new HashMap<String,Double>();
		categoryDetail.put("Family", 30.0);
		categoryDetail.put("Friend", 10.0);
		ArrayList<String> workingDays = new ArrayList<String>();
		workingDays.add("Monday");
		workingDays.add("Tuesday");
		workingDays.add("Wednesday");
		workingDays.add("Thursday");
		workingDays.add("Friday");
		HashMap<String,ArrayList<Integer>> dailyTimeSchedule = new HashMap<String,ArrayList<Integer>>();
		ArrayList<Integer> tempArray1 = new ArrayList<Integer>();
		tempArray1.add(900);
		tempArray1.add(1800);
		ArrayList<Integer> tempArray2 = new ArrayList<Integer>();
		tempArray2.add(1200);
		tempArray2.add(1400);
		dailyTimeSchedule.put("Working Time",tempArray1);
		dailyTimeSchedule.put("Lunch Time",tempArray2);
		String dailyNotificationTime = "1900";
		
		Profile p = new Profile(email,profileName,categoryDetail,workingDays,dailyTimeSchedule,dailyNotificationTime,null);
		
		profileInfo.put(email,p);
		
	}
	
	public static void updateProfile(Profile profile){
		String email = profile.getEmail();
		profileInfo.put(email, profile);
	}
	
	public static Profile getProfile(String email){
		Profile p;
		p=profileInfo.get(email);
		return p;
	}
	
	
	public static class Profile {

		// email of the user
		public String email;
		// Name of the user
		public String profileName;
		// name of the category as well as hours spend
		public HashMap<String, Double> categoryDetail;
		// Users' working day in a week
		public ArrayList<String> workingDays;
		// Working time and lunch time
		public HashMap<String, ArrayList<Integer>> dailyTimeSchedule;
		// Integer storing the value of the time: 1400 or 1740 etc
		public String dailyNotificationTime;
		// Two values: day and time
		public ArrayList<String> weeklyNotificationTime;

		public Profile(String email, String profileName,
				HashMap<String, Double> categoryDetail,
				ArrayList<String> workingDays,
				HashMap<String, ArrayList<Integer>> dailyTimeSchedule,
				String dailyNotificationTime,
				ArrayList<String> weeklyNotificationTime) {

			this.email = email;
			this.profileName = profileName;
			this.categoryDetail = categoryDetail;
			this.workingDays = workingDays;
			this.dailyTimeSchedule = dailyTimeSchedule;
			this.dailyNotificationTime = dailyNotificationTime;
			this.weeklyNotificationTime = weeklyNotificationTime;

		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setProfileName(String profileName) {
			this.profileName = profileName;
		}

		public void setCategoryDetail(HashMap<String, Double> categoryDetail) {
			this.categoryDetail = categoryDetail;
		}

		public void setWorkingDays(ArrayList<String> workingDays) {
			this.workingDays = workingDays;
		}

		public void setDailyTimeSchedule(
				HashMap<String, ArrayList<Integer>> dailyTimeSchedule) {
			this.dailyTimeSchedule = dailyTimeSchedule;
		}

		public void setDailyNotificationTime(String dailyNotificationTime) {
			this.dailyNotificationTime = dailyNotificationTime;
		}

		public void setWeeklyNotificationTime(
				ArrayList<String> weeklyNotificationTime) {
			this.weeklyNotificationTime = weeklyNotificationTime;
		}

		public String getEmail() {
			return email;
		}

		public String getProfileName() {
			return profileName;
		}

		public HashMap<String, Double> getCategoryDetail() {
			return categoryDetail;
		}

		public ArrayList<String> getWorkingDays() {
			return workingDays;
		}

		public HashMap<String, ArrayList<Integer>> getDailyTimeSchedule() {
			return dailyTimeSchedule;
		}

		public String getDailyNotificationTime() {
			return dailyNotificationTime;
		}

		public ArrayList<String> getWeeklyNotificationTime() {
			return weeklyNotificationTime;
		}

	}
	
}
