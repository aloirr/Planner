package com.br.aloi.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.aloi.planner.model.SalesmanModel;
import com.br.aloi.planner.repository.SalesmanRepository;

@Service
public class SalesmanService {

	@Autowired
	private SalesmanRepository repository;

	public List<SalesmanModel> findAll() {
		return repository.findAll();
	}

	public SalesmanModel findBySectorId(Integer sectorId) {
		return repository.findBySectorId(sectorId);
	}

	public void deleteBySectorId(Integer sectorId) {
		if (repository.findBySectorId(sectorId) != null) {
			repository.deleteById(repository.findBySectorId(sectorId).getId());
		}
	}

	public void save(SalesmanModel salesman) {
		repository.saveAndFlush(salesman);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public void clearDB() {
		if (repository.count() > 0) {
			repository.deleteAll();
		}
	}

}
