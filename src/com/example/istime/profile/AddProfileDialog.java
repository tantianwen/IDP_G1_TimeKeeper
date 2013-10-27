package com.example.istime.profile;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.istime.R;

public class AddProfileDialog extends CategoryDialogFragment{
		
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
	    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    // Get the layout inflater
	    LayoutInflater inflater = getActivity().getLayoutInflater();

	    // Inflate and set the layout for the dialog
	    // Pass null as the parent view because its going in the dialog layout
	    View v = inflater.inflate(R.layout.activity_add_profile, null);
	    
	    final EditText categoryName = (EditText)v.findViewById(R.id.profile_AddNewCatName);
	    final EditText numOfHours = (EditText)v.findViewById(R.id.profile_addCatNumOfHours);
	    builder.setView(v)
	    // Add action buttons
	           .setPositiveButton(R.string.button_add, new DialogInterface.OnClickListener() {
	               @Override
	               public void onClick(DialogInterface dialog, int id) {
	                   // sign in the user ...
	            	   String catName = categoryName.getText().toString();
	            	   String numHours = numOfHours.getText().toString();
	            	   mListener.onDialogPositiveClick(AddProfileDialog.this, catName, numHours);
	            	   
	               }
	           })
	           .setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                   AddProfileDialog.this.getDialog().cancel();
	               }
	           });      
	    return builder.create();
	}

}
