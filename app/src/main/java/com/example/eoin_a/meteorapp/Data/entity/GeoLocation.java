package com.example.eoin_a.meteorapp.Data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eoin_a on 24/10/2016.
 */

public class GeoLocation {

    @SerializedName("coordinates")
    private  float[] coordinates;

    public GeoLocation()
    {

    }
}
