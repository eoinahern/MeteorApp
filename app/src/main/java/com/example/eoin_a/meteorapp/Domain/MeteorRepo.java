package com.example.eoin_a.meteorapp.Domain;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by eoin_a on 24/10/2016.
 */

public interface MeteorRepo {
    Observable<List<Meteor>> getData();
    boolean checkEmpty();
    void saveData(List<Meteor> mlist);
    void subscribe(Subscriber<List<Meteor>> sub);
    void unsubscribe();

}
