package com.example.eoin_a.meteorapp.Presentation.DI.Components;

import android.content.Context;

import com.example.eoin_a.meteorapp.Presentation.DI.Modules.AppModule;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by eoin_a on 28/10/2016.
 */


@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    //provided to submodules.
    Context cont();
    NetworkStateHelper netHelper();
}
