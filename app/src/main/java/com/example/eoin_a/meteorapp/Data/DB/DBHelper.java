package com.example.eoin_a.meteorapp.Data.DB;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.List;

/**
 * Created by eoin_a on 24/10/2016.
 */

public interface DBHelper {


    List<Meteor> getMeteorList();
    void saveMeteorList(List<Meteor> meteorlist);
    void closeDB();

}
