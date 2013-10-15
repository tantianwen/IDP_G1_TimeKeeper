package com.example.istime.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.istime.MenuItemListActivity;
import com.example.istime.R;

public class Profile1 extends FragmentActivity implements CategoryDialogFragment.CategoryDialogListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile1);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Button button= (Button) findViewById(R.id.button_add);
		button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	/*Intent intent1 = new Intent(Profile1.this, AddProfile.class);
		    	 startActivity(intent1);*/
		    	showAddProfileDialog();
		    }
		});
		
		ImageButton navigation_button= (ImageButton) findViewById(R.id.navigation_right);
		navigation_button.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		    	Intent intent2 = new Intent(Profile1.this, Profile2.class);
		    	 startActivity(intent2);
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile1, menu);
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
    
	public void showAddProfileDialog() {
        // Create an instance of the dialog fragment and show it
        DialogFragment dialog = new AddProfileDialog();
        dialog.show(getSupportFragmentManager(), "CategoryDialogFragment");
    }
    
	@Override
	public void onDialogPositiveClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		// TODO Auto-generated method stub
		
	}

}
