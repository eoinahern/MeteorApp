package com.example.eoin_a.meteorapp.Presentation.DI.Components;

import android.content.Context;

import com.example.eoin_a.meteorapp.Presentation.DI.Modules.AppModule;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;

import javax.inject.Singleton;

import dagger.Component;


@Component(modules = AppModule.class)
public interface AppComponent {
	Context cont();
}
