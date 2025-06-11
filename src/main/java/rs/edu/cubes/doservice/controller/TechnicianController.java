package rs.edu.cubes.doservice.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import rs.edu.cubes.doservice.model.*;
import rs.edu.cubes.doservice.service.TechnicianService;
import rs.edu.cubes.doservice.service.TechnicianSpecializationService;

@Controller
@RequestMapping("/technicians")
public class TechnicianController {
	
	
	private TechnicianService techinicanService;
	private TechnicianSpecializationService technicianSpecializationService;

	public TechnicianController(TechnicianService techinicanService, TechnicianSpecializationService technicianSpecializationService) {
		this.techinicanService = techinicanService;
		this.technicianSpecializationService = technicianSpecializationService;
	}
	
	
	@GetMapping
	public String getTechniciansPage(Model model) {
		
		model.addAttribute("technicians", techinicanService.getAllTechnicians());
		
		
		return "technicians";
	}
	
	
	@GetMapping("/add")
	public String getTechniciansFormPage(Model model) {
		
		
		
		model.addAttribute("technician", new Technician());
		model.addAttribute("statuses", TechnicianStatus.values());
		model.addAttribute("specializations", technicianSpecializationService.getAllTechnicianSpecializations());
		
		return "technicians-form";
	}
	
	
	@GetMapping("/update/{id}")
	public String getTechniciansUpdateFormPage(@PathVariable int id, Model model) {
		
		model.addAttribute("technician", techinicanService.getTechnician(id));
		model.addAttribute("statuses", TechnicianStatus.values());
		model.addAttribute("specializations", technicianSpecializationService.getAllTechnicianSpecializations());
		
		return "technicians-form";
	}
	
	@PostMapping("/save")
	public String getTechniciansSave(@Valid @ModelAttribute Technician technician ,BindingResult result) {
		
		if(result.hasErrors()) {
			return "technicians-form";
		}
		
		techinicanService.saveTechnician(technician);
		
		return "redirect:/technicians";
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteTechnician(@PathVariable int id) {
		
		techinicanService.deleteTechnician(id);
		
		return "redirect:/technicians";
	}

}
