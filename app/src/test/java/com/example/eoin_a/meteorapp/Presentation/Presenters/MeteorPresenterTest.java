package com.example.eoin_a.meteorapp.Presentation.Presenters;

import com.example.eoin_a.meteorapp.Data.MeteorRepoImp;
import com.example.eoin_a.meteorapp.Data.entity.Meteor;
import com.example.eoin_a.meteorapp.Domain.MeteorRepo;
import com.example.eoin_a.meteorapp.Presentation.Contract.MainView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
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
    private MeteorPresenter mpresenter;


    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        mpresenter = new MeteorPresenter(mockmrepo);
        mpresenter.setView(mview);

    }

    @Test
    public void testMeteorList()
    {
        when(mockmrepo.getData()).thenReturn(getList());
        mpresenter.GetMeteorList();
        verify(mview).showloading(anyBoolean());
        verify(mview).displayMeteorList(anyList());
    }

    @Test
    public void testReporeturnEmpty(){

        when(mockmrepo.getData()).thenReturn(new ArrayList<Meteor>());
        mpresenter.GetMeteorList();

        verify(mockmrepo).getData();
        verify(mview).showloading(true);
        verify(mview).showError();
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