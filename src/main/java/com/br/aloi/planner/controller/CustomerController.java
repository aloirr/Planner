package com.br.aloi.planner.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.aloi.planner.model.Customer;
import com.br.aloi.planner.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/planner")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/planner");
		mv.addObject("customers", service.findAll());
		return mv;
	}

	@GetMapping("/planner/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/customerEdit");
		mv.addObject("customer", service.findById(id));
		return mv;
	}

	@GetMapping("/planner/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return findAll();
	}

	@PostMapping("/planner/save")
	public ModelAndView save(@Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return edit(customer.getId());
		}
		service.save(customer);
		return findAll();
	}

}
