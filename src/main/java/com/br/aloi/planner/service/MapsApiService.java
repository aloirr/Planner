package com.br.aloi.planner.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.br.aloi.planner.model.GoogleMapApiModel;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

@Service
public class MapsApiService {

	public static Double getLat(String address) throws ApiException, InterruptedException, IOException {
		GeocodingResult[] results = GeocodingApi.geocode(GoogleMapApiModel.getInstance().getContext(), address).await();
		return results.length > 0 ? results[0].geometry.location.lat : 0;
	}

	public static Double getLng(String address) throws ApiException, InterruptedException, IOException {
		GeocodingResult[] results = GeocodingApi.geocode(GoogleMapApiModel.getInstance().getContext(), address).await();
		return results.length > 0 ? results[0].geometry.location.lng : 0;
	}
}
