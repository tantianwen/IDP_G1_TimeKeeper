package com.example.istime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.istime.profile.ProfileManager;
import com.example.istime.profile.ProfileManager.Profile;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //getActionBar().setDisplayHomeAsUpEnabled(false);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        TextView tv = (TextView) findViewById(R.id.welcome_text);
        
        String email = getIntent().getExtras().getString("email");
        Profile p = ProfileManager.getProfile(email);
        tv.setText("Welcome, " + p.getProfileName());
        
    }
      
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);
        return true;
    }
    
    /*public boolean onGroupItemClick(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.menuSelect:
			startActivity(new Intent(this, MenuItemListActivity.class));
			return true;
    	}
    	return super.onOptionsItemSelected(item);
    }*/
    
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
