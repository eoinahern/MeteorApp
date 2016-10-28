package com.example.eoin_a.meteorapp.Data;

import com.example.eoin_a.meteorapp.Data.DB.DBHelper;
import com.example.eoin_a.meteorapp.Data.Web.Service;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by eoin_a on 27/10/2016.
 */

public class MeteorRepoImp implements MeteorRepo {


    private DBHelper dbhelper;
    private Service webservice;


    @Inject
    public MeteorRepoImp(DBHelper dbhelper, Service webservice)
    {
        this.dbhelper = dbhelper;
        this.webservice = webservice;
    }

    @Override
    public List<Meteor> getData() {
        return null;
    }
}
