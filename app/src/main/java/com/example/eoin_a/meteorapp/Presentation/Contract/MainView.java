package com.example.eoin_a.meteorapp.Presentation.Contract;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.List;

/**
 * Created by eoin_a on 27/10/2016.
 */

public interface MainView {
    void showloading(boolean loading);
    void showError();
    void displayMeteorList(List<Meteor> meteorlst);
}
