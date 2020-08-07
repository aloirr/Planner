package com.br.aloi.planner.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.br.aloi.planner.service.CustomerService;
import com.google.gson.Gson;

@Controller
public class GoogleMapApiController {

	@Autowired
	private CustomerService service;

	@GetMapping("/map")
	public ModelAndView map() throws IOException {
		ModelAndView mv = new ModelAndView();
		Gson gson = new Gson();
		String customersJSON = gson.toJson(service.findAll());
		mv.addObject("customers", customersJSON);
		mv.setViewName("/map");
		return mv;
	}

	@GetMapping("/map/{customerId}")
	public ModelAndView map(@PathVariable("customerId") Integer customerId) throws IOException {
		ModelAndView mv = new ModelAndView();
		Gson gson = new Gson();
		String customersJSON = gson.toJson(service.findByCustomerId(customerId));
		mv.addObject("customers", List.of(customersJSON));
		mv.setViewName("/map");
		return mv;
	}
}
