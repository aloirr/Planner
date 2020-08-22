package com.br.aloi.planner.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.aloi.planner.model.GenericModel;
import com.br.aloi.planner.service.ModelService;
import com.google.gson.Gson;

@Controller
public class GoogleMapApiController {

  @Autowired
  private ModelService modelService;

  @GetMapping("/map")
  public ModelAndView map(
		@RequestParam(value = "id", required = false) Optional<Long> id)
		throws IOException {
	 ModelAndView mv = new ModelAndView();
	 if (id.isPresent()) {
		Optional<GenericModel> gModel = modelService.findById(id.get());
		mv.addObject("mapModels", new Gson().toJson(gModel.get()));
		mv.setViewName("map");
		System.out.println("GETMAP VER 1 CLIENTE MAPA");
		return mv;
	 } else {
		List<GenericModel> models = modelService.findAll();
		mv.addObject("mapModels", new Gson().toJson(models));
		mv.setViewName("map");
		System.out.println("GETMAP VER TODOS OS CLIENTES NO MAPA");
		return mv;
	 }
  }
  @PostMapping("/map")
  public ModelAndView postMap(
		@RequestParam(value = "id", required = false) Optional<Long> id)
		throws IOException {
	 ModelAndView mv = new ModelAndView();
	 if (id.isPresent()) {
		Optional<GenericModel> gModel = modelService.findById(id.get());
		System.out.println("POSTMAP VER 1 CLIENTE NO MAPA");
		mv.addObject("mapModels", new Gson().toJson(gModel.get()));
		mv.setViewName("map");
		return mv;
	 } else {
		List<GenericModel> models = modelService.findAll();
		mv.addObject("mapModels", new Gson().toJson(models));
		mv.setViewName("map");
		System.out.println("POSTMAP VER TODOS OS CLIENTES NO MAPA");
		return mv;
	 }
  }
}
