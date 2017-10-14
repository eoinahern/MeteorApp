package com.example.eoin_a.meteorapp.Presentation.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Presentation.Utils.DateFormatter;
import com.example.eoin_a.meteorapp.Presentation.Utils.StringFormatter;
import com.example.eoin_a.meteorapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsFragment extends Fragment {

	private static final String MTAG = "meteor";

	@BindView(R.id.masstxt) TextView masstxt;
	@BindView(R.id.yeartxt) TextView yeartxt;
	@BindView(R.id.nametxt) TextView nametxt;
	@BindView(R.id.name_initial) TextView nameinitial;
	@BindView(R.id.longtxt) TextView longtxt;
	@BindView(R.id.lattxt) TextView lattxt;

	private Meteor meteor;

	//well aware this could of been done once with a mapper class!!


	private StringFormatter strformatter;
	private DateFormatter dateformatter;


	public static DetailsFragment getInst(Meteor meteor) {
		DetailsFragment frag = new DetailsFragment();
		Bundle bun = new Bundle();
		bun.putParcelable(MTAG, meteor);
		frag.setArguments(bun);
		return frag;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_details, container, false);
		ButterKnife.bind(this, v);


		strformatter = new StringFormatter();
		dateformatter = new DateFormatter();

		Bundle bun = this.getArguments();
		if (bun != null)
			setTextViews(bun);

		return v;
	}

	private void setTextViews(Bundle bun) {
		meteor = bun.getParcelable(MTAG);
		yeartxt.setText(dateformatter.shortenFormat(meteor.getYear()));
		nameinitial.setText(strformatter.getFirstChar(meteor.getName()));
		nametxt.setText(strformatter.abbreviateString(meteor.getName()));
		masstxt.setText(String.valueOf(meteor.getMass()));
		lattxt.setText(meteor.getReclat());
		longtxt.setText(meteor.getReclong());
	}
}
