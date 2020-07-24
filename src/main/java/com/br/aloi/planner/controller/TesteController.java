package com.br.aloi.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.br.aloi.planner.service.CustomerService;

@Controller
public class TesteController {

	@Autowired
	private CustomerService service;

	@GetMapping("/teste")
	public ModelAndView teste() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/teste");
		return mv;
	}

	@GetMapping("/teste/{id}")
	public ModelAndView viewMap(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/teste");
		mv.addObject("customer", service.findById(id));
		return mv;
	}
}
