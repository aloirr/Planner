package com.br.aloi.planner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;

@SuppressWarnings("serial")
@Entity(name = "tbl_csv")
@AllArgsConstructor
public class GenericModel implements Serializable {
  @Id
  private Integer id;
  @Column(length = 1024)
  @Size(max = 1024)
  private String attributes;

  public GenericModel() {

  }

  public Integer getId() {
	 return id;
  }

  public Integer setId(Integer id) {
	 return this.id = id;
  }

  public String getAttributes() {
	 return attributes;
  }

  public void setAttributes(String attributes) {
	 this.attributes = attributes;
  }

}
