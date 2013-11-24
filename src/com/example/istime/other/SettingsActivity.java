package com.example.istime.other;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.istime.MenuItemListActivity;
import com.example.istime.R;

public class SettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		Button AbtUsBtn = (Button) findViewById(R.id.AbtUsBtn);
		AbtUsBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				initiateAbtUsWindow();
			}
			
		});
		Button FAQBtn = (Button) findViewById(R.id.FAQBtn);
		FAQBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				initiateFAQWindow();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.actionbar, menu);
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
	/**
	 * Add New Category Popup
	 * **/
	private PopupWindow abtUsWin;

	private void initiateAbtUsWindow() {
		LayoutInflater inflater = (LayoutInflater) SettingsActivity.this .getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		View layout = inflater.inflate(R.layout.activity_settings_abtus,(ViewGroup) findViewById(R.id.profile_settings_abtUsScreen)); 
		abtUsWin = new PopupWindow(layout, 400, 600, true);
		abtUsWin.showAtLocation(layout, Gravity.CENTER, 0, 10);

		Button btnAddPopup = (Button) layout.findViewById(R.id.Setting_AbtUsbtnOk);
		btnAddPopup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				abtUsWin.dismiss();

			}

		});
	}
	
	private PopupWindow FAQWin;

	private void initiateFAQWindow() {
		LayoutInflater inflater = (LayoutInflater) SettingsActivity.this .getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		View layout = inflater.inflate(R.layout.activity_settings_faq,(ViewGroup) findViewById(R.id.profile_settings_abtUsScreen)); 
		abtUsWin = new PopupWindow(layout, 400, 600, true);
		abtUsWin.showAtLocation(layout, Gravity.CENTER, 0, 10);

		Button btnAddPopup = (Button) layout.findViewById(R.id.Setting_FAQbtnOk);
		btnAddPopup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				abtUsWin.dismiss();

			}

		});
	}


	
}
