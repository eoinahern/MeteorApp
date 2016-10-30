package com.example.eoin_a.meteorapp.Data.Web;
import android.util.Log;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by eoin_a on 24/10/2016.
 */

public class ServiceImp {

    private  final String URL = "https://data.nasa.gov/resource/";
    private final String QUERY = "year between'2013-01-01T00:00:00.000' and '2014-01-01T00:00:00.000'";
    private Service service;


    public ServiceImp()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(Service.class);
    }

    public Observable<List<Meteor>> getMeteors()
    {
        return service.getMeteors(QUERY);
    }

}
