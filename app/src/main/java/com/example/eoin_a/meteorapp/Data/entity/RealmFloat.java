package com.example.eoin_a.meteorapp.Data.entity;

import io.realm.RealmObject;

/**
 * unfortunately realm currently wont support
 * a list or array of primatives in a realm object.
 */

public class RealmFloat extends RealmObject {

	private float value;

	public RealmFloat() {

	}

	public float getValue() {
		return value;
	}
}
