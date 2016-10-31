package com.example.eoin_a.meteorapp.Data.DB;

import android.util.Log;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by eoin_a on 24/10/2016.
 */

public class DBHelperImp implements DBHelper {

    private Realm realm;

    public DBHelperImp()
    {
        realm = Realm.getDefaultInstance();
    }

    @Override
    public Observable<List<Meteor>> getMeteorList() {
        RealmResults<Meteor> res = realm.where(Meteor.class).findAll();
        Log.d("list size", String.valueOf(res.size()));
        List<Meteor> mylist = new ArrayList<>();

        //converted to a regular list as relam results will
        //thow exception when you call .sort() on them??

        for(Meteor item : res)
        {
            mylist.add(item);
        }

        return Observable.just(mylist);

    }

    @Override
    public void saveMeteorList(List<Meteor> mlist) {

        realm.beginTransaction();
        realm.copyToRealm(mlist);
        realm.commitTransaction();
    }

    @Override
    public boolean checkEmpty() {
        return realm.isEmpty();
    }


    @Override
    public void closeDB() {
        realm.close();
    }



}
