package com.example.eoin_a.meteorapp.Presentation.Utils;

/**
 * Created by eoin_a on 31/10/2016.
 */

public class StringFormatter {

    public StringFormatter()
    {

    }


    public String abbreviateString(String title)
    {
        if(title.length() <= 15)
        {
           return title;
        }

        return title.substring(0,11) + "...";
    }
}
