package com.br.aloi.planner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tbl_neighborhoods")
public class NeighborhoodModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(unique = true, nullable = false)
  private String neighborhood;
  @Column
  private String disabled;
  @Column
  private String city;
  @Column
  private Integer neighborhoodSize;

  public NeighborhoodModel(String neighborhood, String disabled, String city,
		Integer neighborhoodSize) {
	 this.neighborhood = neighborhood;
	 this.disabled = disabled;
	 this.city = city;
	 this.neighborhoodSize = neighborhoodSize;
  }

  public NeighborhoodModel(Integer id, String neighborhood, String city,
		Integer neighborhoodSize) {
	 this.id = id;
	 this.neighborhood = neighborhood;
	 this.city = city;
	 this.neighborhoodSize = neighborhoodSize;
  }

  public NeighborhoodModel() {
  }

  public String getNeighborhood() {
	 return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
	 this.neighborhood = neighborhood;
  }

  public Integer getId() {
	 return id;
  }

  public String getDisabled() {
	 return disabled;
  }

  public void setDisabled(String disabled) {
	 this.disabled = disabled;
  }

  public String getCity() {
	 return city;
  }

  public void setCity(String city) {
	 this.city = city;
  }

  public Integer getNeighborhoodSize() {
	 return neighborhoodSize;
  }

  public void setNeighborhoodSize(Integer neighborhoodSize) {
	 this.neighborhoodSize = neighborhoodSize;
  }

  public void setId(Integer id) {
	 this.id = id;
  }

}
