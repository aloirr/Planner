package com.br.aloi.planner.model;

import com.google.maps.GeoApiContext;

public class GoogleMapApiModel {
	private static GoogleMapApiModel instance = new GoogleMapApiModel();
	private GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDFoB8O3Z9lEQ4E8Xfhi5qfUKNVC4sfq-w")
			.build();

	private GoogleMapApiModel() {
		// private to prevent anyone else from instantiating
	}

	public static GoogleMapApiModel getInstance() {
		return instance;
	}

	public GeoApiContext getContext() {
		return context;
	}
}
