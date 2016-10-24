package com.example.eoin_a.meteorapp.Data.Web;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by eoin_a on 24/10/2016.
 */

public interface Service {

    //could hide token. no need at present

    @Headers("X-App-Token: mZyaAGNlMXuvvJlqBqsCzdPDX")
    @GET("y77d-th95.json?{query}")
    Call<List<Meteor>> getMeteors(@Path("query") String query);
}
