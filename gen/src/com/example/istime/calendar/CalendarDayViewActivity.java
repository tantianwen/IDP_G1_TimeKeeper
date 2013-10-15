package com.example.istime.calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.istime.MenuItemListActivity;
import com.example.istime.R;

public class CalendarDayViewActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar_day_view);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		//This is to retrieve the selected Date from MainActivity.java
		Intent getIntent = getIntent();
		String getSelectedDate = getIntent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
		
		TextView displayDate = new TextView(this);
		displayDate.setTextSize(40);
		displayDate.setText(getSelectedDate);
		setContentView(displayDate);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar_dayview, menu);
		return true;
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
