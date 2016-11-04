package com.example.eoin_a.meteorapp.Data;

import com.example.eoin_a.meteorapp.Data.DB.DBHelper;
import com.example.eoin_a.meteorapp.Data.Web.ServiceImp;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by eoin_a on 04/11/2016.
 * seperate build varient for passing back fake data when
 * testing UI.
 */

public class MeteorRepoImp implements MeteorRepo {


    private DBHelper dbhelper;
    private ServiceImp webservice;
    private NetworkStateHelper nshelper;
    private Scheduler mainshceduelr;
    private Scheduler threadscheduler;
    private Subscription subscription;

    public MeteorRepoImp(DBHelper dbhelper, ServiceImp webservice, NetworkStateHelper nshelper,
                         Scheduler mainscheduler, Scheduler threadscheduler)
    {
        this.dbhelper = dbhelper;
        this.webservice = webservice;
        this.nshelper = nshelper;
        this.mainshceduelr = Schedulers.immediate();
        this.threadscheduler = Schedulers.immediate();
    }

    @Override
    public Observable<List<Meteor>> getData() {

        return  Observable.just(getList());
    }

    private List<Meteor> getList()
    {
        List<Meteor>  mlist = new ArrayList<>();


        Meteor  meteor1 = new Meteor();
        meteor1.setName("cork");
        meteor1.setMass(11f);
        meteor1.setYear("2012-01-01T00:00:00.000");


        Meteor  meteor2 = new Meteor();
        meteor2.setName("rome");
        meteor2.setMass(12f);
        meteor2.setYear("2012-01-01T00:00:00.000");

        Meteor  meteor3 = new Meteor();
        meteor3.setName("some gaff");
        meteor3.setMass(12f);
        meteor3.setYear("2014-01-01T00:00:00.000");

        mlist.add(meteor1);
        mlist.add(meteor2);
        mlist.add(meteor3);

        return mlist;
    }


    /**
     * wrapper on database
     * @return
     */

    @Override
    public boolean checkEmpty()
    {
        return false;
    }

    @Override
    public void saveData(List<Meteor> mlist)
    {
        //nothing required to do!!
    }

    @Override
    public void subscribe(Subscriber<List<Meteor>> sub) {

        subscription = getData().subscribeOn(threadscheduler)
                .observeOn(mainshceduelr)
                .subscribe(sub);
    }

    @Override
    public void unsubscribe()
    {
        if(subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }


}
