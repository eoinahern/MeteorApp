package com.example.eoin_a.meteorapp.Presentation.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Presentation.Contract.MainView;
import com.example.eoin_a.meteorapp.R;

import java.util.List;


public class MeteorFragmentList extends Fragment implements MainView {

   // @BindView(R.id.progbar)
     ProgressBar progbar;



    public static MeteorFragmentList getInst()
    {
        MeteorFragmentList mfrag = new MeteorFragmentList();
        return mfrag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_meteor_fragment_list, container, false);
        return v;
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
    public void displayMeteorList(List<Meteor> meteorlst) {

    }
}
