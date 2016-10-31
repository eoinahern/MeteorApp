package com.example.eoin_a.meteorapp.Data.entity;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by eoin_a on 24/10/2016.
 */

public class Meteor extends RealmObject implements Comparable<Meteor>{

    @SerializedName("mass")
    private float mass;

    @SerializedName("name")
    private String name;

    @SerializedName("year")
    private String year;


    @SerializedName("reclat")
    private String reclat;

    @SerializedName("reclong")
    private String reclong;


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

   /* public GeoLocation getGeoloacation() {
        return geolocation;
    }*/

    @Override
    public int compareTo(Meteor o) {
        if(this.mass > o.getMass())
            return 1;
        else if(this.mass < o.mass)
            return -1;

        return 0;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
