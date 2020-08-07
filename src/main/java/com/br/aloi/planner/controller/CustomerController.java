package com.br.aloi.planner.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.aloi.planner.model.CustomerModel;
import com.br.aloi.planner.service.CustomerService;
import com.br.aloi.planner.service.SalesmanService;

@Controller
public class CustomerController {

  @Autowired
  private CustomerService service;
  @Autowired
  private SalesmanService Sservice;

//	@GetMapping("/planner")
//	public ModelAndView findAll() {
//		ModelAndView mv = new ModelAndView("/planner");
//		mv.addObject("customers", service.findAll());
//		return mv;
//	}

  @GetMapping("/planner/edit/{customerId}")
  public ModelAndView edit(@PathVariable("customerId") Integer customerId) {
	 ModelAndView mv = new ModelAndView("/customerEdit");
	 mv.addObject("customer", service.findByCustomerId(customerId));
	 return mv;
  }

  @GetMapping("/planner")
  public ModelAndView getPlanner(
		@RequestParam(value = "sortBy", defaultValue = "customerId", required = false) String param,
		@RequestParam(value = "action", required = false) Optional<String> action) {
	 ModelAndView mv = new ModelAndView("/planner");
	 List<CustomerModel> customers = service.findAll();
	 mv.addObject("customers", service.sortBy(customers, param));
	 return mv;
  }

  @GetMapping("/planner/delete/{id}")
  public ModelAndView delete(@PathVariable("id") Integer id) {
	 service.delete(id);
	 return getPlanner("id", null);
  }

  @PostMapping("/planner/save")
  public ModelAndView save(@Valid CustomerModel customer, BindingResult result) {
	 if (result.hasErrors()) {
		return edit(customer.getId());
	 }
	 service.save(customer);
	 return getPlanner("id", null);
  }

  @PostMapping("/planner")
  public ModelAndView postPlanner(
		@RequestParam(value = "action", required = false) String action) {
	 if (action.equalsIgnoreCase("update")) {
		service.updateDB(Sservice.findAll());
	 }
	 return getPlanner("id", null);
  }
}
