package com.example.istime.profile;

import java.util.HashMap;
import java.util.Locale;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.istime.MainActivity;
import com.example.istime.MenuItemListActivity;
import com.example.istime.R;
import com.example.istime.profile.ProfileManager.Profile;

public class ProfilemainActivity extends FragmentActivity implements
		ActionBar.TabListener, OnClickListener{

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	Menu _menu;
	Spinner spinner;
	static String username = "";
	static Button submitBtn;
	static EditText profileName;
	static Intent i;
	static String email = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.profilemain);
		i = new Intent(ProfilemainActivity.this,MainActivity.class);
		email = getIntent().getExtras().getString("email");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile_actionbar, menu);
		
		_menu = menu;

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						actionBar.setSelectedNavigationItem(position);
					}
				});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection

		switch (item.getItemId()) {
		case android.R.id.home:
			startActivity(new Intent(this, MenuItemListActivity.class));
			return true;
		case R.id.action_addNewCat:
			initiatePopupWindow();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
		MenuItem menuItem = _menu.findItem(R.id.action_addNewCat);
		if (tab.getPosition() == 0) {
			menuItem.setVisible(true);
		} else {
			menuItem.setVisible(false);
		}
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		MenuItem menuItem = _menu.findItem(R.id.action_addNewCat);
		if (tab.getPosition() == 0) {
			menuItem.setVisible(true);
		} else {
			menuItem.setVisible(false);
		}
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		MenuItem menuItem = _menu.findItem(R.id.action_addNewCat);
		if (tab.getPosition() == 0) {
			menuItem.setVisible(true);
		} else {
			menuItem.setVisible(false);
		}
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {

			Fragment fragment = null;
			switch (position) {
			case 0:
				fragment = new ProfileViewFragment();
				return fragment;
			case 1:
				fragment = new WorkScheduleFragment();
				return fragment;
			default:
				return fragment;
			}

		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class ProfileViewFragment extends Fragment {

		public static final String ARG_OBJECT = "item";

		public ProfileViewFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_profile1,
					container, false);
			profileName = (EditText) rootView.findViewById(R.id.profile_txtName);
			return rootView;
		}
	}

	public static class WorkScheduleFragment extends Fragment {

		public static final String ARG_OBJECT = "item";

		public WorkScheduleFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_profile2,
					container, false);
			submitBtn = (Button) rootView.findViewById(R.id.profile_submit);
			
			//View profileView = inflater.inflate(R.layout.activity_profile1, container, false);
			//profileName = (EditText) findViewById(R.id.profile_txtName);
			//username = profileName.getText().toString();
			//Log.i("the name is1",username);
			submitBtn.setOnClickListener(new OnClickListener() {
		        @Override
		        public void onClick(View v) {
		        	//Actual execution of OnClick Submit
		        	username = profileName.getText().toString();
		        	HashMap<String,Double> cateogryDetail = new HashMap<String,Double>();
		        	cateogryDetail.put("Family",30.0);
		        	cateogryDetail.put("Friend",10.0);
		        	cateogryDetail.put("Personal",10.0);
		        	
		        	Profile p = new Profile(email,username,cateogryDetail,null,null,null,null);
		        	ProfileManager.addProfile(p);
		        	Log.i("the name is",username);
		        	i.putExtra("email", email);
					
		        	startActivity(i);
		        }
		    });
			return rootView;
		}
	}

	/**
	 * Add New Category Popup
	 * **/
	private PopupWindow pwindo;

	private void initiatePopupWindow() {
		LayoutInflater inflater = (LayoutInflater) ProfilemainActivity.this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View layout = inflater.inflate(R.layout.activity_add_profile,
				(ViewGroup) findViewById(R.id.profile_addCategory));
		pwindo = new PopupWindow(layout, 400, 500, true);
		pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

		Button btnAddPopup = (Button) layout.findViewById(R.id.Profile_btnAdd);
		btnAddPopup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText newCategory = (EditText) layout
						.findViewById(R.id.profile_AddNewCatName);
				String newCategoryTxt = newCategory.getText().toString();
				EditText newCatHours = (EditText) layout
						.findViewById(R.id.profile_addCatNumOfHours);
				String newCatHoursTxt = newCatHours.getText().toString();
				addNewTableRow(newCategoryTxt, newCatHoursTxt);
				pwindo.dismiss();

			}

		});

		Button btnCancelPopup = (Button) layout
				.findViewById(R.id.Profile_btnCancel);
		btnCancelPopup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pwindo.dismiss();
			}

		});
	}

	private void addNewTableRow(String categoryName, String categoryHours) {
		TableRow.LayoutParams tlparams = new TableRow.LayoutParams(0,
				TableRow.LayoutParams.WRAP_CONTENT, 1);
		final TableLayout newTable = (TableLayout) findViewById(R.id.profile1_table);
		int i = newTable.getChildCount();
		newTable.setColumnStretchable(0, true);
		final TableRow tablerow = new TableRow(this);
		tablerow.setGravity(Gravity.CENTER_HORIZONTAL);
		TextView newCat = new TextView(this);
		newCat.setHint(categoryName);
		newCat.setTextSize(20);
		// newCat.setLayoutParams(new
		// LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1));
		tlparams.setMargins(0, 0, 0, 20);
		newCat.setLayoutParams(tlparams);
		tablerow.addView(newCat);
		final EditText newCatHrs = new EditText(this);
		newCatHrs.setText(categoryHours);
		// newCatHrs.setLayoutParams(new
		// LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1));
		newCatHrs.setGravity(Gravity.CENTER_HORIZONTAL);
		newCatHrs.setLayoutParams(tlparams);
		tablerow.addView(newCatHrs);
		//Button btnDelete = new Button(this, null, android.R.attr.buttonStyleSmall);
		Button btnDelete = new Button(this, null, R.style.SmallButtonText);
		btnDelete.setGravity(Gravity.CENTER_HORIZONTAL);
		//btnDelete.setHeight(10);
		//btnDelete.setWidth(10);
		btnDelete.setText("Delete");
		btnDelete.setBackgroundResource(R.drawable.btn_red);
		btnDelete.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {

				// I need to delete the tablerow
				// how to do?
				newTable.removeView(tablerow);
			}
		});

		tablerow.addView(btnDelete);
		newTable.addView(tablerow);

	}
	/*
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_profile2, container, false);
		submitBtn = (Button) view.findViewById(R.id.profile_submit);
		//submitBtn.setOnClickListener(this);
		submitBtn.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	        	
	        	System.out.println("ZNM");
	        	Log.i("APP","ZNM");
	        	Intent i = new Intent(ProfilemainActivity.this,MainActivity.class);
	        	startActivity(i);
	        }
	    });
		
		
		 return view;
		
	}*/
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//username = profileName.getText().toString();
		
        if(v.getId()==R.id.profile_submit)
        {
        	//Log.i("APP","ZNM");
        	//i = new Intent(ProfilemainActivity.this,MainActivity.class);
        	//i.putExtra("username", username);
        	//startActivity(i);
        }
	}
}
