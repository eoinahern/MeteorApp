package com.example.eoin_a.meteorapp.Presentation.Contract;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;

import java.util.List;

public interface MainView {
	void showloading(boolean loading);

	void showError();

	void displayMeteorList(List<Meteor> meteorlst);
}
