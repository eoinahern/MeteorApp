package com.example.eoin_a.meteorapp.Presentation.Navigation;

import android.app.Activity;
import android.content.Intent;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Presentation.View.MapViewActivity;

/**
 * Created by eoin_a on 01/11/2016.
 */

public class ToMapActivity implements NavigationCommand {

    private Activity activity;
    private Meteor meteor;
    public final static String METEOR_INST = "meteor";

    public ToMapActivity(Activity activity, Meteor meteor)
    {
        this.activity = activity;
        this.meteor = meteor;
    }

    @Override
    public void navigate() {
        Intent intent  = new Intent(activity, MapViewActivity.class);
        intent.putExtra(METEOR_INST, meteor);
        activity.startActivity(intent);
    }
}
