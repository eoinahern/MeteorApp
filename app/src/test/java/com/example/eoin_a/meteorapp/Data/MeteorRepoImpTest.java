package com.example.eoin_a.meteorapp.Data;

import com.example.eoin_a.meteorapp.Data.DB.DBHelper;
import com.example.eoin_a.meteorapp.Data.Web.ServiceImp;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Presentation.Utils.NetworkStateHelper;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by eoin_a on 29/10/2016.
 */
public class MeteorRepoImpTest {


    @Mock private DBHelper mockdbhelper;
    @Mock private ServiceImp mockservice;
    @Mock private NetworkStateHelper mocknetstatus;
    @Mock Call mockcall;

    //class under test
    private MeteorRepoImp meteorrepo;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        meteorrepo = new MeteorRepoImp(mockdbhelper, mockservice, mocknetstatus);
    }


    @Test
    public void testGetDataDBhelper()
    {
        when(mockdbhelper.checkEmpty()).thenReturn(false);
        when(mockdbhelper.getMeteorList()).thenReturn(getList());

        List<Meteor> mlist = meteorrepo.getData();

        verify(mockdbhelper).checkEmpty();
        verify(mockdbhelper).getMeteorList();

        Assert.assertEquals(2, mlist.size());
        Assert.assertEquals("rome", mlist.get(0).getName());
    }


    //check is netstatus return network available!

    @Test
    public void testGetDataDBHelper()
    {

        when(mockdbhelper.checkEmpty()).thenReturn(false);
        when(mockdbhelper.getMeteorList()).thenReturn(getList());

        List<Meteor> mlist = meteorrepo.getData();

        verify(mockdbhelper).checkEmpty();
        verify(mockdbhelper).getMeteorList();

        Assert.assertEquals(2, mlist.size());

    }


    @Test
    public void testGetDataWebService()
    {
        when(mockdbhelper.checkEmpty()).thenReturn(true);
        when(mocknetstatus.checkNetworkConnected()).thenReturn(true);
        when(mockservice.getMeteors()).thenReturn(mockcall);

        List<Meteor> mlist = meteorrepo.getData();

        verify(mockdbhelper).checkEmpty();
        verify(mocknetstatus).checkNetworkConnected();
        verify(mockservice).getMeteors();
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