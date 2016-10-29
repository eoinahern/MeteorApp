package com.example.eoin_a.meteorapp.Presentation.DI.Components;

import com.example.eoin_a.meteorapp.Presentation.DI.Ascope;
import com.example.eoin_a.meteorapp.Presentation.DI.Modules.RepoModule;
import com.example.eoin_a.meteorapp.Presentation.Fragments.MeteorFragmentList;

import dagger.Component;

/**
 * Created by eoin_a on 29/10/2016.
 */


@Component(modules = RepoModule.class, dependencies = AppComponent.class )
public interface RepoComponent {
    void inject(MeteorFragmentList meteorfrag);
}
