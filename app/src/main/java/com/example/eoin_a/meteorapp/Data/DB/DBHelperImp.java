package com.example.eoin_a.meteorapp.Data.DB;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

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
    public List<Meteor> getMeteorList() {

        RealmResults<Meteor> res = realm.where(Meteor.class).findAll();
        return  res;
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
