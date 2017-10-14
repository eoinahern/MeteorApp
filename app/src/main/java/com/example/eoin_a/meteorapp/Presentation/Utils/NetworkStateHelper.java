package com.example.eoin_a.meteorapp.Presentation.Utils;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

/**
 * Created by eoin_a on 29/10/2016.
 */

public class NetworkStateHelper {

	private Context cont;
	private ConnectivityManager cm;


	@Inject
	public NetworkStateHelper(Context cont) {
		this.cont = cont;
		cm = (ConnectivityManager) cont.getSystemService(Context.CONNECTIVITY_SERVICE);
	}


	public boolean checkNetworkConnected() {
		NetworkInfo netinfo = cm.getActiveNetworkInfo();
		return netinfo != null && netinfo.isConnectedOrConnecting();
	}
}
