//package com.br.aloi.planner.controller;
//
//import java.util.Arrays;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.br.aloi.planner.model.SalesmanModel;
//import com.br.aloi.planner.service.NeighborhoodService;
//import com.br.aloi.planner.service.SalesmanService;
//
//@Controller
//public class SalesmanController {
//
//  @Autowired
//  SalesmanService service;
//  @Autowired
//  NeighborhoodService serviceNeighborhood;
//
////	@GetMapping("/createSalesman")
////	public ModelAndView createSalesmanGet() {
////		ModelAndView mv = new ModelAndView();
////		SalesmanModel salesman = new SalesmanModel();
////		NeighborhoodModel neighborhood = new NeighborhoodModel("Cidadao");
////		serviceNeighborhood.save(neighborhood);
////		mv.setViewName("/createSalesman");
////		mv.addObject("salesmen", service.findAll());
////		mv.addObject("salesman", salesman);
////		mv.addObject("neighborhoods", serviceNeighborhood.findAll());
////		return mv;
////	}
//
//  @PostMapping("/createSalesman")
//  public ModelAndView createSalesmanPost(@Valid SalesmanModel salesman,
//		@RequestParam(value = "action", required = false) String action,
//		@RequestParam(value = "sectorId", required = false) Integer sectorId) {
//	 ModelAndView mv = new ModelAndView();
//	 SalesmanModel salesmanModel = new SalesmanModel();
//	 serviceNeighborhood.findAll().forEach(s -> s.setDisabled("false"));
//	 switch (action) {
//	 case "save":
//		salesmanModel = service.findBySectorId(sectorId);
//		if (salesmanModel != null) {
//		  salesman.setId(salesmanModel.getId());
//		}
//		service.save(salesman);
//		service.findAll().stream().forEach(sm -> Arrays.asList(sm.getNeighborhoods().split(
//			 ",")).stream().forEach(s -> serviceNeighborhood.findByNeighborhood(s)
//				  .setDisabled("true")));
//		salesmanModel = new SalesmanModel();
//		serviceNeighborhood.saveAll();
//		mv.addObject("salesman", salesmanModel);
//		mv.addObject("salesmen", service.findAll());
//		mv.addObject("neighborhoods", serviceNeighborhood.findAll());
//		mv.setViewName("/createSalesman");
//		break;
//	 case "edit":
//		salesmanModel = service.findBySectorId(sectorId);
//		service.findAll().stream().forEach(sm -> Arrays.asList(sm.getNeighborhoods().split(
//			 ",")).stream().forEach(s -> serviceNeighborhood.findByNeighborhood(s)
//				  .setDisabled("true")));
//		serviceNeighborhood.saveAll();
//		mv.addObject("salesman", salesmanModel);
//		mv.addObject("salesmen", service.findAll());
//		mv.addObject("neighborhoods", serviceNeighborhood.findAll());
//		mv.setViewName("/createSalesman");
//		break;
//	 case "delete":
//		service.findAll().stream().forEach(sm -> Arrays.asList(sm.getNeighborhoods().split(
//			 ",")).stream().forEach(s -> serviceNeighborhood.findByNeighborhood(s)
//				  .setDisabled("true")));
//		Arrays.asList(service.findBySectorId(sectorId).getNeighborhoods().split(","))
//			 .stream().forEach(s -> serviceNeighborhood.findByNeighborhood(s).setDisabled(
//				  "false"));
//		service.deleteBySectorId(sectorId);
//		serviceNeighborhood.saveAll();
//		mv.addObject("salesman", salesmanModel);
//		mv.addObject("salesmen", service.findAll());
//		mv.addObject("neighborhoods", serviceNeighborhood.findAll());
//		mv.setViewName("/createSalesman");
//		break;
//	 case "view":
//		service.findAll().stream().forEach(sm -> Arrays.asList(sm.getNeighborhoods().split(
//			 ",")).stream().forEach(s -> serviceNeighborhood.findByNeighborhood(s)
//				  .setDisabled("true")));
//		serviceNeighborhood.saveAll();
//		mv.addObject("salesman", salesmanModel);
//		mv.addObject("salesmen", service.findAll());
//		mv.addObject("neighborhoods", serviceNeighborhood.findAll());
//		mv.setViewName("/createSalesman");
//	 }
//	 return mv;
//
//  }
//}
