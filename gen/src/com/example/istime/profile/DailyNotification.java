package com.example.istime.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.istime.R;

public class DailyNotification extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daily_notification);
		
		Button cancel_button= (Button) findViewById(R.id.daily_notification_cancel);
		cancel_button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	Intent i = new Intent(DailyNotification.this, Profile2.class);
		    	 startActivity(i);
		    }
		});
	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.daily_notification, menu);
		return true;
	}

}
