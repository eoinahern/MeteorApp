package com.example.eoin_a.meteorapp;

import android.app.Application;

import com.example.eoin_a.meteorapp.Presentation.DI.Components.AppComponent;
import com.example.eoin_a.meteorapp.Presentation.DI.Components.DaggerAppComponent;
import com.example.eoin_a.meteorapp.Presentation.DI.Modules.AppModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MeteorApplication extends android.app.Application {

	private static final String REALM_DB = "meteor.db";
	private AppComponent appcomponent;

	@Override
	public void onCreate() {
		super.onCreate();
		configRealm();
		appcomponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
	}

	private void configRealm() {
		RealmConfiguration realmconfig = new RealmConfiguration.Builder(this)
				.name(REALM_DB)
				.build();

		Realm.setDefaultConfiguration(realmconfig);
	}

	public AppComponent getAppcomponent() {
		return appcomponent;
	}

}
