package com.example.istime.calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;

import com.example.istime.MenuItemListActivity;
import com.example.istime.R;

public class CalendarActivity extends Activity {

		CalendarView cal; 
		static String selectedDate="";
		Intent directToDayView;
		public final static String EXTRA_MESSAGE="";
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		cal = (CalendarView) findViewById(R.id.calendarView1);
		
		cal.setOnDateChangeListener(new OnDateChangeListener() {
				
				@Override
				public void onSelectedDayChange(CalendarView view, int year, int month,
						int dayOfMonth) {
					// TODO Auto-generated method stub
					
					selectedDate = dayOfMonth+" : "+month+" : "+year;
					redirect(selectedDate);
				}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
		return true;
	}
	
	public void redirect(String selectedDate) {
		Intent intentRedirect = new Intent(this, CalendarDayViewActivity.class);
		intentRedirect.putExtra(EXTRA_MESSAGE, selectedDate);
		startActivity(intentRedirect);
		
	}
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
    	
    	switch (item.getItemId()) {
        case android.R.id.home:
			startActivity(new Intent(this, MenuItemListActivity.class));
			return true;	
    	}
    	return super.onOptionsItemSelected(item);
    }

}
