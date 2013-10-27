package com.example.istime.profile;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.istime.MenuItemListActivity;
import com.example.istime.R;

public class Profile1 extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile1);

		ActionBar actionbar = getActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
		
		/*Button button = (Button) findViewById(R.id.button_add);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				/*
				 * Intent intent1 = new Intent(Profile1.this, AddProfile.class);
				 * startActivity(intent1);
				 */
		/*		initiatePopupWindow();
			}
		});*/
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile_actionbar, menu);
		MenuItem menuItem = menu.findItem(R.id.action_addNewCat);
		menuItem.setVisible(true);
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

	/*
	 * public void showAddProfileDialog() { // Create an instance of the dialog
	 * fragment and show it DialogFragment dialog = new AddProfileDialog();
	 * dialog.show(getSupportFragmentManager(), "CategoryDialogFragment"); }
	 * 
	 * @Override public void onDialogPositiveClick(DialogFragment dialog, String
	 * categoryName, String numOfHours) { TextView addNewCategory = new
	 * TextView(this); addNewCategory.setText(categoryName);
	 * 
	 * LinearLayout layoutOfPopup = new LinearLayout(this);
	 * layoutOfPopup.setOrientation(1); layoutOfPopup.addView(addNewCategory);
	 * setContentView(layoutOfPopup); //TextView text = (TextView)
	 * findViewById(R.id.newCategory); //text.setText(categoryName); // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void onDialogNegativeClick(DialogFragment dialog) { //
	 * TODO Auto-generated method stub
	 * 
	 * }
	 */
	

}
