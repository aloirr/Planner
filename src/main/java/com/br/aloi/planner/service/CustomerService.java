package com.br.aloi.planner.service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.aloi.planner.model.CustomerModel;
import com.br.aloi.planner.model.SalesmanModel;
import com.br.aloi.planner.repository.CustomerRepository;

@Service
public class CustomerService {

  CustomerModel customer = new CustomerModel();
  String sectorId;

  @Autowired
  private CustomerRepository repository;

  public Integer neighborhoodsSize(String attrValue) {
	 Integer result = Math.toIntExact(repository.findAll().stream().filter(s -> s
		  .getNeighborhood().equalsIgnoreCase(attrValue)).count());
	 return result;
  }

  public List<CustomerModel> findAll() {
	 return repository.findAll();
  }

  public CustomerModel findByCustomerId(Integer customerId) {
	 return repository.findByCustomerId(customerId);
  }

  public CustomerModel save(CustomerModel customer) {
	 if (repository.findByCustomerId(customer.getCustomerId()) == null) {
		return repository.saveAndFlush(customer);
	 } else {
		return null;
	 }
  }

  public void delete(Integer id) {
	 repository.deleteById(id);
  }

  public void clearDB() {
	 if (repository.count() > 0) {
		repository.deleteAll();
	 }
  }

  public void updateDB(List<SalesmanModel> salesmen) {
	 int index = 0;
	 long customersDBSize = repository.count();
	 List<CustomerModel> customers = repository.findAll();
	 while (index < customersDBSize) {
		sectorId = "";
		customer = customers.get(index);
		salesmen.parallelStream().filter(s -> Arrays.asList(s.getNeighborhoods().split(","))
			 .contains(customer.getNeighborhood())).forEach(s -> sectorId = s.getSectorId()
				  .toString());
		if (!sectorId.isEmpty()) {
		  System.out.println(sectorId);
		  customer.setSectorId(sectorId);
		  repository.save(customer);
		}
		index++;
	 }
	 repository.flush();
  }

  public List<CustomerModel> sortBy(List<CustomerModel> customers, String attribute) {
	 java.util.Comparator<CustomerModel> comparator;
	 switch (attribute) {
	 case "customerId":
		comparator = Comparator.comparing(CustomerModel::getCustomerId);
		break;
	 case "sectorId":
		comparator = Comparator.comparing(CustomerModel::getSectorId);
		break;
	 case "companyName":
		comparator = Comparator.comparing(CustomerModel::getCompanyName);
		break;
	 case "tradeName":
		comparator = Comparator.comparing(CustomerModel::getTradeName);
		break;
	 case "region":
		comparator = Comparator.comparing(CustomerModel::getRegion);
		break;
	 case "latitude":
		comparator = Comparator.comparing(CustomerModel::getLatitude);
		break;
	 case "longitude":
		comparator = Comparator.comparing(CustomerModel::getLongitude);
		break;
	 case "neighborhood":
		comparator = Comparator.comparing(CustomerModel::getNeighborhood);
		break;
	 case "place":
		comparator = Comparator.comparing(CustomerModel::getPlace);
		break;
	 case "city":
		comparator = Comparator.comparing(CustomerModel::getCity);
		break;
	 case "postalCode":
		comparator = Comparator.comparing(CustomerModel::getPostalCode);
		break;
	 default:
		comparator = Comparator.comparing(CustomerModel::getId);
		break;
	 }
	 Collections.sort(customers, comparator);
	 return customers;
  }
}
