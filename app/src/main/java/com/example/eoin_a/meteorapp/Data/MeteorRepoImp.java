package com.example.eoin_a.meteorapp.Data;

import android.app.usage.NetworkStats;
import android.util.Log;

import com.example.eoin_a.meteorapp.Data.DB.DBHelper;
import com.example.eoin_a.meteorapp.Data.Web.ServiceImp;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by eoin_a on 27/10/2016.
 */

public class MeteorRepoImp implements MeteorRepo {


    private DBHelper dbhelper;
    private ServiceImp webservice;
    private NetworkStateHelper nshelper;
    private List<Meteor> meteorList;


    public MeteorRepoImp(DBHelper dbhelper, ServiceImp webservice, NetworkStateHelper nshelper)
    {
        this.dbhelper = dbhelper;
        this.webservice = webservice;
        this.nshelper = nshelper;
        meteorList = new ArrayList<>();
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
            meteorList = CallInitiate(call);
        }

        return meteorList;
    }


    private List<Meteor> CallInitiate(Call call)
    {
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response res) {

                if(res.isSuccessful())
                   meteorList = (List<Meteor>) res.body();
                else
                    Log.e("on resp", "error");

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                    Log.e("api error", "failure");
            }
        });


        return meteorList;
    }
}
