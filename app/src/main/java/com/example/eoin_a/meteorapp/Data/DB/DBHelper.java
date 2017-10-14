package com.example.eoin_a.meteorapp.Data.DB;


import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.List;

import rx.Observable;
import rx.Subscriber;


public interface DBHelper {

	Observable<List<Meteor>> getMeteorList();

	void saveMeteorList(List<Meteor> meteorlist);

	boolean checkEmpty();

	void closeDB();

}
