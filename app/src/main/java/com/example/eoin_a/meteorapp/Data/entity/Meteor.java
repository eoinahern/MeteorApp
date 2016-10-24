package com.example.eoin_a.meteorapp.Data.entity;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by eoin_a on 24/10/2016.
 */

public class Meteor extends RealmObject implements Comparable<Meteor> {

    @SerializedName("mass")
    private float mass;

    @SerializedName("name")
    private String name;

    @SerializedName("year")
    private String year;

    @SerializedName("geolocation")
    private GeoLocation geoloacation;

    public Meteor()
    {

    }


    public float getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public GeoLocation getGeoloacation() {
        return geoloacation;
    }

    @Override
    public int compareTo(Meteor o) {
        if(this.mass > o.getMass())
            return 1;
        else if(this.mass < o.mass)
            return -1;

        return 0;
    }
}
