package com.br.aloi.planner.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.br.aloi.planner.model.MapsApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

@Service
public class MapsApiService {

	public static String getLat(String address) throws ApiException, InterruptedException, IOException {
		GeocodingResult[] results = GeocodingApi.geocode(MapsApi.getInstance().getContext(), address).await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(results[0].geometry.location.lat);
	}

	public static String getLng(String address) throws ApiException, InterruptedException, IOException {
		GeocodingResult[] results = GeocodingApi.geocode(MapsApi.getInstance().getContext(), address).await();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(results[0].geometry.location.lat);
	}
}
