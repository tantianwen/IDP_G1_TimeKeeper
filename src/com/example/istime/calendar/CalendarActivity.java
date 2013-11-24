package com.example.istime.calendar;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.TextView;

import com.example.istime.MenuItemListActivity;
import com.example.istime.R;

public class CalendarActivity extends Activity {

		CalendarView cal; 
		static String selectedDate="";
		Intent directToDayView;
		public final static String EXTRA_MESSAGE="";
		ArrayStorage storage = new ArrayStorage();
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		cal = (CalendarView) findViewById(R.id.calendarView1);
		
		cal.setOnDateChangeListener(new OnDateChangeListener() {
				
				@Override
				public void onSelectedDayChange(CalendarView view, int year, int month,
						int dayOfMonth) {
					// TODO Auto-generated method stub
					String monthInEnglish = null;
					
					switch(month) {
					case 1:
						monthInEnglish = "Jan";
						break;
					case 2:
						monthInEnglish = "Feb";
						break;
					case 3:
						monthInEnglish = "March";
						break;
					case 4:
						monthInEnglish = "April";
						break;
					case 5:
						monthInEnglish = "May";
						break;
					case 6:
						monthInEnglish = "June";
						break;
					case 7:
						monthInEnglish = "July";
						break;
					case 8:
						monthInEnglish = "August";
						break;
					case 9:
						monthInEnglish = "Sept";
						break;
					case 10:
						monthInEnglish = "Oct";
						break;
					case 11:
						monthInEnglish = "Nov";
						break;
					case 12:
						monthInEnglish = "Dec";
						break;
					}
					
					selectedDate = dayOfMonth+" "+ monthInEnglish +" "+year;
					redirect(selectedDate);
				}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
		return true;
	}
	
	public void redirect(String selectedDate) {
		//updateList();
		Intent intentRedirect = new Intent(this, CalendarDayView.class);
		intentRedirect.putExtra(EXTRA_MESSAGE, selectedDate);
		startActivity(intentRedirect);		
	}

/*	public void updateList() {
		ArrayList<String> timeArray = storage.getTimeArray();
		ArrayList<Event>  eventArray = storage.getEventArray();
		ArrayList<String> newTimeArray = storage.newTimeArray();
		String time;
		int x;
		int a;
		String time2=null;
		
		System.out.println("Proceeding Update");
		System.out.println("Selected Date: " + selectedDate);
		
		
		for(int j=0;j<timeArray.size();j++){
			
			//System.out.println(timeArray.get(j));
			
			if(j == 0) {
				time = timeArray.get(j).concat(":00");
				System.out.println("Time 1 is:" + time);

			} else {
				
				if(j%2==0) {
					//Even number row
					String getTime = timeArray.get(j);
					time = getTime.concat(":00");
					System.out.println("Time is" + time);
					
				} else {
					//Odd number row
					String getTime =timeArray.get(j-1);
					time = getTime.concat(":30");
					System.out.println("time is "+ time);
				}
			}
			
			//time2=time;
			a=j;
			System.out.println("Entering Foor loop for event array");
			for(int i=0;i<eventArray.size();i++) {
					System.out.println("Event array size is: " + eventArray.size());
					
					if(selectedDate.equals(eventArray.get(i).getDate())) {
						
						System.out.println("Event Date: " +eventArray.get(i).getDate());
						System.out.println("Selected Date is: " + selectedDate);
						System.out.println("Time is:" + time);
						System.out.println("Event Start Time:" + eventArray.get(i).getEventStartTime());
						
						if(time.equals(eventArray.get(i).getEventStartTime())) {
							System.out.println(eventArray.get(i).getEventStartTime());
								
							while(!(time.equals(eventArray.get(i).getEventEndTime()))) {
								
								System.out.println("New Time Array is: "+newTimeArray.size());
								System.out.println("Event end time is: " + eventArray.get(i).getEventEndTime());
								System.out.println("Time is: " + time);
								
								String updateMsg = eventArray.get(i).getEventStartTime().concat(" to ").concat(eventArray.get(i).getEventEndTime())
													.concat(" | ").concat(eventArray.get(i).getEvent().concat(" | ").concat(eventArray.get(i).getCategory()));
								x=a; 
								if(a == 0) {
									time = newTimeArray.get(j).concat(":00");
									System.out.println("Time 1 is:" + time);

								} else {
									
									if(a%2==0) {
										//Even number row
										String getTime = newTimeArray.get(a);
										time = getTime.concat(":00");
										System.out.println("Time is" + time);
										
									} else {
										//Odd number row
										String getTime = newTimeArray.get(a-1);
										time = getTime.concat(":30");
										System.out.println("time is "+ time);
									}
								}
								
								timeArray.set(x, updateMsg);
								
								if(a<=timeArray.size()){
									a++;
								}


							}
						}
					} else {
						storage.emptyTimeArray();
					}
			}
		}
	} */
	
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
