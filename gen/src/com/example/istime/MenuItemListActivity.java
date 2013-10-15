package com.example.istime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.istime.calendar.CalendarActivity;
import com.example.istime.other.SettingsActivity;
import com.example.istime.profile.Profile1;
import com.example.istime.summary.SummaryMain;

/**
 * An activity representing a list of MenuItems. This activity has different
 * presentations for handset and tablet-size devices. On handsets, the activity
 * presents a list of items, which when touched, lead to a
 * {@link MenuItemDetailActivity} representing item details. On tablets, the
 * activity presents the list of items and item details side-by-side using two
 * vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link MenuItemListFragment} and the item details (if present) is a
 * {@link MenuItemDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link MenuItemListFragment.Callbacks} interface to listen for item
 * selections.
 */
public class MenuItemListActivity extends FragmentActivity implements
		MenuItemListFragment.Callbacks {

	/**
	 * Whether or not the activity is in two-pane mode, i.e. running on a tablet
	 * device.
	 */
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menuitem_list);

		if (findViewById(R.id.menuitem_detail_container) != null) {
			// The detail container view will be present only in the
			// large-screen layouts (res/values-large and
			// res/values-sw600dp). If this view is present, then the
			// activity should be in two-pane mode.
			mTwoPane = true;

			// In two-pane mode, list items should be given the
			// 'activated' state when touched.
			((MenuItemListFragment) getSupportFragmentManager()
					.findFragmentById(R.id.menuitem_list))
					.setActivateOnItemClick(true);
		}

		// TODO: If exposing deep links into your app, handle intents here.
	}

	/**
	 * Callback method from {@link MenuItemListFragment.Callbacks} indicating
	 * that the item with the given ID was selected.
	 */
	@Override
	public void onItemSelected(String id) {
		if(id.equals("Home"))
		{
			startActivity(new Intent(this, MainActivity.class));
		}
		else if(id.equals("Profile"))
		{
			startActivity(new Intent(this, Profile1.class));
			
		}
		else if(id.equals("Calendar"))
		{
			startActivity(new Intent(this, CalendarActivity.class));
			
		}
		else if(id.equals("Summary"))
		{
			startActivity(new Intent(this, SummaryMain.class));
			
		}
		else if(id.equals("Settings"))
		{
			startActivity(new Intent(this, SettingsActivity.class));
			
		}
		else if(id.equals("Logout"))
		{
			startActivity(new Intent(this, LogoutActivity.class));
			
		}
		
		/*if (mTwoPane) {
			// In two-pane mode, show the detail view in this activity by
			// adding or replacing the detail fragment using a
			// fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(MenuItemDetailFragment.ARG_ITEM_ID, id);
			MenuItemDetailFragment fragment = new MenuItemDetailFragment();
			fragment.setArguments(arguments);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.menuitem_detail_container, fragment).commit();

		} else {
			// In single-pane mode, simply start the detail activity
			// for the selected item ID.
			Intent detailIntent = new Intent(this, MenuItemDetailActivity.class);
			detailIntent.putExtra(MenuItemDetailFragment.ARG_ITEM_ID, id);
			startActivity(detailIntent);
		}*/
	}
}