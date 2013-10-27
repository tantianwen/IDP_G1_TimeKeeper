package com.example.istime.calendar;

import java.util.ArrayList;

import com.example.istime.R;
import com.example.istime.R.color;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CalendarDayView extends ListActivity {
	
	public final static String EXTRA_DATE="";
	public final static String EXTRA_DATETIME="";
	public String selectedDate="";
	ArrayStorage storage = new ArrayStorage();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Intent intent = getIntent();
		selectedDate = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
		getActionBar().setTitle(selectedDate);
 
		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_calendar_day_view, storage.getTimeArray()));
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);

	 }

	
    @Override 
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Do something when a list item is clicked
    	String selectedTime;
 
    	if(position%2==0) {
    		 selectedTime = (String) getListAdapter().getItem(position)+":00";
    	} else {
    		 selectedTime = (String) getListAdapter().getItem(position-1)+":30";
    	}
    	
    	redirect(selectedTime, selectedDate);
    }
    
    public void redirect(String selectedTime, String selectedDate) {
    	
		Intent intentRedirect = new Intent(this, NewCalendarEvent.class);
		ArrayList<String> dateTimeArray = new ArrayList<String>();
		dateTimeArray.add(selectedTime);
		dateTimeArray.add(selectedDate);
		intentRedirect.putExtra(EXTRA_DATETIME, dateTimeArray);
		startActivity(intentRedirect);
		finish();
		
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar_dayview, menu);
		return true;
	}
}
