//package com.br.aloi.planner.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.br.aloi.planner.model.NeighborhoodModel;
//import com.br.aloi.planner.repository.NeighborhoodRepository;
//
//@Service
//public class NeighborhoodService {
//
//  @Autowired
//  NeighborhoodRepository repository;
//
//  public NeighborhoodModel findByNeighborhood(String neighborhood) {
//	 return repository.findByNeighborhood(neighborhood);
//  }
//
//  public List<NeighborhoodModel> findAll() {
//	 return repository.findAll();
//  }
//
//  public void saveAll() {
//	 repository.findAll().parallelStream().forEach(s -> repository.saveAndFlush(s));
//  }
//
//  public void save(NeighborhoodModel neighborhood) {
//	 Optional<Integer> id = Optional.ofNullable(neighborhood.getId());
//	 if (id.isPresent()) {
//		repository.saveAndFlush(neighborhood);
//		System.out.println("IF ZERO");
//	 } else if (repository.findByNeighborhood(neighborhood.getNeighborhood()) == null) {
//		repository.saveAndFlush(neighborhood);
//		System.out.println("PRIMEIRO IF");
//	 } else if ((repository.findAll().stream().filter(s -> s.getCity().equalsIgnoreCase(
//		  neighborhood.getCity())).count()) == 0) {
//		repository.saveAndFlush(neighborhood);
//		System.out.println("SEGUNDO IF");
//	 } else {
//		System.out.println("ELSE");
//	 }
//  }
//
//  public void delete(Integer id) {
//	 repository.deleteById(id);
//  }
//
//  public void deleteAll() {
//	 if (repository.count() > 0) {
//		repository.deleteAll();
//	 }
//  }
//}
