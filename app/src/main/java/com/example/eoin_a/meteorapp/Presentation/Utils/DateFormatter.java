package com.example.eoin_a.meteorapp.Presentation.Utils;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eoin_a on 31/10/2016.
 */

public class DateFormatter {
	private SimpleDateFormat format;


	public DateFormatter() {
		format = new SimpleDateFormat("yyyy");
	}


	public String shortenFormat(String date) {
		Date newdate = null;

		try {
			newdate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return (String) DateFormat.format("yyyy", newdate);
	}
}
