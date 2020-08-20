//package com.br.aloi.planner.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.br.aloi.planner.model.CSVModelAttributes;
//import com.br.aloi.planner.repository.CSVModelAttributesRepository;
//
//@Service
//public class CSVModelAttributesService {
//
//  @Autowired
//  CSVModelAttributesRepository repository;
//
//  public List<CSVModelAttributes> findAllByModelId(Integer modelId) {
//	 return repository.findAllByModelId(modelId);
//  }
//
//  public List<CSVModelAttributes> findAll() {
//	 return repository.findAll();
//  }
//
//  public void deleteAll() {
//	 if (repository.count() > 0) {
//		repository.deleteAll();
//	 }
//  }
//
//}
