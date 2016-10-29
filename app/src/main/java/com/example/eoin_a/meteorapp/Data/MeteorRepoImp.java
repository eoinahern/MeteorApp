package com.example.eoin_a.meteorapp.Data;

import android.app.usage.NetworkStats;

import com.example.eoin_a.meteorapp.Data.DB.DBHelper;
import com.example.eoin_a.meteorapp.Data.Web.Service;
import com.example.eoin_a.meteorapp.Data.Web.ServiceImp;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by eoin_a on 27/10/2016.
 */

public class MeteorRepoImp implements MeteorRepo {


    private DBHelper dbhelper;
    private ServiceImp webservice;
    private NetworkStateHelper nshelper;
    private List<Meteor> meteorList;



    @Inject
    public MeteorRepoImp(DBHelper dbhelper, ServiceImp webservice, NetworkStateHelper nshelper)
    {
        this.dbhelper = dbhelper;
        this.webservice = webservice;
        this.nshelper = nshelper;
        List<Meteor> meteorList = new ArrayList<>();

    }

    @Override
    public List<Meteor> getData() {


        if(!dbhelper.checkEmpty())
        {
          meteorList  =  dbhelper.getMeteorList();
          return meteorList;
        }


        if(nshelper.checkNetworkConnected())
        {
           Call call =  webservice.getMeteors();
        }







        return meteorList;
    }
}
