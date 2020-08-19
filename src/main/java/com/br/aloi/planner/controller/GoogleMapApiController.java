package com.br.aloi.planner.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		@RequestParam(value = "id", required = false) Optional<String> id)
		throws IOException {
	 ModelAndView mv = new ModelAndView();
	 if (id.isPresent()) {
		Optional<GenericModel> gModel = modelService.findById(Integer.parseInt(id.get()));
		mv.addObject("mapModels", new Gson().toJson(gModel.get()));
		mv.setViewName("/map");
		return mv;
	 } else {
		List<GenericModel> models = modelService.findAll();
		mv.addObject("mapModels", new Gson().toJson(models));
		mv.setViewName("/map");
		return mv;
	 }
  }
}
