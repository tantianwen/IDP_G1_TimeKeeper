package com.example.istime.profile;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

public class FragmentClass extends Fragment implements View.OnClickListener {

	private OnClickListener m_onClickListener;

	public interface OnClickListener {
		public void onClick(View view);

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (activity instanceof OnClickListener) {
			m_onClickListener = (OnClickListener) activity;
		}
	}

	public void onClick(View view) {
		m_onClickListener.onClick(view);
	}

}