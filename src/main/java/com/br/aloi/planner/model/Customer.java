package com.br.aloi.planner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;

@SuppressWarnings("serial")
@Entity(name = "tbl_customer")
@AllArgsConstructor
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private Integer customerId;
	@Column
	private String sectorId;
	@Column
	private String placeId;
	@Column
	private String companyName;
	@Column
	private String tradeName;
	@Column
	private String place;
	@Column
	private String neighborhood;
	@Column
	private String city;
	@Column
	private String visitDay;
	@Column
	private String region;
	@Column
	private String latitude;
	@Column
	private String longitude;

	public Customer() {

	}

	public Customer(Integer id, Integer customerId, String sectorId, String placeId, String companyName,
			String tradeName, String place, String neighborhood, String city, String visitDay, String region,
			String latitude, String longitude) {
		this.id = id;
		this.customerId = customerId;
		this.sectorId = sectorId;
		this.placeId = placeId;
		this.companyName = companyName;
		this.tradeName = tradeName;
		this.place = place;
		this.neighborhood = neighborhood;
		this.city = city;
		this.visitDay = visitDay;
		this.region = region;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Customer(Integer customerId, String sectorId, String placeId, String companyName, String tradeName,
			String place, String neighborhood, String city, String visitDay, String region, String latitude,
			String longitude) {
		this.customerId = customerId;
		this.sectorId = sectorId;
		this.placeId = placeId;
		this.companyName = companyName;
		this.tradeName = tradeName;
		this.place = place;
		this.neighborhood = neighborhood;
		this.city = city;
		this.visitDay = visitDay;
		this.region = region;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Integer getId() {
		return id;
	}

	public Integer setId(Integer id) {
		return this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public Integer setCustomerId(Integer customerId) {
		return this.customerId = customerId;
	}

	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVisitDay() {
		return visitDay;
	}

	public void setVisitDay(String visitDay) {
		this.visitDay = visitDay;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
