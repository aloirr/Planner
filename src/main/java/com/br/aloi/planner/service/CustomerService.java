package com.br.aloi.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.aloi.planner.model.Customer;
import com.br.aloi.planner.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Customer findById(Integer id) {
		return repository.findById(id).get();
	}

	public Customer save(Customer customer) {
		return repository.saveAndFlush(customer);
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
