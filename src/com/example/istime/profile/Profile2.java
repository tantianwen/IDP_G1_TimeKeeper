package com.example.istime.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TimePicker;

import com.example.istime.MainActivity;
import com.example.istime.MenuItemListActivity;
import com.example.istime.R;

public class Profile2 extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile2);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		/*Spinner spinner = (Spinner) findViewById(R.id.day_choice);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.days_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		spinner.setAdapter(adapter);*/



		/*
		 * Button weeklyNotificationButton= (Button)
		 * findViewById(R.id.add_weekly_notifications);
		 * weeklyNotificationButton.setOnClickListener(new
		 * View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { Intent i = new
		 * Intent(Profile2.this, WeeklyNotification.class); startActivity(i); }
		 * });
		 */

	}

	private PopupWindow popupWindow;

	private void initiateDailyNotificationPopupWindow() {
		LayoutInflater inflater = getLayoutInflater();// (LayoutInflater)
														// getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View layout = inflater.inflate(
				R.layout.activity_daily_notification,
				(ViewGroup) findViewById(R.id.profile_dailyNotification));

		popupWindow = new PopupWindow(layout, 400, 600, true);
		popupWindow.showAtLocation(findViewById(R.id.profilemain_dummy),
				Gravity.CENTER, 0, 0);

		Button btnSubmitPopup = (Button) layout
				.findViewById(R.id.btnProfileDailyNotificationSubmit);
		btnSubmitPopup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				TimePicker timepicker = (TimePicker) layout
						.findViewById(R.id.Profile_DailyNotificationTimePicker);
				String timepickerTxt = timepicker.toString();
				popupWindow.dismiss();
				Intent i = new Intent(Profile2.this, MainActivity.class);
				startActivity(i);
			}

		});

		Button btnCancelPopup = (Button) layout
				.findViewById(R.id.btnProfileDailyNotificationCancel);
		btnCancelPopup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				popupWindow.dismiss();
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile_actionbar, menu);
		MenuItem menuItem = menu.findItem(R.id.action_addNewCat);
		menuItem.setVisible(false);
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
