package com.example.eoin_a.meteorapp.Data;

import com.example.eoin_a.meteorapp.Data.DB.DBHelper;
import com.example.eoin_a.meteorapp.Data.Web.ServiceImp;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;
import rx.schedulers.TestScheduler;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eoin_a on 29/10/2016.
 */
public class MeteorRepoImpTest {

    @Mock private DBHelper mockdbhelper;
    @Mock private ServiceImp mockservice;
    @Mock private NetworkStateHelper mocknetstatus;
    private Scheduler mockmainsched;
    private Scheduler mockthreadsched;
    @Mock Call mockcall;

    //class under test
    private MeteorRepoImp meteorrepo;

    @Before
    public void setup()
    {

        mockmainsched = Schedulers.immediate();
        mockthreadsched = Schedulers.immediate();

        MockitoAnnotations.initMocks(this);
        meteorrepo = new MeteorRepoImp(mockdbhelper, mockservice,
                mocknetstatus, mockmainsched, mockthreadsched);
    }


    @Test
    public void testGetDataDBhelper()
    {
        when(mockdbhelper.checkEmpty()).thenReturn(false);
        when(mockdbhelper.getMeteorList()).thenReturn(Observable.just(getList()));
        meteorrepo.getData();

        verify(mockdbhelper).checkEmpty();
        verify(mockdbhelper).getMeteorList();
    }



    @Test
    public void testGetDataWebService()
    {
        when(mockdbhelper.checkEmpty()).thenReturn(true);
        when(mocknetstatus.checkNetworkConnected()).thenReturn(true);
        when(mockservice.getMeteors()).thenReturn(Observable.just(getList()));

        Observable<List<Meteor>> mobs = meteorrepo.getData();

        verify(mockdbhelper).checkEmpty();
        verify(mocknetstatus).checkNetworkConnected();
        verify(mockservice).getMeteors();
    }

    @Test
    public void testSubscription()
    {

        TestSubscriber<List<Meteor>>  testsub = new TestSubscriber<>();
        when(mockdbhelper.checkEmpty()).thenReturn(false);
        when(mockdbhelper.getMeteorList()).thenReturn(Observable.just(getList()));


        meteorrepo.subscribe(testsub);

        testsub.awaitTerminalEvent(5, TimeUnit.SECONDS);
        testsub.assertNoErrors();
        testsub.assertValueCount(1);


        List<List<Meteor>> list = testsub.getOnNextEvents();
        List<Meteor> mlist = list.get(0);

        verify(mockdbhelper).getMeteorList();
        verify(mockdbhelper).checkEmpty();


        Assert.assertEquals(2, mlist.size());
        Assert.assertEquals(12f, mlist.get(0).getMass());
    }


    //test helper method

    private List<Meteor> getList()
    {
        List<Meteor>  mlist = new ArrayList<>();


        Meteor  meteor1 = new Meteor();
        meteor1.setName("cork");
        meteor1.setMass(11f);
        meteor1.setYear("1980");

        Meteor  meteor2 = new Meteor();
        meteor1.setName("rome");
        meteor1.setMass(12f);
        meteor1.setYear("1992");

        mlist.add(meteor1);
        mlist.add(meteor2);
        return mlist;
    }

}