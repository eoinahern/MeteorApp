package com.example.eoin_a.meteorapp.Presentation.View;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eoin_a.meteorapp.Presentation.Fragments.MeteorFragmentList;
import com.example.eoin_a.meteorapp.R;

public class MainActivity extends AppCompatActivity {

	private MeteorFragmentList meteorlistfrag;
	private FragmentManager fragmanager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		meteorlistfrag = MeteorFragmentList.getInst();
		fragmanager = getSupportFragmentManager();
		FragmentTransaction fragtrans = fragmanager.beginTransaction();
		fragtrans.add(R.id.activity_main, meteorlistfrag).commit();
	}
}
