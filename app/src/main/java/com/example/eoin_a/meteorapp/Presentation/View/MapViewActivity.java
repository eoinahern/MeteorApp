package com.example.eoin_a.meteorapp.Presentation.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Presentation.Navigation.ToMapActivity;
import com.example.eoin_a.meteorapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapViewActivity extends AppCompatActivity {

    @BindView(R.id.name_txt) TextView name;
    private Meteor meteor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
        ButterKnife.bind(this);


        Intent i = getIntent();
        meteor = i.getParcelableExtra(ToMapActivity.METEOR_INST);
        name.setText(meteor.getName());
    }


    private void displayData()
    {

    }
}
