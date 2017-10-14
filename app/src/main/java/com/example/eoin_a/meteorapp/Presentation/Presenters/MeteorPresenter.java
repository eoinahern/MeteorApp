package com.example.eoin_a.meteorapp.Presentation.Presenters;

import android.util.Log;

import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.Contract.MainPresenter;
import com.example.eoin_a.meteorapp.Presentation.Contract.MainView;
import com.example.eoin_a.meteorapp.Presentation.Navigation.NavigationCommand;
import com.example.eoin_a.meteorapp.Presentation.Navigation.ToMapActivity;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscriber;

/**
 * Created by eoin_a on 28/10/2016.
 */

public class MeteorPresenter implements MainPresenter {

	private MainView mview;
	private MeteorRepo mrepo;
	private NavigationCommand mapnavigation;

	@Inject
	public MeteorPresenter(@Named("meteorrepo") MeteorRepo mrepo) {
		this.mrepo = mrepo;

	}

	public void setView(MainView mview) {
		this.mview = mview;
	}

	public void GetMeteorList() {
		mrepo.subscribe(new MeteorSubscriber());
	}


	public class MeteorSubscriber extends Subscriber<List<Meteor>> {
		@Override
		public void onCompleted() {
			mview.showloading(false);
		}

		@Override
		public void onError(Throwable e) {
			e.printStackTrace();
			mview.showError();
		}

		@Override
		public void onNext(List<Meteor> meteors) {

			Log.d("len", String.valueOf(meteors.size()));

			if (mrepo.checkEmpty())
				mrepo.saveData(meteors);

			Collections.sort(meteors, Collections.reverseOrder());
			mview.displayMeteorList(meteors);
		}
	}


	public void Unsubscribe() {
		mrepo.unsubscribe();
	}

}
