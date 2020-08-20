package com.br.aloi.planner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tbl_map")
public class MapModel {

  @Id
  Integer modelId;
  @Column
  String latitude;
  @Column
  String longitute;
  @Column(length = 1024)
  String jsonData;

  public MapModel(Integer modelId, String latitude, String longitute, String jsonData) {
	 this.modelId = modelId;
	 this.latitude = latitude;
	 this.longitute = longitute;
	 this.jsonData = jsonData;
  }

  public MapModel() {
  }

  public Integer getModelId() {
	 return modelId;
  }

  public void setModelId(Integer modelId) {
	 this.modelId = modelId;
  }

  public String getLatitude() {
	 return latitude;
  }

  public void setLatitude(String latitude) {
	 this.latitude = latitude;
  }

  public String getLongitute() {
	 return longitute;
  }

  public void setLongitute(String longitute) {
	 this.longitute = longitute;
  }

  public String getJsonData() {
	 return jsonData;
  }

  public void setJsonData(String jsonData) {
	 this.jsonData = jsonData;
  }

}
