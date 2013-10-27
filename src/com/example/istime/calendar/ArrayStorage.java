package com.example.istime.calendar;

import java.util.ArrayList;

public class ArrayStorage {

	public static ArrayList<String> timeArray = new ArrayList<String>();
	public static ArrayList<Event> eventArray = new ArrayList<Event>();
	public static ArrayList<String> categoryArray = new ArrayList<String>();
	public static ArrayList<String> newTimeArray = new ArrayList<String>();

	public ArrayStorage() {
		aNewTimeArray();
		if(timeArray.size()==0) {
			timeArray.add("12");
			timeArray.add(" ");
			timeArray.add("1");
			timeArray.add(" ");
			timeArray.add("2");
			timeArray.add(" ");
			timeArray.add("3");
			timeArray.add(" ");
			timeArray.add("4");
			timeArray.add(" ");
			timeArray.add("5");
			timeArray.add(" ");
			timeArray.add("6");
			timeArray.add(" ");
			timeArray.add("7");
			timeArray.add(" ");
			timeArray.add("8");
			timeArray.add(" ");
			timeArray.add("9");
			timeArray.add(" ");
			timeArray.add("10");
			timeArray.add(" ");
			timeArray.add("11");
			timeArray.add(" ");
			timeArray.add("12");
			timeArray.add(" ");
			timeArray.add("13");
			timeArray.add(" ");
			timeArray.add("14");
			timeArray.add(" ");
			timeArray.add("15");
			timeArray.add(" ");
			timeArray.add("16");
			timeArray.add(" ");
			timeArray.add("17");
			timeArray.add(" ");
			timeArray.add("18");
			timeArray.add(" ");
			timeArray.add("19");
			timeArray.add(" ");
			timeArray.add("20");
			timeArray.add(" ");
			timeArray.add("21");
			timeArray.add(" ");
			timeArray.add("22");
			timeArray.add(" ");
			timeArray.add("23");
			timeArray.add(" ");
		}
	}
	
	public void aNewTimeArray() {
		newTimeArray.add("12");
		newTimeArray.add(" ");
		newTimeArray.add("1");
		newTimeArray.add(" ");
		newTimeArray.add("2");
		newTimeArray.add(" ");
		newTimeArray.add("3");
		newTimeArray.add(" ");
		newTimeArray.add("4");
		newTimeArray.add(" ");
		newTimeArray.add("5");
		newTimeArray.add(" ");
		newTimeArray.add("6");
		newTimeArray.add(" ");
		newTimeArray.add("7");
		newTimeArray.add(" ");
		newTimeArray.add("8");
		newTimeArray.add(" ");
		newTimeArray.add("9");
		newTimeArray.add(" ");
		newTimeArray.add("10");
		newTimeArray.add(" ");
		newTimeArray.add("11");
		newTimeArray.add(" ");
		newTimeArray.add("12");
		newTimeArray.add(" ");
		newTimeArray.add("13");
		newTimeArray.add(" ");
		newTimeArray.add("14");
		newTimeArray.add(" ");
		newTimeArray.add("15");
		newTimeArray.add(" ");
		newTimeArray.add("16");
		newTimeArray.add(" ");
		newTimeArray.add("17");
		newTimeArray.add(" ");
		newTimeArray.add("18");
		newTimeArray.add(" ");
		newTimeArray.add("19");
		newTimeArray.add(" ");
		newTimeArray.add("20");
		newTimeArray.add(" ");
		newTimeArray.add("21");
		newTimeArray.add(" ");
		newTimeArray.add("22");
		newTimeArray.add(" ");
		newTimeArray.add("23");
		newTimeArray.add(" ");
	}
	
	public void emptyTimeArray() {
		timeArray.clear();
		timeArray.add("12");
		timeArray.add(" ");
		timeArray.add("1");
		timeArray.add(" ");
		timeArray.add("2");
		timeArray.add(" ");
		timeArray.add("3");
		timeArray.add(" ");
		timeArray.add("4");
		timeArray.add(" ");
		timeArray.add("5");
		timeArray.add(" ");
		timeArray.add("6");
		timeArray.add(" ");
		timeArray.add("7");
		timeArray.add(" ");
		timeArray.add("8");
		timeArray.add(" ");
		timeArray.add("9");
		timeArray.add(" ");
		timeArray.add("10");
		timeArray.add(" ");
		timeArray.add("11");
		timeArray.add(" ");
		timeArray.add("12");
		timeArray.add(" ");
		timeArray.add("13");
		timeArray.add(" ");
		timeArray.add("14");
		timeArray.add(" ");
		timeArray.add("15");
		timeArray.add(" ");
		timeArray.add("16");
		timeArray.add(" ");
		timeArray.add("17");
		timeArray.add(" ");
		timeArray.add("18");
		timeArray.add(" ");
		timeArray.add("19");
		timeArray.add(" ");
		timeArray.add("20");
		timeArray.add(" ");
		timeArray.add("21");
		timeArray.add(" ");
		timeArray.add("22");
		timeArray.add(" ");
		timeArray.add("23");
		timeArray.add(" ");
		
	}
	
	public ArrayList<String> getTimeArray() {
		return timeArray;
	}
	
	public void addEvent(Event anEvent) {
		eventArray.add(anEvent);
	}
	
	public ArrayList<Event> getEventArray() {
		return eventArray;
	}
	
	public ArrayList<String> getCategoryArray() {
		if(categoryArray.size()== 0) {
			categoryArray.add("Work");
			categoryArray.add("Family");
			categoryArray.add("Friends");
		} 
		
		return categoryArray;
	}
	
	public ArrayList<String> newTimeArray() {
		return newTimeArray;
	}
}
