package com.example.eoin_a.meteorapp.Data;
import android.util.Log;

import com.example.eoin_a.meteorapp.Data.DB.DBHelper;
import com.example.eoin_a.meteorapp.Data.Web.ServiceImp;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by eoin_a on 27/10/2016.
 * becuase the app is small i just used the repo
 * and didnt use a usecase implementation
 * in the domain package. If i had been following
 * DDD i would have had the Usecase implementation
 * with a repo instance as a dependency within the usecase.
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

                Log.d("res code", String.valueOf(res.code()));

                if(res.isSuccessful()) {
                    meteorList = (List<Meteor>) res.body();
                    Log.d("list len", String.valueOf(meteorList.size()));
                }
                else {
                    Log.e("on resp", "error");
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                    t.printStackTrace();
                    Log.e("api error", "failure");
            }
        });


        return meteorList;
    }
}
