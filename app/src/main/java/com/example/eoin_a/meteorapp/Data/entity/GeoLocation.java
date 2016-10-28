package com.example.eoin_a.meteorapp.Data.entity;

import com.google.gson.annotations.SerializedName;
import io.realm.RealmList;
import io.realm.RealmObject;


/**
 * Created by eoin_a on 24/10/2016.
 */
public class GeoLocation extends RealmObject {


    @SerializedName("type")
    private String type;

    @SerializedName("coordinates")
    private RealmList<RealmFloat> coordinates;

    public GeoLocation()
    {

    }

    public  RealmList<RealmFloat> getCoordinates()
    {
        return  coordinates;
    }
    public String getType()
    {
        return type;
    }
}
