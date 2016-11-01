package com.example.eoin_a.meteorapp.Presentation.Navigation;

import android.app.Activity;
import android.content.Intent;

import com.example.eoin_a.meteorapp.Presentation.View.MapViewActivity;

/**
 * Created by eoin_a on 01/11/2016.
 */

public class ToMapActivity implements NavigationCommand {

    private Activity activity;

    public ToMapActivity(Activity activity)
    {
        this.activity = activity;
    }

    @Override
    public void navigate() {
        Intent intent  = new Intent(activity, MapViewActivity.class);
        activity.startActivity(intent);
    }
}
