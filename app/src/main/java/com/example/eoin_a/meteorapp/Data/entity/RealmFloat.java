package com.example.eoin_a.meteorapp.Data.entity;

import io.realm.RealmObject;

/**
 * Created by eoin_a on 28/10/2016.
 * unfortunately realm currently wont support
 * a list or array of primatives in a realm object.
 *
 */

public class RealmFloat extends RealmObject {

    private float value;

    public RealmFloat()
    {

    }

    public float getValue()
    {
        return value;
    }
}
