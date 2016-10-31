package com.example.eoin_a.meteorapp.Data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by eoin_a on 24/10/2016.
 */

public class Meteor extends RealmObject implements Comparable<Meteor>, Parcelable {

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


    public Meteor() {

    }


    public Meteor(Parcel in) {
        mass = in.readFloat();
        name = in.readString();
        year = in.readString();
        reclat = in.readString();
        reclong = in.readString();
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


    @Override
    public int compareTo(Meteor o) {
        if (this.mass > o.getMass())
            return 1;
        else if (this.mass < o.mass)
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(mass);
        dest.writeString(name);
        dest.writeString(year);
        dest.writeString(reclat);
        dest.writeString(reclong);
    }

    public static final Parcelable.Creator<Meteor> CREATOR = new Parcelable.Creator<Meteor>() {
        public Meteor createFromParcel(Parcel in) {
            return new Meteor(in);
        }

        @Override
        public Meteor[] newArray(int size) {
            return new Meteor[size];
        }
    };

}
