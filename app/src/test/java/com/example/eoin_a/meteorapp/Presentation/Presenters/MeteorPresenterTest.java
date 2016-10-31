package com.example.eoin_a.meteorapp.Presentation.Presenters;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.Contract.MainView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.observers.Subscribers;
import rx.observers.TestSubscriber;

import static org.hamcrest.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eoin_a on 29/10/2016.
 */
public class MeteorPresenterTest {


    @Mock MeteorRepo mockmrepo;
    @Mock MainView mview;
    @Mock Observable obs;
    private MeteorPresenter mpresenter;


    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        mpresenter = new MeteorPresenter(mockmrepo);
        mpresenter.setView(mview);
    }

    @Test
    public void testUnSub()
    {
        mpresenter.Unsubscribe();
        verify(mockmrepo).unsubscribe();
    }


    private List<Meteor> getList()
    {
        List<Meteor>  mlist = new ArrayList<>();


        Meteor  meteor1 = new Meteor();
        meteor1.setName("cork");
        meteor1.setMass(11f);
        meteor1.setYear("1980");

        mlist.add(meteor1);
        return mlist;
    }

}