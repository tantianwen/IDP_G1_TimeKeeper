package com.example.istime.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.istime.MenuItemListActivity;
import com.example.istime.R;

public class Profile2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile2);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Button dailyNotificationButton= (Button) findViewById(R.id.add_daily_notification);
		dailyNotificationButton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	Intent i = new Intent(Profile2.this, DailyNotification.class);
		    	 startActivity(i);
		    }
		});
		
		Button weeklyNotificationButton= (Button) findViewById(R.id.add_weekly_notifications);
		weeklyNotificationButton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	Intent i = new Intent(Profile2.this, WeeklyNotification.class);
		    	 startActivity(i);
		    }
		});
		
		ImageButton navigation_button= (ImageButton) findViewById(R.id.navigation_left);
		navigation_button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	Intent i = new Intent(Profile2.this, Profile1.class);
		    	 startActivity(i);
		    }
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile2, menu);
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
