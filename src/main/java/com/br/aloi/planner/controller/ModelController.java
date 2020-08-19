package com.br.aloi.planner.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
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

import com.br.aloi.planner.model.GenericModel;
import com.br.aloi.planner.model.ModelAttribute;
import com.br.aloi.planner.service.ModelService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.maps.errors.ApiException;

@Controller
public class ModelController {

  @Autowired
  private ModelService modelService;
  @Autowired
  private GoogleMapApiController mapController;

  @GetMapping("/planner/edit/{id}")
  public ModelAndView edit(@PathVariable("{id}") Integer id) {
	 ModelAndView mv = new ModelAndView("/customerEdit");
	 mv.addObject("csvModel", modelService.findByAttribute("id", id.toString()));
	 return mv;
  }

  @GetMapping("/planner")
  public ModelAndView getPlanner(
		@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortParam,
		@RequestParam(value = "action", required = false) Optional<String> action,
		@RequestParam(value = "id", required = false) Optional<String> id)
		throws ApiException, InterruptedException, IOException {
	 action = action.isPresent() ? action : Optional.ofNullable("");
	 switch (action.get()) {
	 case "update":
		return getPlanner("id", null, null);
	 case "viewMap":
		if (id.get().matches("[0-9]*")) {
		  return mapController.map(id);
		} else {
		  return mapController.map(null);
		}
	 default:
		ModelAndView mv = new ModelAndView("/planner");
		List<GenericModel> models = modelService.findAll();
		List<String> headers = new ArrayList<>();
		Type baseType = new TypeToken<List<ModelAttribute>>() {
		}.getType();
		List<List<ModelAttribute>> modelsAttributes = new ArrayList<>();
		models.stream().forEach(m -> modelsAttributes.add(new Gson().fromJson(m
			 .getAttributes(), baseType)));
		modelsAttributes.get(0).forEach(attr -> {
		  if (attr.getModelId() == 0) {
			 headers.add(attr.getKey());
		  }
		});
		mv.addObject("headers", headers);
		mv.addObject("models", models);
		mv.addObject("modelsAttributes", modelsAttributes);
		return mv;
	 }

  }

  @GetMapping("/planner/delete/{id}")
  public ModelAndView delete(@PathVariable("id") Integer id) throws ApiException,
		InterruptedException, IOException {
	 modelService.delete(modelService.findByAttribute("id", id).get(0));
	 return getPlanner("id", null, null);
  }

  @PostMapping("/planner/save")
  public ModelAndView save(@Valid GenericModel customer, BindingResult result)
		throws ApiException, InterruptedException, IOException {
	 if (result.hasErrors()) {
		return edit(customer.getId());
	 }
	 modelService.save(customer);
	 return getPlanner("id", null, null);
  }

  @PostMapping("/planner")
  public ModelAndView postPlanner(
		@RequestParam(value = "action", required = false) String action,
		@RequestParam(value = "id", required = false) Optional<Integer> id)
		throws ApiException, InterruptedException, IOException {
	 return getPlanner("id", null, null);

  }
}
