package com.br.aloi.planner.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.br.aloi.planner.model.GenericModel;
import com.br.aloi.planner.model.ModelAttribute;
import com.br.aloi.planner.service.ModelService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.maps.errors.ApiException;

@Controller
public class CSVController {

  @Autowired
  private ModelService modelService;

  @GetMapping("/")
  public ModelAndView uploadFile(
		@RequestParam(value = "action", required = false) Optional<String> action) {
	 ModelAndView mv = new ModelAndView();
	 mv.setViewName("/uploadFile");
	 return mv;
  }

  @PostMapping("/saveUploadedFile")
  public ModelAndView saveUploadedFile(@RequestParam("destination") String destination,
		MultipartFile file) throws IOException, ApiException, InterruptedException {
	 modelService.deleteAll();
	 modelService.readCSVfile(file.getInputStream());
	 ModelAndView mv = new ModelAndView();
	 mv.setViewName("/planner");
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
