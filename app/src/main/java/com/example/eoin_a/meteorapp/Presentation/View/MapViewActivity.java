package com.example.eoin_a.meteorapp.Presentation.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Presentation.Navigation.ToMapActivity;
import com.example.eoin_a.meteorapp.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapViewActivity extends AppCompatActivity  implements OnMapReadyCallback {

    @BindView(R.id.name_txt) TextView name;
    private Meteor meteor;
    private SupportMapFragment mapfrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
        ButterKnife.bind(this);

        getMeteor();
        name.setText(meteor.getName());
        loadMap();
    }


    private void getMeteor() {
        Intent i = getIntent();
        meteor = i.getParcelableExtra(ToMapActivity.METEOR_INST);
    }

    private void loadMap()
    {
        mapfrag = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapfrag.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}
