//package com.br.aloi.planner.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.br.aloi.planner.model.CSVModel;
//import com.br.aloi.planner.model.SalesmanModel;
//import com.br.aloi.planner.repository.CustomerRepository;
//
//@Service
//public class CustomerService {
//
//  CSVModel customer = new CSVModel();
//  String sectorId;
//
//  @Autowired
//  private CustomerRepository repository;
//
//  public Integer neighborhoodsSize(String attrValue) {
//	 Integer result = 0;
//	 return result;
//  }
//
//  public List<CSVModel> findAll() {
//	 return repository.findAll();
//  }
//
//  public CSVModel findByCustomerId(Integer customerId) {
//	 return null;
//  }
//
//  public CSVModel save(CSVModel customer) {
//	 return repository.saveAndFlush(customer);
//
//  }
//
//  public void delete(Integer id) {
//	 repository.deleteById(id);
//  }
//
//  public void clearDB() {
//	 if (repository.count() > 0) {
//		repository.deleteAll();
//	 }
//  }
//
//  public void updateDB(List<SalesmanModel> salesmen) {
////	 int index = 0;
////	 long customersDBSize = repository.count();
////	 List<CSVModel> customers = repository.findAll();
////	 while (index < customersDBSize) {
////		sectorId = "";
////		customer = customers.get(index);
////		salesmen.parallelStream().filter(s -> Arrays.asList(s.getNeighborhoods().split(","))
////			 .contains(customer.getNeighborhood())).forEach(s -> sectorId = s.getSectorId()
////				  .toString());
////		if (!sectorId.isEmpty()) {
////		  System.out.println(sectorId);
////		  customer.setSectorId(sectorId);
////		  repository.save(customer);
////		}
////		index++;
////	 }
////	 repository.flush();
//  }
//
//  public List<CSVModel> sortBy(List<CSVModel> customers, String attribute) {
////	 java.util.Comparator<CSVModel> comparator;
////	 switch (attribute) {
////	 case "customerId":
////		comparator = Comparator.comparing(CSVModel::getCustomerId);
////		break;
////	 case "sectorId":
////		comparator = Comparator.comparing(CSVModel::getSectorId);
////		break;
////	 case "companyName":
////		comparator = Comparator.comparing(CSVModel::getCompanyName);
////		break;
////	 case "tradeName":
////		comparator = Comparator.comparing(CSVModel::getTradeName);
////		break;
////	 case "region":
////		comparator = Comparator.comparing(CSVModel::getRegion);
////		break;
////	 case "latitude":
////		comparator = Comparator.comparing(CSVModel::getLatitude);
////		break;
////	 case "longitude":
////		comparator = Comparator.comparing(CSVModel::getLongitude);
////		break;
////	 case "neighborhood":
////		comparator = Comparator.comparing(CSVModel::getNeighborhood);
////		break;
////	 case "place":
////		comparator = Comparator.comparing(CSVModel::getPlace);
////		break;
////	 case "city":
////		comparator = Comparator.comparing(CSVModel::getCity);
////		break;
////	 case "postalCode":
////		comparator = Comparator.comparing(CSVModel::getPostalCode);
////		break;
////	 default:
////		comparator = Comparator.comparing(CSVModel::getId);
////		break;
////	 }
////	 Collections.sort(customers, comparator);
////	 return customers;
//	 return null;
//  }
//}
