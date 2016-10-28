package com.example.eoin_a.meteorapp.Presentation.DI.Modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by eoin_a on 28/10/2016.
 */
@Singleton
@Module
public class AppModule {


    private Application myapp;

    public AppModule(Application myapp)
    {
        this.myapp = myapp;
    }

    @Singleton
    @Provides
    public Context getCont()
    {
        return myapp;
    }



}
