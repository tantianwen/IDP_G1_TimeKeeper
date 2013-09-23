package com.example.istime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ListItemDetail extends Activity {

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_item_list);

    Intent intent = getIntent();
    int position = intent.getIntExtra("position", 0);

    // Here we turn your string.xml in an array
    String[] myKeys = getResources().getStringArray(R.array.menuItem);

    TextView myTextView = (TextView) findViewById(R.id.item_list);
    myTextView.setText(myKeys[position]);


    }

}
