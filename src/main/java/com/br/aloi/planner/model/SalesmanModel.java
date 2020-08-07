package com.br.aloi.planner.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity(name = "tbl_salesman")
public class SalesmanModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true, nullable = false)
	private Integer sectorId;
	@Column(nullable = false)
	private Integer baseSize;
	@Column(nullable = false)
	private Integer baseSizeDay;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String neighborhoods;

	public SalesmanModel(Integer id, Integer sectorId, Integer baseSize, Integer baseSizeDay, String name,
			String neighborhoods) {
		this.id = id;
		this.sectorId = sectorId;
		this.baseSize = baseSize;
		this.baseSizeDay = baseSizeDay;
		this.name = name;
		this.neighborhoods = neighborhoods;
	}

	public SalesmanModel(Integer sectorId, Integer baseSize, Integer baseSizeDay, String name, String neighborhoods) {
		this.sectorId = sectorId;
		this.baseSize = baseSize;
		this.baseSizeDay = baseSizeDay;
		this.name = name;
		this.neighborhoods = neighborhoods;
	}

	public SalesmanModel() {
	}

	public Integer getSectorId() {
		return sectorId;
	}

	public void setSectorId(Integer sectorId) {
		this.sectorId = sectorId;
	}

	public Integer getBaseSize() {
		return baseSize;
	}

	public void setBaseSize(Integer baseSize) {
		this.baseSize = baseSize;
	}

	public Integer getBaseSizeDay() {
		return baseSizeDay;
	}

	public void setBaseSizeDay(Integer baseSizeDay) {
		this.baseSizeDay = baseSizeDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNeighborhoods() {
		return neighborhoods;
	}

	public void setNeighborhoods(String neighborhoods) {
		this.neighborhoods = neighborhoods;
	};

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
