package com.example.istime.calendar;

public class Event {
	
	String event;
	String date;
	String category;
	int fromHour;
	int fromMinute;
	int toHour;
	int toMinute;
	String eventStartTime;
	String eventEndTime;
	
	public Event(String event, String date, String category, int fromHour, int fromMinute, int toHour, int toMinute) {
		this.event = event;
		this.date = date;
		this.category = category;
		this.fromHour = fromHour;
		this.fromMinute = fromMinute;
		this.toHour = toHour;
		this.toMinute = toMinute;
	}
	
	public Event(String event, String date, String category, String eventStartTime, String eventEndTime) {
		this.event = event;
		this.date = date;
		this.category = category;
		this.fromHour = fromHour;
		this.fromMinute = fromMinute;
		this.eventStartTime = eventStartTime;
		this.eventEndTime = eventEndTime;
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

	public int getFromHour() {
		return fromHour;
	}

	public void setFromHour(int fromHour) {
		this.fromHour = fromHour;
	}

	public int getFromMinute() {
		return fromMinute;
	}

	public void setFromMinute(int fromMinute) {
		this.fromMinute = fromMinute;
	}

	public int getToHour() {
		return toHour;
	}

	public void setToHour(int toHour) {
		this.toHour = toHour;
	}

	public int getToMinute() {
		return toMinute;
	}

	public void setToMinute(int toMinute) {
		this.toMinute = toMinute;
	}


	
	
}
