package com.br.aloi.planner.model;

public class ModelAttribute {

  private Long modelId;
  private String key;
  private String value;

  public ModelAttribute() {
  }

  public ModelAttribute(Long modelId, String key, String value) {
	 this.modelId = modelId;
	 this.key = key;
	 this.value = value;
  }

  public Long getModelId() {
	 return modelId;
  }

  public void setModelId(Long modelId) {
	 this.modelId = modelId;
  }

  public String getKey() {
	 return key;
  }

  public void setKey(String key) {
	 this.key = key;
  }

  public String getValue() {
	 return value;
  }

  public void setValue(String value) {
	 this.value = value;
  }

  @Override
  public String toString() {
	 return "ModelAttribute [modelId=" + modelId + ", key=" + key + ", value=" + value
		  + "]";
  }

}