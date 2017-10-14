package com.example.eoin_a.meteorapp.Data;

import android.util.Log;

import com.example.eoin_a.meteorapp.Data.DB.DBHelper;
import com.example.eoin_a.meteorapp.Data.Web.ServiceImp;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;

import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;

/**
 * repo implementation
 */

public class MeteorRepoImp implements MeteorRepo {

	private DBHelper dbhelper;
	private ServiceImp webservice;
	private NetworkStateHelper nshelper;
	private Scheduler mainshceduelr;
	private Scheduler threadscheduler;
	private Subscription subscription;

	public MeteorRepoImp(DBHelper dbhelper, ServiceImp webservice, NetworkStateHelper nshelper,
						 Scheduler mainscheduler, Scheduler threadscheduler) {
		this.dbhelper = dbhelper;
		this.webservice = webservice;
		this.nshelper = nshelper;
		this.mainshceduelr = mainscheduler;
		this.threadscheduler = threadscheduler;
	}

	@Override
	public Observable<List<Meteor>> getData() {

		Observable<List<Meteor>> meteorobs = null;
		boolean empty = checkEmpty();

		if (!empty) {
			meteorobs = dbhelper.getMeteorList();
			return meteorobs;
		}

		if (nshelper.checkNetworkConnected()) {
			meteorobs = webservice.getMeteors();
		}

		return meteorobs;
	}


	/**
	 * wrapper on database
	 *
	 * @return
	 */

	@Override
	public boolean checkEmpty() {
		return dbhelper.checkEmpty();
	}

	@Override
	public void saveData(List<Meteor> mlist) {
		dbhelper.saveMeteorList(mlist);
	}

	@Override
	public void subscribe(Subscriber<List<Meteor>> sub) {

		subscription = getData().subscribeOn(threadscheduler)
				.observeOn(mainshceduelr)
				.subscribe(sub);
	}

	@Override
	public void unsubscribe() {
		if (subscription != null && !subscription.isUnsubscribed())
			subscription.unsubscribe();
	}


}
