package com.example.eoin_a.meteorapp.Data.Web;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface Service {

	//could hide token. no need at present

	@Headers("X-App-Token: mZyaAGNlMXuvvJlqBqsCzdPDX")
	@GET("y77d-th95.json")
	Observable<List<Meteor>> getMeteors(@Query("$where") String query);
}
