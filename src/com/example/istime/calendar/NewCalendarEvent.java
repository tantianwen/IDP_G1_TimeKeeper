package com.example.istime.calendar;

import java.util.ArrayList;
import java.util.Calendar;

import com.example.istime.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class NewCalendarEvent extends Activity implements OnTimeChangedListener {

	private static final int TIME_PICKER_INTERVAL=30;
	private boolean mIgnoreEvent=false;
	TimePicker pickToTime;
	Spinner categorySpinner;
	ArrayStorage storage = new ArrayStorage();
	ArrayList<String> getSelectedDateTime = null;
	int selectedHour;
	int selectedMinute;
	public Button saveButton;
	String fromTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("here");
		super.onCreate(savedInstanceState);
		System.out.println("here");
		setContentView(R.layout.activity_new_calendar_event);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle("Add New Event");
				
		//Get data from CalendarDayView
		Intent getIntent = getIntent();
		getSelectedDateTime = getIntent.getStringArrayListExtra(CalendarDayView.EXTRA_DATETIME);
		((TextView)findViewById(R.id.selectedDate)).setText(getSelectedDateTime.get(1));
		((TextView)findViewById(R.id.fromTime)).setText(getSelectedDateTime.get(0));
		fromTime = getSelectedDateTime.get(0);
		
		//Configure the time picker
		pickToTime = (TimePicker)findViewById(R.id.ToTime);
		pickToTime.setIs24HourView(true);
		pickToTime.setOnTimeChangedListener(this);
		
		//Configure category spinner
		categorySpinner =(Spinner) findViewById(R.id.category);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, storage.getCategoryArray());
			dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
			categorySpinner.setAdapter(dataAdapter);
		}	
		   
		public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute){
	        if (mIgnoreEvent) {

	            return;
	        }
	        
	        if (minute%TIME_PICKER_INTERVAL!=0){
	            int minuteFloor=minute-(minute%TIME_PICKER_INTERVAL);
	            minute=minuteFloor + (minute==minuteFloor+1 ? TIME_PICKER_INTERVAL : 0);
	            if (minute==60)
	                minute=0;
	            mIgnoreEvent=true;
	            timePicker.setCurrentMinute(minute);
	            mIgnoreEvent=false;
	        }
	        
	  		selectedHour = hourOfDay;
	  		selectedMinute = minute;
	    }
	
	public void getAllEventData(){
		
		//Event Details
		EditText eventView = (EditText)findViewById(R.id.eventName);
		Editable getEventTitle =eventView.getText();
		String getEventTitleString = getEventTitle.toString();
		String endTime;
		if(selectedMinute < 10) {
			endTime = Integer.toString(selectedHour)+":0"+Integer.toString(selectedMinute);
		} else {
			endTime = Integer.toString(selectedHour)+":"+Integer.toString(selectedMinute);
		}
		
		Event newEvent = new Event(getEventTitleString,getSelectedDateTime.get(1),String.valueOf(categorySpinner.getSelectedItem()),
				getSelectedDateTime.get(0), endTime);
		storage.addEvent(newEvent);
	}
	
	public void saveEvent(View view) {
		
		if (validateEventTime(fromTime,selectedHour) == false) {
			//Do Nothing
			
		} else {
			
			getAllEventData();
			finish();
		}
	}
	
	public boolean validateEventTime(String startTime, int endTime) {
		System.out.println("Validating In");
		int detectColon = startTime.indexOf(":");
		System.out.println("Start Time is " + startTime);
		String getStartHour = startTime.substring(0,detectColon);
		System.out.println("Next: " + getStartHour);
		int startHourInt = Integer.parseInt(getStartHour);
		
		Context context = getApplicationContext();
		Toast toast = Toast.makeText(context, "You shouldn't be working after 7pm", 5);
		System.out.println("End time is: " + endTime);
		
		if((String.valueOf(categorySpinner.getSelectedItem()).equals("Work"))) {
			if ((startHourInt >= 19) || (endTime >=19)) {
				toast.show();
				return false;			
			}
		} 
		
		return true;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.new_calendar_event, menu);
		return true;
	}
}
