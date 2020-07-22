package com.br.aloi.planner.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.br.aloi.planner.service.CSVService;
import com.br.aloi.planner.service.CustomerService;
import com.br.aloi.planner.service.MapsApiService;
import com.google.maps.errors.ApiException;

@Controller
public class CSVController {

	@Autowired
	private CSVService csvService;
	@Autowired
	private CustomerService customerService;

	@GetMapping("/uploadFile")
	public ModelAndView uploadFile() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/uploadFile");
		return mv;
	}

	@PostMapping("/saveUploadedFile")
	public ModelAndView saveUploadedFile(@RequestParam("destination") String destination, MultipartFile file)
			throws IOException, ApiException, InterruptedException {
		customerService.clearDB();
		csvService.CSVReadAutoGetHeaders(file.getInputStream());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/planner");
		mv.addObject("customers", customerService.findAll());
		return mv;
	}

}
