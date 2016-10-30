package com.example.eoin_a.meteorapp.Data;
import android.util.Log;

import com.example.eoin_a.meteorapp.Data.DB.DBHelper;
import com.example.eoin_a.meteorapp.Data.Web.ServiceImp;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;
import java.util.List;
import rx.Observable;

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
    //private List<Meteor> meteorList;


    public MeteorRepoImp(DBHelper dbhelper, ServiceImp webservice, NetworkStateHelper nshelper)
    {
        this.dbhelper = dbhelper;
        this.webservice = webservice;
        this.nshelper = nshelper;
    }

    @Override
    public Observable<List<Meteor>> getData() {

        Observable<List<Meteor>> meteorobs = null;

        if(!dbhelper.checkEmpty())
        {
           meteorobs =  dbhelper.getMeteorList();
        }

        if(nshelper.checkNetworkConnected())
        {
            meteorobs =  webservice.getMeteors();
        }

        return meteorobs;
    }


    /*private List<Meteor> CallInitiate(Call call)
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
    }*/
}
