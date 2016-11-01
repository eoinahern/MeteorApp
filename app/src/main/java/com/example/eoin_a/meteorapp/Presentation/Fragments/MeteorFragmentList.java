package com.example.eoin_a.meteorapp.Presentation.Fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.MeteorApplication;
import com.example.eoin_a.meteorapp.Presentation.Adapters.MeteorRecviewAdpt;
import com.example.eoin_a.meteorapp.Presentation.Contract.MainView;

import com.example.eoin_a.meteorapp.Presentation.DI.Components.AppComponent;
import com.example.eoin_a.meteorapp.Presentation.DI.Components.DaggerRepoComponent;
import com.example.eoin_a.meteorapp.Presentation.DI.Components.RepoComponent;
import com.example.eoin_a.meteorapp.Presentation.DI.Modules.RepoModule;
import com.example.eoin_a.meteorapp.Presentation.Listeners.ItemClicked;
import com.example.eoin_a.meteorapp.Presentation.Navigation.NavigationCommand;
import com.example.eoin_a.meteorapp.Presentation.Navigation.ToMapActivity;
import com.example.eoin_a.meteorapp.Presentation.Presenters.MeteorPresenter;
import com.example.eoin_a.meteorapp.R;

import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MeteorFragmentList extends Fragment implements MainView, ItemClicked {

    @Inject MeteorPresenter mpresenter;
    @BindView(R.id.progbar) ProgressBar progbar;
    @BindView(R.id.recycler_view) RecyclerView recview;
    @BindView(R.id.nodata) TextView nodatatxt;

    private MeteorRecviewAdpt meteoradpt;
    private LinearLayoutManager llmanager;
    private List<Meteor> mlist;
    private NavigationCommand tomapnaigation;

    public static MeteorFragmentList getInst()
    {
        MeteorFragmentList mfrag = new MeteorFragmentList();
        return mfrag;
    }

    @Override
    public void onCreate(Bundle sistate) {
        super.onCreate(sistate);

        //bit of boilerplate involved here!!

        MeteorApplication mapp = (MeteorApplication) getActivity().getApplication();
        AppComponent appcomp = mapp.getAppcomponent();
        RepoModule repomod = new RepoModule();

        RepoComponent repocomp = DaggerRepoComponent.builder()
                .repoModule(repomod)
                .appComponent(appcomp)
                .build();

        repocomp.inject(this);
        llmanager = new LinearLayoutManager(getActivity().getBaseContext());
        tomapnaigation = new ToMapActivity(getActivity());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meteor_fragment_list, container, false);
        ButterKnife.bind(this, v);
        mpresenter.setView(this);
        return v;
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState){
        mpresenter.GetMeteorList();
    }


    @Override
    public void showloading(boolean loading) {

        if(loading) {
            progbar.setVisibility(View.VISIBLE);
            return;
            }

        progbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError() {
        nodatatxt.setVisibility(View.VISIBLE);
        showloading(false);
    }

    @Override
    public void displayMeteorList(List<Meteor> meteorlst) {

        mlist = meteorlst;
        nodatatxt.setVisibility(View.INVISIBLE);
        recview.setLayoutManager(llmanager);
        meteoradpt = new MeteorRecviewAdpt(mlist, this);
        recview.setAdapter(meteoradpt);
    }


    @Override
    public void onDestroy()
    {
        super.onDestroy();
        mpresenter.Unsubscribe();
    }


    @Override
    public void viewClicked(View v, int position) {
        Log.d("item clicked", String.valueOf(position));
        tomapnaigation.navigate();
    }
}
