package com.br.aloi.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.aloi.planner.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByCustomerId(Integer customerId);
}
