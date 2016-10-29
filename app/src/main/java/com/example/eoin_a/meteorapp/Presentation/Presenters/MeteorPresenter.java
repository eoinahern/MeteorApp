package com.example.eoin_a.meteorapp.Presentation.Presenters;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.Contract.MainPresenter;
import com.example.eoin_a.meteorapp.Presentation.Contract.MainView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by eoin_a on 28/10/2016.
 */

public class MeteorPresenter implements MainPresenter {

    private MainView mview;
    private MeteorRepo  mrepo;

    @Inject
    public MeteorPresenter(MeteorRepo mrepo)
    {
        this.mrepo = mrepo;
    }

    public void setView(MainView mview)
    {
        this.mview = mview;
    }


    public void GetMeteorList()
    {
         mview.showloading(true);
         List<Meteor> meteorlst = mrepo.getData();

        if(meteorlst == null || meteorlst.size() == 0)
        {
            mview.showError();
            return;
        }

        mview.displayMeteorList(meteorlst);
    }
}
