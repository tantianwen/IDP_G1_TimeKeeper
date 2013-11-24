package com.example.istime.calendar;

import java.util.ArrayList;
import java.util.Calendar;

import com.example.istime.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class AddActivity extends Activity {

	private Button FromDate;
	private Button ToDate;
	private Button FromTime;
	private Button ToTime;
	private int year;
	private int month;
	private int day;
	
	private int fromHour;
	private int fromMinute;
	
	private int toHour;
	private int toMinute;
	
	String eventDate;
	String eventName;
	
	ArrayList getSelectedDateTime = null;
	ArrayStorage storage = new ArrayStorage();
	String selectedDate;
	Spinner getSpinner;
	String[] selectedTime;
	
	static final int FROM_DATE_DIALOG_ID = 999;
	static final int From_TIME_DIALOG_ID = 998;
	static  final int TO_DATE_DIALOG_ID = 997;
	static final int TO_TIME_DIALOG_ID = 996;

	EditText getEventName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_add);
		addListenerOnButton();
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle("Add New Event");
		
		Intent getIntent = getIntent();
		getSelectedDateTime = getIntent.getStringArrayListExtra(CalendarDayView.EXTRA_DATETIME);

		FromDate = (Button)findViewById(R.id.FromDate);
		FromTime = (Button)findViewById(R.id.FromTime);
		ToDate = (Button)findViewById(R.id.ToDate);
		ToTime = (Button)findViewById(R.id.ToTimeButton);
				
		//Event Details
		getEventName = (EditText)findViewById(R.id.eventName);
		
		String getSelectTime = (String) getSelectedDateTime.get(0);
		String getSelectDate = (String) getSelectedDateTime.get(1);
		
		FromDate.setText((CharSequence) getSelectDate);
		ToDate.setText((CharSequence) getSelectDate);	
		
		selectedTime = getSelectTime.split(":");
		
		int getHour = Integer.parseInt(selectedTime[0]);
		int getMin = Integer.parseInt(selectedTime[1]);
		System.out.println("Time is: " + getMin + " " + getHour);
		String timeIs = timeToStringConversion(getHour,getMin);
		System.out.println("Time is 2: " + timeIs);
		FromTime.setText((CharSequence)timeIs);
		
		//Configure the spinner
		getSpinner = (Spinner)findViewById(R.id.category);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, storage.getCategoryArray());
		dataAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		getSpinner.setAdapter(dataAdapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.add_activity2, menu);
		return true;
	}
	
	public void addListenerOnButton() {
		
		FromDate = (Button)findViewById(R.id.FromDate);
		FromTime = (Button)findViewById(R.id.FromTime);
		ToDate = (Button)findViewById(R.id.ToDate);
		ToTime = (Button)findViewById(R.id.ToTimeButton);
 
		FromDate.setOnClickListener(new OnClickListener() {
 
			public void onClick(View v) {
 
				showDialog(FROM_DATE_DIALOG_ID);
 
			}
		});
		
	  FromTime.setOnClickListener(new OnClickListener() {
		  	public void onClick(View v) {
		  		showDialog(From_TIME_DIALOG_ID);
		  	}
	  });

	  ToDate.setOnClickListener(new OnClickListener() {
		  	public void onClick(View v) {
		  		showDialog(TO_DATE_DIALOG_ID);
		  	}
	  });

	  ToTime.setOnClickListener(new OnClickListener() {
		  	public void onClick(View v) {
		  		showDialog(TO_TIME_DIALOG_ID);
		  	}
	  });	  
	  
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DAY_OF_MONTH);
		
		switch (id) {
		case FROM_DATE_DIALOG_ID:
		   // set date picker as current date
		   return new DatePickerDialog(this, fromDatePickerListener,year, month,day);
		
		case  From_TIME_DIALOG_ID:
		
			return new TimePickerDialog(this, fromTimePickerListener, fromHour, fromMinute,false);
		
		case TO_DATE_DIALOG_ID:
			return new DatePickerDialog(this,toDatePickerListener, year, month, day);
			
		case TO_TIME_DIALOG_ID:
			return new TimePickerDialog(this,toTimePickerListener, toHour, toMinute, false);
		}
		return null;
	}
	
	private DatePickerDialog.OnDateSetListener fromDatePickerListener 
    = new DatePickerDialog.OnDateSetListener() {
				
		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
						
			//year = selectedYear;
			//month = selectedMonth;
			//day = selectedDay;
			
			FromDate.setText(dateStringConversion(selectedDay,selectedMonth,selectedYear));
			eventDate = dateStringConversion(selectedDay,selectedMonth, selectedYear);			
		}
	};
	
	private DatePickerDialog.OnDateSetListener toDatePickerListener 
    = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
		//	year = selectedYear;
		//	month = selectedMonth;
		//	day = selectedDay;
			
			ToDate.setText(dateStringConversion(selectedMonth,selectedMonth,selectedYear));

		}
	};	
	
	private TimePickerDialog.OnTimeSetListener fromTimePickerListener = 
            new TimePickerDialog.OnTimeSetListener() {
		
		public void onTimeSet(TimePicker view, int selectedHour,
				int selectedMinute) {
			fromHour = selectedHour;
			fromMinute = selectedMinute;
			String selectedTime = timeToStringConversion(fromHour,fromMinute);
			
			FromTime.setText(selectedTime); 
		}
	};
	
	private TimePickerDialog.OnTimeSetListener toTimePickerListener = 
            new TimePickerDialog.OnTimeSetListener() {
		
		public void onTimeSet(TimePicker view, int selectedHour,
				int selectedMinute) {
			
			toHour = selectedHour;
			toMinute = selectedMinute;
			
			ToTime.setText(timeToStringConversion(toHour,toMinute));			 
		}
	};	
	
	public String timeToStringConversion(int hour, int min) {
		String hourInString=null;
		String minInString=null;
		String pmOrAm=null;
		
		switch(hour) {
		case(0):
			hourInString = "12";
 			pmOrAm = "AM";
 			break;
		case(1):
			hourInString = "1";
 			pmOrAm = "AM";
 			break;
		case(2):
			hourInString = "2";
 			pmOrAm = "AM";
 			break;
		case(3):
			hourInString = "3";
 			pmOrAm = "AM";
 			break;
		case(4):
			hourInString = "4";
 			pmOrAm = "AM";
 			break;
		case(5):
			hourInString = "5";
 			pmOrAm = "AM";	
 			break;
		case(6):
			hourInString = "6";
 			pmOrAm = "AM";
 			break;
		case(7):
			hourInString = "7";
 			pmOrAm = "AM";
 			break;
		case(8):
			hourInString = "8";
 			pmOrAm = "AM";
 			break;
		case(9):
			hourInString = "9";
 			pmOrAm = "AM";
 			break;
		case(10):
			hourInString = "10";
 			pmOrAm = "AM";
 			break;
		case(11):
			hourInString = "11";
 			pmOrAm = "AM";
 			break;
		case(12):
			hourInString = "12";
 			pmOrAm = "PM";
 			break;
		case(13):
			hourInString = "1";
 			pmOrAm = "PM"; 
 			break;
		case(14):
			hourInString = "2";
 			pmOrAm = "PM";
 			break;
		case(15):
			hourInString = "3";
 			pmOrAm = "PM"; 	
 			break;
		case(16):
			hourInString = "4";
 			pmOrAm = "PM";  
 			break;
		case(17):
			hourInString = "5";
 			pmOrAm = "PM";  
 			break;
		case(18):
			hourInString = "6";
 			pmOrAm = "PM";  
 			break;
		case(19):
			hourInString = "7";
 			pmOrAm = "PM";  
 			break;
		case(20):
			hourInString = "8";
 			pmOrAm = "PM";
 			break;
		case(21):
			hourInString = "9";
 			pmOrAm = "PM"; 
 			break;
		case(22):
			hourInString = "10";
 			pmOrAm = "PM";  
 			break;
		case(23):
			hourInString = "11";
 			pmOrAm = "PM"; 
 			break;
		}
		
		switch(min) {
		case(0):
			minInString = "00";
			break;
		case(30):
			minInString = "30";
			break;
		}
		
		return hourInString.concat(":").concat(minInString).concat(pmOrAm);
	}
	
	public String dateStringConversion(int day, int month, int year) {
		String monthInEnglish = null;
		
			switch(month) {
			case 1:
				monthInEnglish = "Jan";
				break;
			case 2:
				monthInEnglish = "Feb";
				break;
			case 3:
				monthInEnglish = "Mar";
				break;
			case 4:
				monthInEnglish = "Apr";
				break;
			case 5:
				monthInEnglish = "May";
				break;
			case 6:
				monthInEnglish = "Jun";
				break;
			case 7:
				monthInEnglish = "Jul";
				break;
			case 8:
				monthInEnglish = "Aug";
				break;
			case 9:
				monthInEnglish = "Sep";
				break;
			case 10:
				monthInEnglish = "Oct";
				break;
			case 11:
				monthInEnglish = "Nov";
				break;
			case 12:
				monthInEnglish = "Dec";
				break;
		}
			return day + " " + monthInEnglish + " " + year;
	}
	
	public void saveEvent(View view) {
		
		
			Editable getEventTitle = getEventName.getText();
			String eventName = getEventTitle.toString();
			String getCategory = (String) getSpinner.getSelectedItem();
			
			if(validateEventTime(fromHour, toHour)) {
				if(eventDate == null) {
					
					eventDate = (String)getSelectedDateTime.get(0);
				} 
				
				if(fromHour == 0) {
					fromHour =  Integer.parseInt(selectedTime[0]);
				}
				
				if(fromMinute == 0) {
					fromMinute = Integer.parseInt(selectedTime[1]);
				}
				storage.addEvent(new Event(eventName, eventDate, getCategory, fromHour, fromMinute, toHour, toMinute));
				
				finish();
		} else {
			//Do Nothing
		}
	}
	
	public boolean validateEventTime(int fromHourValidate, int toHourValidate) {
		
		Context context = getApplicationContext();
		Toast toast = Toast.makeText(context, "You shouldn't be working after 7pm", 5);
		
		if((String.valueOf(getSpinner.getSelectedItem()).equals("Work"))) {
			if ((fromHourValidate >= 19) || (toHourValidate >=19)) {
				toast.show();
				return false;			
			}
		}
		
		return true;
	}

}
