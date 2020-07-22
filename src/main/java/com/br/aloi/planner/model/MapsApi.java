package com.br.aloi.planner.model;

import com.google.maps.GeoApiContext;

public class MapsApi {
	private static MapsApi instance = new MapsApi();
	private GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyDFoB8O3Z9lEQ4E8Xfhi5qfUKNVC4sfq-w")
			.build();

	private MapsApi() {
		// private to prevent anyone else from instantiating
	}

	public static MapsApi getInstance() {
		return instance;
	}

	public GeoApiContext getContext() {
		return context;
	}
}
