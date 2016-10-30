package com.example.eoin_a.meteorapp.Domain;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.List;

import rx.Observable;

/**
 * Created by eoin_a on 24/10/2016.
 */

public interface MeteorRepo {
    Observable<List<Meteor>> getData();
}
