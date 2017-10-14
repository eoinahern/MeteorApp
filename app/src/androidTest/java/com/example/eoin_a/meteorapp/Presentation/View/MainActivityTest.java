package com.example.eoin_a.meteorapp.Presentation.View;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.eoin_a.meteorapp.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by eoin_a on 18/11/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    ActivityTestRule<MainActivity> mainactivity = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testViews()
    {
        onView(withId(R.id.activity_main)).perform(click());
        onView(withId(R.id.activity_main)).check(matches(isDisplayed()));
    }

}