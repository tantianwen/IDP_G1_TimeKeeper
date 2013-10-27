package com.example.istime.calendar;

public class Event {
	
	String event;
	String date;
	String category;
	String eventStartTime;
	String eventEndTime;
	
	public Event(String event, String date, String category, String eventStartTime, String eventEndTime) {
		this.event = event;
		this.date = date;
		this.category = category;
		this.eventStartTime = eventStartTime;
		this.eventEndTime = eventEndTime;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public String getEventEndTime() {
		return eventEndTime;
	}

	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}
	
	
}
