package com.example.eoin_a.meteorapp.Presentation.DI.Modules;

import android.content.Context;

import com.example.eoin_a.meteorapp.Data.DB.DBHelper;
import com.example.eoin_a.meteorapp.Data.DB.DBHelperImp;
import com.example.eoin_a.meteorapp.Data.MeteorRepoImp;
import com.example.eoin_a.meteorapp.Data.Web.Service;
import com.example.eoin_a.meteorapp.Data.Web.ServiceImp;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.DI.Ascope;
import com.example.eoin_a.meteorapp.Presentation.Navigation.NavigationCommand;
import com.example.eoin_a.meteorapp.Presentation.Navigation.ToMapActivity;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by eoin_a on 29/10/2016.
 */

@Module
public class RepoModule {

    @Provides
    public DBHelper getDBhelper()
    {
        return new DBHelperImp();
    }


    @Provides
    public ServiceImp getWeHelper()
    {
        return new ServiceImp();
    }


    @Provides
    @Named("threadsched")
    public Scheduler getthreadSchecduler()
    {
        return Schedulers.io();
    }

    @Provides
    @Named("mainsched")
    public Scheduler getMainSched()
    {
        return AndroidSchedulers.mainThread();
    }


    @Provides
    public NetworkStateHelper getNetStateHelper( Context cont)
    {
        return new NetworkStateHelper(cont);
    }

    @Named("meteorrepo")
    @Provides
    public MeteorRepo getRepo( DBHelper dbhelper,  ServiceImp service,
                             NetworkStateHelper nethelper,@Named("mainsched") Scheduler mainsched,
                               @Named("threadsched") Scheduler newscheduler)
    {
        return new MeteorRepoImp(dbhelper, service, nethelper, mainsched, newscheduler);
    }


}
